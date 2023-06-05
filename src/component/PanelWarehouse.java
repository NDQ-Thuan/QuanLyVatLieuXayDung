package component;

import customTable.TableCustom;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.KhoHangDAO;
import model.KhoHang;
import model.KhoHangChiTiet;
import model.KhoHangChiTietDAO;
import model.LoaiHang;
import model.LoaiHangDAO;
import model.SanPham;
import model.SanPhamDAO;

public class PanelWarehouse extends ConnectionPanel {

    private DefaultTableModel modelTblProduct;

    private Connection connection;
    private KhoHangDAO khoHangDAO;
    private KhoHangChiTietDAO khctDAO;
    private SanPhamDAO spDAO;
    private LoaiHangDAO lhDAO;

    public PanelWarehouse() {
        initComponents();
        modelTblProduct = (DefaultTableModel) tblProduct.getModel();

        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        cboWarehouse = new javax.swing.JComboBox<>();
        lblLienLac = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblDiaChi = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();

        tblProduct.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MÃ SP", "TÊN SP", "LOẠI HÀNG", "ĐVT", "GIÁ", "SỐ LƯỢNG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduct.setFocusable(false);
        tblProduct.setRowHeight(30);
        jScrollPane1.setViewportView(tblProduct);

        cboWarehouse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboWarehouse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboWarehouseItemStateChanged(evt);
            }
        });

        lblLienLac.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLienLac.setText("LIÊN LẠC:");

        btnAdd.setBackground(new java.awt.Color(0, 153, 0));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(242, 242, 242));
        btnAdd.setText("NHẬP KHO SẢN PHẨM");

        btnDelete.setBackground(new java.awt.Color(204, 0, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(242, 242, 242));
        btnDelete.setText("XÓA SẢN PHẨM");

        lblDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDiaChi.setText("ĐỊA CHỈ:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDiaChi)
                                .addGap(18, 18, 18)
                                .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboWarehouse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLienLac)
                        .addGap(18, 18, 18)
                        .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(407, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(cboWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLienLac))
                    .addComponent(lblAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboWarehouseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboWarehouseItemStateChanged
        String name = (String) cboWarehouse.getSelectedItem();
        loadDataToTblAndFormByTenKho(name);
    }//GEN-LAST:event_cboWarehouseItemStateChanged

    @Override
    public void getConnection(Connection connection) {
        this.connection = connection;
        khoHangDAO = new KhoHangDAO(this.connection);
        khctDAO = new KhoHangChiTietDAO(this.connection);
        spDAO = new SanPhamDAO(this.connection);
        lhDAO = new LoaiHangDAO(this.connection);

        loadDataToCboSupplier();
    }

    @Override
    public void disableButtonOnUserRole() {

    }

    public void loadDataToCboSupplier() {
        try {
            List<KhoHang> khoHangList = khoHangDAO.findAll();

            for (KhoHang kh : khoHangList) {
                cboWarehouse.addItem(kh.getTenKho());
            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelWarehouse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDataToTblAndFormByTenKho(String tenKho) {
        try {
            modelTblProduct.setRowCount(0);

            int maKho = khoHangDAO.findIdByName(tenKho);
            KhoHang kho = khoHangDAO.findById(maKho);
            lblAddress.setText(kho.getDiaChi());
            lblPhone.setText(kho.getSdtQuanLy());

            List<KhoHangChiTiet> khctList = khctDAO.findByMaKho(maKho);

            for (KhoHangChiTiet khct : khctList) {
                SanPham sp = spDAO.findById(khct.getMaSp());
                LoaiHang lh = lhDAO.findById(sp.getMaLh());

                int maSp = sp.getMaSp();
                String tenSp = sp.getTenSp();
                String tenLoaiHang = lh.getTenLoai();
                String dvt = lh.getDvt();
                int gia = sp.getGia();
                int soLuong = khct.getSoLuong();

                modelTblProduct.addRow(new Object[]{maSp, tenSp, tenLoaiHang, dvt, gia, soLuong});
            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelWarehouse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JComboBox<String> cboWarehouse;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblLienLac;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JTable tblProduct;
    // End of variables declaration//GEN-END:variables
}
