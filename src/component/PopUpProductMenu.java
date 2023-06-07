package component;

import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import customTable.TableCustom;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import model.KhachHangDAO;
import model.KhoHang;
import model.KhoHangChiTiet;
import model.KhoHangChiTietDAO;
import model.KhoHangDAO;
import model.LoaiHang;
import model.LoaiHangDAO;
import model.SanPham;
import model.SanPhamDAO;

public class PopUpProductMenu extends javax.swing.JFrame {

    private int index = -1;

    private TabPanelExport pnlExport;
    private DefaultTableModel modelTblProduct;

    private Connection connection;
    private SanPhamDAO sanPhamDAO;
    private KhoHangDAO khoDAO;
    private KhoHangChiTietDAO khctDAO;
    private LoaiHangDAO loaiHangDAO;

    public PopUpProductMenu(TabPanelExport pnlExport) {
        initComponents();
        setLocationRelativeTo(null);

        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
        modelTblProduct = (DefaultTableModel) tblProduct.getModel();

        this.pnlExport = pnlExport;

        getConnection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        lblProductMenu = new javax.swing.JLabel();
        lblWarehouseName = new javax.swing.JLabel();
        spnAmount = new javax.swing.JSpinner();
        lblAmount = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        btnConfirm1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MÃ SP", "TÊN SP", "LOẠI", "ĐVT", "GIÁ", "TỒN KHO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduct.getTableHeader().setReorderingAllowed(false);
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProductMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);

        lblProductMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblProductMenu.setText("DANH SÁCH SẢN PHẨM THUỘC");

        lblWarehouseName.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblWarehouseName.setForeground(new java.awt.Color(0, 0, 153));

        lblAmount.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblAmount.setText("Số lượng đặt hàng");

        btnConfirm.setBackground(new java.awt.Color(0, 153, 0));
        btnConfirm.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnConfirm.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirm.setText("XÁC NHẬN");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnConfirm1.setBackground(new java.awt.Color(204, 0, 0));
        btnConfirm1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnConfirm1.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirm1.setText("HỦY");
        btnConfirm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirm1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblProductMenu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblWarehouseName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spnAmount)
                    .addComponent(lblAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductMenu)
                    .addComponent(lblWarehouseName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAmount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(btnConfirm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirm1)
                        .addGap(41, 41, 41))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMousePressed
        index = tblProduct.getSelectedRow();
    }//GEN-LAST:event_tblProductMousePressed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        returnProduct();
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnConfirm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirm1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirm1ActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightFlatIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
        }
    }

    public void getConnection() {
        this.connection = pnlExport.getPnlConnection();

        sanPhamDAO = new SanPhamDAO(this.connection);
        khoDAO = new KhoHangDAO(this.connection);
        khctDAO = new KhoHangChiTietDAO(this.connection);
        loaiHangDAO = new LoaiHangDAO(this.connection);

        loadDataToTblProduct();
    }

    public void loadDataToTblProduct() {
        try {
            modelTblProduct.setRowCount(0);

            int maKho = this.pnlExport.getCurrentWarehouseID();
            KhoHang kho = khoDAO.findById(maKho);

            List<KhoHangChiTiet> khctList = khctDAO.findByMaKho(maKho);

            SanPham sp;
            LoaiHang loaiHang;

            for (KhoHangChiTiet khct : khctList) {
                sp = sanPhamDAO.findById(khct.getMaSp());
                loaiHang = loaiHangDAO.findById(sp.getMaLh());

                int maSP = sp.getMaSp();
                String tenSP = sp.getTenSp();
                String loai = loaiHang.getTenLoai();
                String dvt = loaiHang.getDvt();
                int gia = sp.getGia();
                int soLuong = khct.getSoLuong();

                modelTblProduct.addRow(new Object[]{maSP, tenSP, loai, dvt, gia, soLuong});
            }

            lblWarehouseName.setText(kho.getTenKho().toUpperCase());
        } catch (SQLException ex) {
            Logger.getLogger(PopUpProductMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void returnProduct() {
        try {
            int maSP = (int) modelTblProduct.getValueAt(index, 0);
            int soLuong = (int) spnAmount.getValue();

            SanPham sp = sanPhamDAO.findById(maSP);

            this.pnlExport.addDetailProduct(sp, soLuong);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(PopUpProductMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnConfirm1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblProductMenu;
    private javax.swing.JLabel lblWarehouseName;
    private javax.swing.JSpinner spnAmount;
    private javax.swing.JTable tblProduct;
    // End of variables declaration//GEN-END:variables
}
