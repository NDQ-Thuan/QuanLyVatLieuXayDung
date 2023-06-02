package component;

import customTable.TableCustom;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.LoaiHang;
import model.LoaiHangDAO;
import model.SanPham;
import model.SanPhamDAO;

public final class PanelProduct extends javax.swing.JPanel {

    private DefaultTableModel modelTblProduct;

    private Connection connection;
    private SanPhamDAO sanPhamDAO;
    private LoaiHangDAO loaiHangDAO;

    public PanelProduct() {
        initComponents();
        modelTblProduct = (DefaultTableModel) tblProduct.getModel();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
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
        txtPhone = new javax.swing.JTextField();
        lblSuppProduct = new javax.swing.JLabel();
        btnAddSupplier = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtPhone1 = new javax.swing.JTextField();
        lblSuppProduct1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listWarehouse = new javax.swing.JList<>();
        cboType = new javax.swing.JComboBox<>();
        cboSupplier = new javax.swing.JComboBox<>();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();

        pnlProductInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblSuppID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSuppID.setText("MÃ SẢN PHẨM");

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblName.setText("LOẠI HÀNG");

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAddress.setText("NHÀ CUNG CẤP");

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPhone.setText("ĐƠN VỊ TÍNH");

        txtPhone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblSuppProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSuppProduct.setText("GIÁ");

        btnAddSupplier.setBackground(new java.awt.Color(0, 153, 0));
        btnAddSupplier.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddSupplier.setForeground(new java.awt.Color(242, 242, 242));
        btnAddSupplier.setText("ADD");

        btnEdit.setBackground(new java.awt.Color(0, 0, 153));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(242, 242, 242));
        btnEdit.setText("EDIT");

        btnDelete.setBackground(new java.awt.Color(204, 0, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(242, 242, 242));
        btnDelete.setText("DELETE");

        txtPhone1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblSuppProduct1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSuppProduct1.setText("LƯU TRỮ TẠI KHO");

        listWarehouse.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        listWarehouse.setFocusable(false);
        jScrollPane2.setViewportView(listWarehouse);

        cboType.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        cboSupplier.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setText("CLEAR");

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
                            .addComponent(lblSuppProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID)
                            .addComponent(txtPhone)
                            .addComponent(txtPhone1)
                            .addComponent(cboType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(pnlProductInfoLayout.createSequentialGroup()
                        .addComponent(lblSuppProduct1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlProductInfoLayout.createSequentialGroup()
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddSupplier)
                        .addGap(35, 35, 35)
                        .addComponent(btnEdit)
                        .addGap(26, 26, 26)
                        .addComponent(btnDelete)))
                .addContainerGap())
        );
        pnlProductInfoLayout.setVerticalGroup(
            pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSuppID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID))
                .addGap(20, 20, 20)
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhone))
                .addGap(20, 20, 20)
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone1)
                    .addComponent(lblSuppProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(lblSuppProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
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

    public void getConnection(Connection connection) {
        this.connection = connection;
        sanPhamDAO = new SanPhamDAO(this.connection);
        loaiHangDAO = new LoaiHangDAO(this.connection);
        loadDataToTblProduct();
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSupplier;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<String> cboSupplier;
    private javax.swing.JComboBox<String> cboType;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSuppID;
    private javax.swing.JLabel lblSuppProduct;
    private javax.swing.JLabel lblSuppProduct1;
    private javax.swing.JList<String> listWarehouse;
    private javax.swing.JPanel pnlProductInfo;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPhone1;
    // End of variables declaration//GEN-END:variables
}
