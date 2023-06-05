package component;

import customTable.TableCustom;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KhoHangChiTietDAO;
import model.KhoHangDAO;
import model.NhaCungCap;
import model.NhaCungCapDAO;
import model.SanPham;
import model.SanPhamDAO;

public final class PanelSupplier extends ConnectionPanel {

    private int index = -1;
    private DefaultTableModel modelTblSupplier;
    private DefaultTableModel modelTblSuppProduct;

    private Connection connection;
    private NhaCungCapDAO nccDAO;
    private SanPhamDAO spDAO;
    private KhoHangDAO khoHangDAO;
    private KhoHangChiTietDAO khctDAO;

    public PanelSupplier() {
        initComponents();
        modelTblSupplier = (DefaultTableModel) tblSuppliers.getModel();
        modelTblSuppProduct = (DefaultTableModel) tblSuppProduct.getModel();
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
        btnAddSupplier = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSuppliers = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblSuppID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSuppID.setText("MÃ NHÀ CUNG CẤP");

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtID.setText("Mã số sẽ được tự động tạo");
        txtID.setFocusable(false);

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblName.setText("TÊN NHÀ CUNG CẤP");

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAddress.setText("ĐỊA CHỈ");

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPhone.setText("SỐ ĐIỆN THOẠI");

        lblSuppProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSuppProduct.setText("SẢN PHẨM CUNG CẤP");

        tblSuppProduct.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
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
        jScrollPane1.setViewportView(tblSuppProduct);

        btnAddSupplier.setBackground(new java.awt.Color(0, 153, 0));
        btnAddSupplier.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddSupplier.setForeground(new java.awt.Color(242, 242, 242));
        btnAddSupplier.setText("ADD");
        btnAddSupplier.setFocusable(false);
        btnAddSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSupplierActionPerformed(evt);
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

        btnDelete.setBackground(new java.awt.Color(204, 0, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(242, 242, 242));
        btnDelete.setText("DELETE");
        btnDelete.setEnabled(false);
        btnDelete.setFocusable(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(255, 255, 255));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("CLEAR");
        btnClear.setFocusable(false);
        btnClear.setSelected(true);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSuppID)
                            .addComponent(lblPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSuppProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID)
                            .addComponent(txtName)
                            .addComponent(txtPhone)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnClear)
                        .addGap(23, 23, 23)
                        .addComponent(btnAddSupplier)
                        .addGap(24, 24, 24)
                        .addComponent(btnSave)
                        .addGap(24, 24, 24)
                        .addComponent(btnDelete))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAddress)
                        .addGap(18, 18, 18)
                        .addComponent(txtAddress)))
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
                .addGap(20, 20, 20)
                .addComponent(lblSuppProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

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
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
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

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteSupplier();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSupplierActionPerformed
        addSupplier();
    }//GEN-LAST:event_btnAddSupplierActionPerformed

    public void errorMessage(String str) {
        JOptionPane.showMessageDialog(null, str, "LỖI", JOptionPane.ERROR_MESSAGE);
    }

    public int customConfirmDialog(String str) {
        return JOptionPane.showConfirmDialog(null, str, "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    public int confirmDeleteDialog() {
        return JOptionPane.showConfirmDialog(null, "Tiếp tục xóa thông tin?"
                + "\nThao tác này sẽ xóa thông tin sản phẩm đang được cung cấp"
                + "\nbởi nhà cung cấp này và những hóa đơn chứa sản phẩm đó!!!", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    public void buttonsWhenAddInfo() {
        btnAddSupplier.setEnabled(true);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    public void buttonsWhenEditInfo() {
        btnAddSupplier.setEnabled(false);
        btnSave.setEnabled(true);
        btnDelete.setEnabled(true);
    }

    @Override
    public void getConnection(Connection connection) {
        this.connection = connection;
        nccDAO = new NhaCungCapDAO(this.connection);
        spDAO = new SanPhamDAO(this.connection);
        khoHangDAO = new KhoHangDAO(this.connection);
        khctDAO = new KhoHangChiTietDAO(this.connection);

        loadDataToTblSupplier();
    }

    @Override
    public void disableButtonOnUserRole() {
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
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadSuppliedProductByNCC(int id_ncc) {
        try {
            modelTblSuppProduct.setRowCount(0);

            List<SanPham> spList = spDAO.findByNCC(id_ncc);

            for (SanPham sp : spList) {
                int maSp = sp.getMaSp();
                String tenSp = sp.getTenSp();

                modelTblSuppProduct.addRow(new Object[]{maSp, tenSp});
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void resetPanelData() {
        clearForm();
        loadDataToTblSupplier();

        if (index != -1) {
            tblSuppliers.setRowSelectionInterval(index, index);
            writeForm((int) modelTblSupplier.getValueAt(index, 0));
        }
    }

    public void clearForm() {
        tblSuppliers.clearSelection();

        modelTblSuppProduct.setRowCount(0);

        txtID.setText("Mã số sẽ được tự động tạo");
        txtName.setText("");
        txtPhone.setText("");
        txtAddress.setText("");

        buttonsWhenAddInfo();
    }

    public void writeForm(int id) {
        try {
            NhaCungCap ncc = nccDAO.findById(id);
            txtID.setText(ncc.getMaNCC() + "");
            txtName.setText(ncc.getTenNCC());
            txtAddress.setText(ncc.getDiaChi());
            txtPhone.setText(ncc.getSdt());

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

    public void addSupplier() {
        if (validateInfo()) {
            if (customConfirmDialog("Tiếp tục thêm nhà cung cấp này?") == JOptionPane.YES_OPTION) {
                NhaCungCap ncc = readForm();
                try {
                    nccDAO.insert(ncc);
                    index = tblSuppliers.getRowCount();
                    resetPanelData();

                    JOptionPane.showMessageDialog(null, "Thêm nhà cung cấp mới thành công!");
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

                if (!old_NCC.equals(new_NCC)) {
                    if (customConfirmDialog("Tiếp tục cập nhật thông tin?") == JOptionPane.YES_OPTION) {
                        nccDAO.update(new_NCC);
                        resetPanelData();
                        JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void deleteSupplier() {
        int maNCC = (int) modelTblSupplier.getValueAt(index, 0);

        if (confirmDeleteDialog() == JOptionPane.YES_OPTION) {
            try {
                nccDAO.delete(maNCC);
                index = -1;
                resetPanelData();
                JOptionPane.showMessageDialog(null, "Xóa thông tin thành công!");
            } catch (SQLException ex) {
                Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSupplier;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddress;
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
