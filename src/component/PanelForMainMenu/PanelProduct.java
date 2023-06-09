package component.PanelForMainMenu;

import customTable.TableCustom;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Object.KhoHang;
import model.Object.KhoHangChiTiet;
import model.DAO.KhoHangChiTietDAO;
import model.DAO.KhoHangDAO;
import model.Object.LoaiHang;
import model.DAO.LoaiHangDAO;
import model.Object.NhaCungCap;
import model.DAO.NhaCungCapDAO;
import model.Object.SanPham;
import model.DAO.SanPhamDAO;
import swing.MainMenu;

public final class PanelProduct extends ConnectionPanel {

    private int index = -1;
    private DefaultTableModel modelTblProduct;
    private DefaultTableModel modelTblWarehouse;

    private SanPhamDAO sanPhamDAO;
    private LoaiHangDAO loaiHangDAO;
    private KhoHangDAO khoDAO;
    private KhoHangChiTietDAO khctDAO;
    private NhaCungCapDAO nccDAO;

    public PanelProduct() {
        initComponents();
        modelTblProduct = (DefaultTableModel) tblProduct.getModel();
        modelTblWarehouse = (DefaultTableModel) tblWarehouse.getModel();

        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.DEFAULT);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlProductInfo = new javax.swing.JPanel();
        lblSuppID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        txtDVT = new javax.swing.JTextField();
        lblSuppProduct = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnFlag = new javax.swing.JButton();
        txtPrice = new javax.swing.JTextField();
        lblSuppProduct1 = new javax.swing.JLabel();
        cboType = new javax.swing.JComboBox<>();
        cboSupplier = new javax.swing.JComboBox<>();
        btnClear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblWarehouse = new javax.swing.JTable();
        lblProductName = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        lblFlag = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();

        pnlProductInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblSuppID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSuppID.setText("MÃ SẢN PHẨM");

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtID.setText("TỰ ĐỘNG TẠO MÃ SỐ");
        txtID.setFocusable(false);

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblName.setText("LOẠI HÀNG");

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAddress.setText("NHÀ CUNG CẤP");

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPhone.setText("ĐƠN VỊ TÍNH");

        txtDVT.setEditable(false);
        txtDVT.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        txtDVT.setFocusable(false);

        lblSuppProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSuppProduct.setText("GIÁ");

        btnAdd.setBackground(new java.awt.Color(0, 153, 0));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(242, 242, 242));
        btnAdd.setText("ADD");
        btnAdd.setFocusable(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(0, 0, 153));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(242, 242, 242));
        btnSave.setText("SAVE");
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

        txtPrice.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriceKeyTyped(evt);
            }
        });

        lblSuppProduct1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSuppProduct1.setText("LƯU TRỮ TẠI KHO");

        cboType.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        cboType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTypeItemStateChanged(evt);
            }
        });

        cboSupplier.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        btnClear.setBackground(new java.awt.Color(0, 0, 0));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("CLEAR");
        btnClear.setFocusable(false);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        tblWarehouse.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        tblWarehouse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "KHO TRỮ", "SỐ LƯỢNG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblWarehouse.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblWarehouse.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblWarehouse);

        lblProductName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblProductName.setText("TÊN SẢN PHẨM");

        txtProductName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblFlag.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout pnlProductInfoLayout = new javax.swing.GroupLayout(pnlProductInfo);
        pnlProductInfo.setLayout(pnlProductInfoLayout);
        pnlProductInfoLayout.setHorizontalGroup(
            pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductInfoLayout.createSequentialGroup()
                        .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSuppID)
                            .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSuppProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblProductName))
                        .addGap(18, 18, 18)
                        .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID)
                            .addComponent(txtDVT)
                            .addComponent(txtPrice)
                            .addComponent(cboType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtProductName)))
                    .addGroup(pnlProductInfoLayout.createSequentialGroup()
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addGap(30, 30, 30)
                        .addComponent(btnSave)
                        .addGap(26, 26, 26)
                        .addComponent(btnFlag, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlProductInfoLayout.createSequentialGroup()
                        .addComponent(lblSuppProduct1)
                        .addGap(18, 18, 18)
                        .addComponent(lblFlag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlProductInfoLayout.setVerticalGroup(
            pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSuppID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID))
                .addGap(15, 15, 15)
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductName))
                .addGap(15, 15, 15)
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDVT))
                .addGap(15, 15, 15)
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice)
                    .addComponent(lblSuppProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProductInfoLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblSuppProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlProductInfoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFlag, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFlag, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        tblProduct.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ SP", "TÊN SP", "LOẠI HÀNG", "ĐVT", "GIÁ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduct.setFocusable(false);
        tblProduct.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProduct.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProductMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filter", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnlProductInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlProductInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMousePressed
        index = tblProduct.getSelectedRow();
        int maSp = (int) modelTblProduct.getValueAt(index, 0);
        writeForm(maSp);
        buttonsWhenEditInfo();
    }//GEN-LAST:event_tblProductMousePressed

    private void btnFlagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlagActionPerformed
        if (btnFlag.getText().equals("FLAG")) {
            flagProduct();
        } else {
            unflagProduct();
        }
    }//GEN-LAST:event_btnFlagActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addProduct();
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPriceKeyTyped

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        updateProduct();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cboTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTypeItemStateChanged
        try {
            String dvt = loaiHangDAO.getDVTByLoaiHang((String) cboType.getSelectedItem());
            if (dvt == null) {
                txtDVT.setText("");
            } else {
                txtDVT.setText(dvt);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboTypeItemStateChanged

    ////////////////////////////////////////////////////////////////////////////
    public void errorMessage(String str) {
        JOptionPane.showMessageDialog(null, str, "LỖI", JOptionPane.ERROR_MESSAGE);
    }

    public int customConfirmDialog(String str) {
        return JOptionPane.showConfirmDialog(null, str, "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    public int confirmDeleteDialog() {
        return JOptionPane.showConfirmDialog(null, "Tiếp tục xóa thông tin?"
                + "\nThao tác này sẽ xóa thông tin sản phẩm đang được cung cấp"
                + "\nvà những hóa đơn chứa sản phẩm đó!!!", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    public void fillFlagLabel() {
        lblFlag.setText("<html>Lưu ý: Sản phẩm này hiện đang ngừng bán<br>và tạm thời không thể được đặt hàng</html>");
    }

    public void buttonsWhenAddInfo() {
        if (this.role.equals("NV")) {
            btnAdd.setEnabled(false);
        }
        btnAdd.setEnabled(true);
        btnSave.setEnabled(false);
        btnFlag.setEnabled(false);
    }

    public void buttonsWhenEditInfo() {
        if (this.role.equals("NV")) {
            btnFlag.setEnabled(false);
        }
        btnAdd.setEnabled(false);
        btnSave.setEnabled(true);
        btnFlag.setEnabled(true);
    }

    ////////////////////////////////////////////////////////////////////////////
    public void clearForm() {
        txtID.setText("TỰ ĐỘNG TẠO MÃ SỐ");
        txtProductName.setText("");
        cboSupplier.setSelectedItem("CHỜ BỔ SUNG");
        cboType.setSelectedItem("CHỜ BỔ SUNG");
        txtDVT.setText("");
        txtPrice.setText("");
        lblFlag.setText("");

        tblProduct.clearSelection();
        modelTblWarehouse.setRowCount(0);

        buttonsWhenAddInfo();
    }

    public void writeForm(int maSp) {
        try {
            SanPham sp = sanPhamDAO.findById(maSp);
            NhaCungCap ncc = nccDAO.findById(sp.getMaNcc());
            LoaiHang lh = loaiHangDAO.findById(sp.getMaLh());

            txtID.setText(sp.getMaSp() + "");
            txtProductName.setText(sp.getTenSp());
            cboType.setSelectedItem(lh.getTenLoai());
            cboSupplier.setSelectedItem(ncc.getTenNCC());
            txtDVT.setText(lh.getDvt());
            txtPrice.setText(sp.getGia() + "");

            List<KhoHangChiTiet> khctList = khctDAO.findAllByMaSP(maSp);
            modelTblWarehouse.setRowCount(0);

            for (KhoHangChiTiet khct : khctList) {
                KhoHang kho = khoDAO.findById(khct.getMaKho());
                String tenKho = kho.getTenKho();
                int soLuong = khct.getSoLuong();
                modelTblWarehouse.addRow(new Object[]{tenKho, soLuong});
            }

            if (sp.isFlagged()) {
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

        } catch (SQLException ex) {
            Logger.getLogger(PanelProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public SanPham readForm() throws SQLException {
        int maSp = -1;

        try {
            maSp = Integer.parseInt(txtID.getText());
        } catch (NumberFormatException e) {
        }

        String tenSp = txtProductName.getText();

        int maNcc = nccDAO.findIDByName((String) cboSupplier.getSelectedItem());

        LoaiHang lh = loaiHangDAO.findByNameAndDVT((String) cboType.getSelectedItem(), txtDVT.getText());
        int maLh = lh.getMaLh();

        int gia = Integer.parseInt(txtPrice.getText());

        if (maSp == -1) {
            return new SanPham(maLh, maNcc, tenSp, gia);
        }

        return new SanPham(maSp, maLh, maNcc, tenSp, gia);
    }

    public boolean validateInfo() {
        boolean flag = true;

        String tenSp = txtProductName.getText().trim();

        if (tenSp.isBlank() || txtPrice.getText().isBlank()) {
            errorMessage("Vui lòng không để trống thông tin sản phẩm!");
            flag = false;
            return flag;
        }

        if (tenSp.length() > 50) {
            errorMessage("Tên sản phẩm không được vượt quá 50 ký tự");
            flag = false;
            return flag;
        }

        if (cboType.getSelectedItem().equals("CHỜ BỔ SUNG")) {
            errorMessage("Vui lòng bổ sung thông tin loại hàng của sản phẩm!!!");
            flag = false;
            return flag;
        }

        if (cboSupplier.getSelectedItem().equals("CHỜ BỔ SUNG")) {
            int n = customConfirmDialog("Thông tin nhà cung cấp của sản phẩm đang bị bỏ trống!\nXác nhận?");

            if (n != JOptionPane.YES_OPTION) {
                flag = false;
                return flag;
            }
        }

        int price = Integer.parseInt(txtPrice.getText());

        if (price > 10000000) {
            errorMessage("Giá của sản phẩm không được vượt quá 10,000,000 VNĐ");
            flag = false;
        }

        return flag;
    }

    ////////////////////////////////////////////////////////////////////////////
    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;

        sanPhamDAO = new SanPhamDAO(this.connection);
        loaiHangDAO = new LoaiHangDAO(this.connection);
        khoDAO = new KhoHangDAO(this.connection);
        khctDAO = new KhoHangChiTietDAO(this.connection);
        nccDAO = new NhaCungCapDAO(this.connection);

        loadDataToTblProduct();
        loadDataToForm();
    }

    @Override
    public void connectMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
        this.role = mainMenu.getUserRole();
    }

    @Override
    public void resetPanelData() {
        clearForm();
        loadDataToTblProduct();
        loadDataToForm();

        if (index != -1) {
            tblProduct.requestFocus();
            tblProduct.changeSelection(index, 0, false, false);
            tblProduct.setRowSelectionInterval(index, index);
            writeForm((int) modelTblProduct.getValueAt(index, 0));
        }
    }

    public void loadDataToTblProduct() {
        try {
            modelTblProduct.setRowCount(0);
            List<SanPham> spList = sanPhamDAO.findAll();

            for (SanPham sp : spList) {
                LoaiHang loaiHang = loaiHangDAO.findById(sp.getMaLh());
                int id = sp.getMaSp();
                String tensp = sp.getTenSp();
                String tenlh = loaiHang.getTenLoai();
                String dvt = loaiHang.getDvt();
                int gia = sp.getGia();

                modelTblProduct.addRow(new Object[]{id, tensp, tenlh, dvt, gia});

                if (sp.isFlagged()) {
                    TableCustom.setRedRow(tblProduct, (tblProduct.getRowCount() - 1));
                } else {
                    TableCustom.setNormalRow(tblProduct, (tblProduct.getRowCount() - 1));
                }
            }
        } catch (SQLException ex) {
        }
    }

    public void loadDataToForm() {
        try {
            List<LoaiHang> lhList = loaiHangDAO.findAll();
            cboType.removeAllItems();
            for (LoaiHang lh : lhList) {
                cboType.addItem(lh.getTenLoai());
            }
            cboType.addItem("CHỜ BỔ SUNG");

            List<NhaCungCap> nccList = nccDAO.findAllByCustomQuery("SELECT * FROM NHACUNGCAP WHERE FLAG = 0");
            cboSupplier.removeAllItems();
            for (NhaCungCap ncc : nccList) {
                cboSupplier.addItem(ncc.getTenNCC());
            }
            cboSupplier.addItem("CHỜ BỔ SUNG");

            cboSupplier.setSelectedItem("CHỜ BỔ SUNG");
            cboType.setSelectedItem("CHỜ BỔ SUNG");
        } catch (SQLException ex) {
            Logger.getLogger(PanelProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addProduct() {
        if (validateInfo()) {
            if (customConfirmDialog("Tiếp tục thêm sản phẩm này?") == JOptionPane.YES_OPTION) {
                try {
                    SanPham sp = readForm();
                    sanPhamDAO.insert(sp);
                    index = tblProduct.getRowCount();
                    mainMenu.restartForm();
                    JOptionPane.showMessageDialog(null, "Thêm sản phẩm mới thành công!");
                } catch (SQLException ex) {
                    Logger.getLogger(PanelProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void updateProduct() {
        if (validateInfo()) {
            try {
                int maSp = (int) modelTblProduct.getValueAt(index, 0);
                SanPham old_SP = sanPhamDAO.findById(maSp);

                SanPham new_SP = readForm();
                new_SP.setFlag(sanPhamDAO.findById(maSp).isFlagged());

                if (!old_SP.equals(new_SP)) {
                    if (customConfirmDialog("Tiếp tục cập nhật thông tin?") == JOptionPane.YES_OPTION) {
                        sanPhamDAO.update(new_SP);
                        mainMenu.restartForm();
                        JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void flagProduct() {
        int maSp = (int) modelTblProduct.getValueAt(index, 0);

        if (customConfirmDialog("Tiếp tục đánh dấu sản phẩm?\n"
                + "Lưu ý: sản phẩm sẽ ngừng bán nếu bị đánh dấu")
                == JOptionPane.YES_OPTION) {
            try {
                sanPhamDAO.flag(maSp);
                index = -1;
                mainMenu.restartForm();
                JOptionPane.showMessageDialog(null, "Sản phẩm ngừng bán thành công!");

            } catch (SQLException ex) {
                Logger.getLogger(PanelProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void unflagProduct() {
        int maSp = (int) modelTblProduct.getValueAt(index, 0);

        if (customConfirmDialog("Tiếp tục bỏ đánh dấu sản phẩm?\n"
                + "Lưu ý: sản phẩm sẽ được bày bán nếu bỏ đánh dấu")
                == JOptionPane.YES_OPTION) {
            try {
                sanPhamDAO.unflag(maSp);
                index = -1;
                mainMenu.restartForm();
                JOptionPane.showMessageDialog(null, "Sản phẩm đã được bỏ đánh dấu thành công!");
            } catch (SQLException ex) {
                Logger.getLogger(PanelProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFlag;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboSupplier;
    private javax.swing.JComboBox<String> cboType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblFlag;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblSuppID;
    private javax.swing.JLabel lblSuppProduct;
    private javax.swing.JLabel lblSuppProduct1;
    private javax.swing.JPanel pnlProductInfo;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTable tblWarehouse;
    private javax.swing.JTextField txtDVT;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductName;
    // End of variables declaration//GEN-END:variables

}
