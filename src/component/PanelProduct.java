package component;

import customTable.TableCustom;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KhoHang;
import model.KhoHangChiTiet;
import model.KhoHangChiTietDAO;
import model.KhoHangDAO;
import model.LoaiHang;
import model.LoaiHangDAO;
import model.NhaCungCap;
import model.NhaCungCapDAO;
import model.SanPham;
import model.SanPhamDAO;

public final class PanelProduct extends ConnectionPanel {

    private int index = -1;
    private DefaultTableModel modelTblProduct;
    private DefaultTableModel modelTblWarehouse;

    private Connection connection;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();

        pnlProductInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblSuppID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSuppID.setText("MÃ SẢN PHẨM");

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtID.setFocusable(false);

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblName.setText("LOẠI HÀNG");

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAddress.setText("NHÀ CUNG CẤP");

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPhone.setText("ĐƠN VỊ TÍNH");

        txtDVT.setEditable(false);
        txtDVT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtDVT.setFocusable(false);

        lblSuppProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSuppProduct.setText("GIÁ");

        btnAdd.setBackground(new java.awt.Color(0, 153, 0));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(242, 242, 242));
        btnAdd.setText("ADD");
        btnAdd.setFocusable(false);

        btnSave.setBackground(new java.awt.Color(0, 0, 153));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(242, 242, 242));
        btnSave.setText("EDIT");
        btnSave.setEnabled(false);
        btnSave.setFocusable(false);

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

        txtPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblSuppProduct1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSuppProduct1.setText("LƯU TRỮ TẠI KHO");

        cboType.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        cboSupplier.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        btnClear.setBackground(new java.awt.Color(0, 0, 0));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("CLEAR");
        btnClear.setFocusable(false);

        tblWarehouse.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
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
        txtProductName.setFocusable(false);

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
                        .addGap(30, 30, 30)
                        .addComponent(btnFlag))
                    .addGroup(pnlProductInfoLayout.createSequentialGroup()
                        .addComponent(lblSuppProduct1)
                        .addGap(0, 0, Short.MAX_VALUE))
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
                .addGap(15, 15, 15)
                .addComponent(lblSuppProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFlag, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(pnlProductInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlProductInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMousePressed
        int index = tblProduct.getSelectedRow();
        int maSp = (int) modelTblProduct.getValueAt(index, 0);
        writeForm(maSp);
    }//GEN-LAST:event_tblProductMousePressed

    private void btnFlagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFlagActionPerformed

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

    public void buttonsWhenAddInfo() {
        btnAdd.setEnabled(true);
        btnSave.setEnabled(false);
        btnFlag.setEnabled(false);
    }

    public void buttonsWhenEditInfo() {
        btnAdd.setEnabled(false);
        btnSave.setEnabled(true);
        btnFlag.setEnabled(true);
    }

    @Override
    public void getConnection(Connection connection) {
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
    public void disableButtonOnUserRole() {
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
            }
        } catch (SQLException ex) {
        }
    }

    public void loadDataToForm() {
        try {
            List<LoaiHang> lhList = loaiHangDAO.findAll();
            for (LoaiHang lh : lhList) {
                cboType.addItem(lh.getTenLoai());
            }
            List<NhaCungCap> nccList = nccDAO.findAll();
            for (NhaCungCap ncc : nccList) {
                cboSupplier.addItem(ncc.getTenNCC());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clearForm() {

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

        } catch (SQLException ex) {
            Logger.getLogger(PanelProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//
//    public Product readForm() {
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFlag;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboSupplier;
    private javax.swing.JComboBox<String> cboType;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddress;
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
