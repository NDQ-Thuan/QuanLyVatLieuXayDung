package component.PanelForMainMenu;

import customTable.TableCustom;
import java.awt.Color;
import java.awt.Point;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import model.DAO.KhoHangChiTietDAO;
import model.DAO.KhoHangDAO;
import model.Object.NhaCungCap;
import model.DAO.NhaCungCapDAO;
import model.Object.SanPham;
import model.DAO.SanPhamDAO;
import swing.MainMenu;

public final class PanelSupplier extends ConnectionPanel {

    private int index = -1;
    private DefaultTableModel modelTblSupplier;
    private DefaultTableModel modelTblSuppProduct;

    private NhaCungCapDAO nccDAO;
    private SanPhamDAO spDAO;
    private KhoHangDAO khoHangDAO;
    private KhoHangChiTietDAO khctDAO;

    public PanelSupplier() {
        initComponents();
        modelTblSupplier = (DefaultTableModel) tblSuppliers.getModel();
        modelTblSuppProduct = (DefaultTableModel) tblSuppProduct.getModel();

        TableColumnModel columnModelTblSupplier = tblSuppliers.getColumnModel();

        columnModelTblSupplier.getColumn(0).setPreferredWidth(25);
        columnModelTblSupplier.getColumn(1).setPreferredWidth(150);
        columnModelTblSupplier.getColumn(2).setPreferredWidth(100);
        columnModelTblSupplier.getColumn(3).setPreferredWidth(60);

        TableColumnModel columnModelTblSupplieProduct = tblSuppProduct.getColumnModel();

        columnModelTblSupplieProduct.getColumn(0).setPreferredWidth(25);
        columnModelTblSupplieProduct.getColumn(1).setPreferredWidth(200);

        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.DEFAULT);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblSuppID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblSuppProduct = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSuppProduct = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnFlag = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblFlag = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSuppliers = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblSuppID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSuppID.setText("MÃ NCC");

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtID.setText("TỰ ĐỘNG TẠO MÃ SỐ");
        txtID.setFocusable(false);

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblName.setText("TÊN NCC");

        txtName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAddress.setText("ĐỊA CHỈ");

        txtAddress.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPhone.setText("SỐ ĐIỆN THOẠI");

        txtPhone.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        lblSuppProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSuppProduct.setText("SẢN PHẨM CUNG CẤP");

        tblSuppProduct.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        tblSuppProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ SP", "TÊN SP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSuppProduct.setFocusable(false);
        tblSuppProduct.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblSuppProduct.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblSuppProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblSuppProductMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblSuppProduct);

        btnAdd.setBackground(new java.awt.Color(0, 153, 0));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(242, 242, 242));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ButtonIcon/add.png"))); // NOI18N
        btnAdd.setFocusable(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(0, 0, 153));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(242, 242, 242));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ButtonIcon/save.png"))); // NOI18N
        btnSave.setEnabled(false);
        btnSave.setFocusable(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnFlag.setBackground(new java.awt.Color(204, 0, 0));
        btnFlag.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFlag.setForeground(new java.awt.Color(242, 242, 242));
        btnFlag.setText("FLAG");
        btnFlag.setEnabled(false);
        btnFlag.setFocusable(false);
        btnFlag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlagActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(0, 0, 0));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ButtonIcon/clear.png"))); // NOI18N
        btnClear.setFocusable(false);
        btnClear.setSelected(true);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        lblFlag.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblFlag.setForeground(new java.awt.Color(204, 0, 0));
        lblFlag.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(lblFlag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblSuppID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID)
                            .addComponent(txtAddress)
                            .addComponent(txtName)
                            .addComponent(txtPhone)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSuppProduct)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnFlag)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSuppID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhone))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblSuppProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFlag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFlag, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        tblSuppliers.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tblSuppliers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ NCC", "TÊN", "ĐỊA CHỈ", "SDT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSuppliers.setFocusable(false);
        tblSuppliers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblSuppliers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblSuppliers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblSuppliersMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblSuppliers);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblSuppliersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSuppliersMousePressed
        index = tblSuppliers.getSelectedRow();
        int id = (int) modelTblSupplier.getValueAt(index, 0);

        writeForm(id);
    }//GEN-LAST:event_tblSuppliersMousePressed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        updateSupplier();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnFlagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlagActionPerformed
        if (btnFlag.getText().equals("FLAG")) {
            flagSupplier();
        } else {
            unflagSupplier();
        }
    }//GEN-LAST:event_btnFlagActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addSupplier();
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblSuppProductMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSuppProductMousePressed
        Point point = evt.getPoint();
        int row = tblSuppProduct.rowAtPoint(point);
        if (evt.getClickCount() == 2 && tblSuppProduct.getSelectedRow() != -1) {
            int id = (int) tblSuppProduct.getValueAt(row, 0);
            this.mainMenu.switchCardProduct(id);
        }
    }//GEN-LAST:event_tblSuppProductMousePressed

    ////////////////////////////////////////////////////////////////////////////
    public void errorMessage(String str) {
        JOptionPane.showMessageDialog(null, str, "LỖI", JOptionPane.ERROR_MESSAGE);
    }

    public int customConfirmDialog(String str) {
        return JOptionPane.showConfirmDialog(null, str, "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    public int confirmFlagDialog() {
        return JOptionPane.showConfirmDialog(null, "Tiếp tục đánh dấu nhà cung cấp?\nLưu ý: nhà cung cấp sẽ ngừng hoạt động khi bị đánh dấu!!!",
                "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    public int confirmUnflagDialog() {
        return JOptionPane.showConfirmDialog(null, "Tiếp tục xóa đánh dấu nhà cung cấp?\nLưu ý: nhà cung cấp sẽ hoạt động trở lại và bắt đầu cung cấp sản phẩm!!!",
                "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    public void fillFlagLabel() {
        lblFlag.setText("<html>Lưu ý: Nhà cung cấp này đang ngừng hoạt động<br>và tạm thời không cung cấp sản phẩm</html>");
    }

    public void buttonsWhenAddInfo() {
        btnAdd.setEnabled(true);
        btnSave.setEnabled(false);
        btnFlag.setEnabled(false);

        if (this.role.equals("NV")) {
            btnAdd.setEnabled(false);
        }
    }

    public void buttonsWhenEditInfo() {
        btnAdd.setEnabled(false);
        btnSave.setEnabled(true);
        btnFlag.setEnabled(true);

        if (this.role.equals("NV")) {
            btnFlag.setEnabled(false);
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    public void clearForm() {
        tblSuppliers.clearSelection();

        modelTblSuppProduct.setRowCount(0);

        txtID.setText("TỰ ĐỘNG TẠO MÃ SỐ");
        txtName.setText("");
        txtPhone.setText("");
        txtAddress.setText("");
        lblFlag.setText("");

        buttonsWhenAddInfo();
    }

    public void writeForm(int id) {
        try {
            NhaCungCap ncc = nccDAO.findById(id);
            boolean flag = ncc.isFlagged();

            txtID.setText(ncc.getMaNCC() + "");
            txtName.setText(ncc.getTenNCC());
            txtAddress.setText(ncc.getDiaChi());
            txtPhone.setText(ncc.getSdt());

            if (flag) {
                if (btnFlag.getText().equals("FLAG")) {
                    btnFlag.setText("UNFLAG");
                    btnFlag.setBackground(new Color(204, 0, 204));
                }
                fillFlagLabel();
            } else if (btnFlag.getText().equals("UNFLAG")) {
                btnFlag.setText("FLAG");
                btnFlag.setBackground(new Color(204, 0, 0));
                lblFlag.setText("");
            }

            loadSuppliedProductByNCC(ncc.getMaNCC());

            buttonsWhenEditInfo();
        } catch (SQLException ex) {
            Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public NhaCungCap readForm() {
        int maNCC = -1;

        try {
            maNCC = Integer.parseInt(txtID.getText());
        } catch (NumberFormatException e) {
        }

        String tenNCC = txtName.getText().trim();
        String diaChi = txtAddress.getText().trim();
        String sdt = txtPhone.getText().trim();

        if (maNCC == -1) {
            return new NhaCungCap(tenNCC, diaChi, sdt);
        }

        return new NhaCungCap(maNCC, tenNCC, diaChi, sdt);
    }

    public boolean validateInfo() {
        String phone = txtPhone.getText().trim();
        String phoneRegex = "\\d{8,12}";

        if (txtName.getText().isBlank() || txtAddress.getText().isBlank() || phone.isBlank()) {
            errorMessage("Vui lòng không để trống thông tin của nhà cung cấp!");
            return false;
        }

        if (!phone.matches(phoneRegex)) {
            errorMessage("Số điện thoại không hợp lệ\nXin vui lòng nhập lại!!!");
            return false;
        }

        return true;
    }

    ////////////////////////////////////////////////////////////////////////////
    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
        nccDAO = new NhaCungCapDAO(this.connection);
        spDAO = new SanPhamDAO(this.connection);
        khoHangDAO = new KhoHangDAO(this.connection);
        khctDAO = new KhoHangChiTietDAO(this.connection);

        loadDataToTblSupplier();
    }

    @Override
    public void connectMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
        this.role = mainMenu.getUserRole();
        if (this.role.equals("NV")) {
            btnAdd.setEnabled(false);
        }
    }

    @Override
    public void resetPanelData() {
        clearForm();
        loadDataToTblSupplier();

        if (index != -1) {
            dragTableToIndex(index);
            buttonsWhenEditInfo();
        }
    }

    public void dragTableToIndex(int i) {
        tblSuppliers.requestFocus();
        tblSuppliers.changeSelection(i, 0, false, false);
        tblSuppliers.setRowSelectionInterval(i, i);
        writeForm((int) tblSuppliers.getValueAt(i, 0));
    }

    public void loadDataToTblSupplier() {
        try {
            modelTblSupplier.setRowCount(0);
            List<NhaCungCap> nccList = nccDAO.findAll();
            for (NhaCungCap ncc : nccList) {
                int id = ncc.getMaNCC();
                String tenncc = ncc.getTenNCC();
                String diachi = ncc.getDiaChi();
                String sdt = ncc.getSdt();

                modelTblSupplier.addRow(new Object[]{id, tenncc, diachi, sdt});

                if (ncc.isFlagged()) {
                    TableCustom.setRedRow(tblSuppliers, (tblSuppliers.getRowCount() - 1));
                } else {
                    TableCustom.setNormalRow(tblSuppliers, (tblSuppliers.getRowCount() - 1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadSuppliedProductByNCC(int id_ncc) {
        try {
            modelTblSuppProduct.setRowCount(0);

            List<SanPham> spList = spDAO.findBySupplier(id_ncc);

            for (SanPham sp : spList) {
                int maSp = sp.getMaSp();
                String tenSp = sp.getTenSp();

                modelTblSuppProduct.addRow(new Object[]{maSp, tenSp});
                if (sp.isFlagged()) {
                    TableCustom.setRedRow(tblSuppProduct, (tblSuppProduct.getRowCount() - 1));
                } else {
                    TableCustom.setNormalRow(tblSuppProduct, (tblSuppProduct.getRowCount() - 1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addSupplier() {
        if (validateInfo()) {
            if (customConfirmDialog("Tiếp tục thêm nhà cung cấp này?") == JOptionPane.YES_OPTION) {
                NhaCungCap ncc = readForm();
                try {
                    nccDAO.insert(ncc);
                    index = tblSuppliers.getRowCount();
                    JOptionPane.showMessageDialog(null, "Thêm nhà cung cấp mới thành công!");
                    mainMenu.restartForm();
                } catch (SQLException ex) {
                    Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void updateSupplier() {
        if (validateInfo()) {
            try {
                int maNCC = (int) modelTblSupplier.getValueAt(index, 0);
                NhaCungCap old_NCC = nccDAO.findById(maNCC);

                NhaCungCap new_NCC = readForm();
                new_NCC.setFlag(nccDAO.findById(maNCC).isFlagged());

                if (!old_NCC.equals(new_NCC)) {
                    if (customConfirmDialog("Tiếp tục cập nhật thông tin?") == JOptionPane.YES_OPTION) {
                        nccDAO.update(new_NCC);
                        JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
                        mainMenu.restartForm();
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void flagSupplier() {
        int maNCC = (int) modelTblSupplier.getValueAt(index, 0);

        if (confirmFlagDialog() == JOptionPane.YES_OPTION) {
            try {
                nccDAO.flag(maNCC);
                index = -1;
                JOptionPane.showMessageDialog(null, "Ngừng hoạt động thành công!");
                mainMenu.restartForm();
            } catch (SQLException ex) {
                Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void unflagSupplier() {
        int maNCC = (int) modelTblSupplier.getValueAt(index, 0);

        if (confirmUnflagDialog() == JOptionPane.YES_OPTION) {
            try {
                nccDAO.unflag(maNCC);
                index = -1;
                JOptionPane.showMessageDialog(null, "Tiếp tục hoạt động thành công!");
                mainMenu.restartForm();
            } catch (SQLException ex) {
                Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFlag;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblFlag;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSuppID;
    private javax.swing.JLabel lblSuppProduct;
    private javax.swing.JTable tblSuppProduct;
    private javax.swing.JTable tblSuppliers;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables

}
