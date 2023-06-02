package component;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;
import model.HoaDonDAO;
import model.KhachHangDAO;
import model.NhaCungCap;

public class PanelDashboard extends javax.swing.JPanel {

    private DefaultTableModel modelTblPendingOrder;

    private Connection connection;
    private HoaDonDAO hoaDonDAO;
    private KhachHangDAO khachHangDAO;

    public PanelDashboard() {
        initComponents();
        modelTblPendingOrder = (DefaultTableModel) tblPendingOrder.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_Dashboard_Grid = new javax.swing.JPanel();
        pnl_Revenue = new javax.swing.JPanel();
        lbl_Revenue_Icon = new javax.swing.JLabel();
        lbl_RevenueName = new javax.swing.JLabel();
        lbl_Revenue_Currency = new javax.swing.JLabel();
        lbl_Revenue_Money = new javax.swing.JLabel();
        lbl_Revenue_Percent = new javax.swing.JLabel();
        pnl_PendingOrder = new javax.swing.JPanel();
        lbl_PendingOrder_Icon = new javax.swing.JLabel();
        lbl_PendingOrder_Name = new javax.swing.JLabel();
        lbl_PendingOrder_SoLuong = new javax.swing.JLabel();
        lbl_PendingOrder_Ammount = new javax.swing.JLabel();
        lbl_PendingOrder_DaGiao = new javax.swing.JLabel();
        lbl_PendingOrder_DeliveredAmmount = new javax.swing.JLabel();
        pnl_UniqueBuyer = new javax.swing.JPanel();
        lbl_UniqueBuyer_Icon = new javax.swing.JLabel();
        lbl_UniqueBuyer_Name = new javax.swing.JLabel();
        lbl_UniqueBuyer_Percent = new javax.swing.JLabel();
        lbl_UniqueBuyer_SoLuong = new javax.swing.JLabel();
        lbl_UniqueBuyer_Ammount = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPendingOrder = new javax.swing.JTable();

        pnl_Dashboard_Grid.setLayout(new java.awt.GridLayout(1, 0, 30, 3));

        pnl_Revenue.setBackground(new java.awt.Color(0, 153, 51));

        lbl_Revenue_Icon.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Revenue_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/revenue.png"))); // NOI18N

        lbl_RevenueName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_RevenueName.setForeground(new java.awt.Color(255, 255, 255));
        lbl_RevenueName.setText("Doanh Số Bán Hàng");

        lbl_Revenue_Currency.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Revenue_Currency.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Revenue_Currency.setText("VNĐ");

        lbl_Revenue_Money.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Revenue_Money.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Revenue_Money.setText("000.000");

        lbl_Revenue_Percent.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_Revenue_Percent.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Revenue_Percent.setText("Tăng X%");

        javax.swing.GroupLayout pnl_RevenueLayout = new javax.swing.GroupLayout(pnl_Revenue);
        pnl_Revenue.setLayout(pnl_RevenueLayout);
        pnl_RevenueLayout.setHorizontalGroup(
            pnl_RevenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_RevenueLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnl_RevenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_RevenueLayout.createSequentialGroup()
                        .addComponent(lbl_Revenue_Currency)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Revenue_Money, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbl_Revenue_Percent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_RevenueName, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(lbl_Revenue_Icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        pnl_RevenueLayout.setVerticalGroup(
            pnl_RevenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_RevenueLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbl_Revenue_Icon)
                .addGap(15, 15, 15)
                .addComponent(lbl_RevenueName)
                .addGap(10, 10, 10)
                .addGroup(pnl_RevenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Revenue_Currency)
                    .addComponent(lbl_Revenue_Money))
                .addGap(10, 10, 10)
                .addComponent(lbl_Revenue_Percent)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pnl_Dashboard_Grid.add(pnl_Revenue);

        pnl_PendingOrder.setBackground(new java.awt.Color(255, 153, 0));

        lbl_PendingOrder_Icon.setForeground(new java.awt.Color(255, 255, 255));
        lbl_PendingOrder_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/pending_order.png"))); // NOI18N

        lbl_PendingOrder_Name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_PendingOrder_Name.setForeground(new java.awt.Color(255, 255, 255));
        lbl_PendingOrder_Name.setText("Đơn hàng chưa giao");

        lbl_PendingOrder_SoLuong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_PendingOrder_SoLuong.setForeground(new java.awt.Color(255, 255, 255));
        lbl_PendingOrder_SoLuong.setText("Số lượng: ");

        lbl_PendingOrder_Ammount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_PendingOrder_Ammount.setForeground(new java.awt.Color(255, 255, 255));
        lbl_PendingOrder_Ammount.setText("X");

        lbl_PendingOrder_DaGiao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_PendingOrder_DaGiao.setForeground(new java.awt.Color(255, 255, 255));
        lbl_PendingOrder_DaGiao.setText("Đã giao:");

        lbl_PendingOrder_DeliveredAmmount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_PendingOrder_DeliveredAmmount.setForeground(new java.awt.Color(255, 255, 255));
        lbl_PendingOrder_DeliveredAmmount.setText("X");

        javax.swing.GroupLayout pnl_PendingOrderLayout = new javax.swing.GroupLayout(pnl_PendingOrder);
        pnl_PendingOrder.setLayout(pnl_PendingOrderLayout);
        pnl_PendingOrderLayout.setHorizontalGroup(
            pnl_PendingOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_PendingOrderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnl_PendingOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_PendingOrderLayout.createSequentialGroup()
                        .addComponent(lbl_PendingOrder_SoLuong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_PendingOrder_Ammount, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                    .addComponent(lbl_PendingOrder_Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_PendingOrderLayout.createSequentialGroup()
                        .addComponent(lbl_PendingOrder_Icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(53, 53, 53))
                    .addGroup(pnl_PendingOrderLayout.createSequentialGroup()
                        .addComponent(lbl_PendingOrder_DaGiao)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_PendingOrder_DeliveredAmmount)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        pnl_PendingOrderLayout.setVerticalGroup(
            pnl_PendingOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_PendingOrderLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbl_PendingOrder_Icon)
                .addGap(15, 15, 15)
                .addComponent(lbl_PendingOrder_Name)
                .addGap(10, 10, 10)
                .addGroup(pnl_PendingOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_PendingOrder_SoLuong)
                    .addComponent(lbl_PendingOrder_Ammount))
                .addGap(10, 10, 10)
                .addGroup(pnl_PendingOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_PendingOrder_DaGiao)
                    .addComponent(lbl_PendingOrder_DeliveredAmmount))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pnl_Dashboard_Grid.add(pnl_PendingOrder);

        pnl_UniqueBuyer.setBackground(new java.awt.Color(204, 0, 0));

        lbl_UniqueBuyer_Icon.setForeground(new java.awt.Color(255, 255, 255));
        lbl_UniqueBuyer_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/unique_customer.png"))); // NOI18N

        lbl_UniqueBuyer_Name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_UniqueBuyer_Name.setForeground(new java.awt.Color(255, 255, 255));
        lbl_UniqueBuyer_Name.setText("Khách Hàng Độc Nhất");

        lbl_UniqueBuyer_Percent.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_UniqueBuyer_Percent.setForeground(new java.awt.Color(255, 255, 255));
        lbl_UniqueBuyer_Percent.setText("Tăng xxx%");

        lbl_UniqueBuyer_SoLuong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_UniqueBuyer_SoLuong.setForeground(new java.awt.Color(255, 255, 255));
        lbl_UniqueBuyer_SoLuong.setText("Số lượng: ");

        lbl_UniqueBuyer_Ammount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_UniqueBuyer_Ammount.setForeground(new java.awt.Color(255, 255, 255));
        lbl_UniqueBuyer_Ammount.setText("X");

        javax.swing.GroupLayout pnl_UniqueBuyerLayout = new javax.swing.GroupLayout(pnl_UniqueBuyer);
        pnl_UniqueBuyer.setLayout(pnl_UniqueBuyerLayout);
        pnl_UniqueBuyerLayout.setHorizontalGroup(
            pnl_UniqueBuyerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_UniqueBuyerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnl_UniqueBuyerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_UniqueBuyerLayout.createSequentialGroup()
                        .addComponent(lbl_UniqueBuyer_SoLuong)
                        .addGap(20, 20, 20)
                        .addComponent(lbl_UniqueBuyer_Ammount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnl_UniqueBuyerLayout.createSequentialGroup()
                        .addGroup(pnl_UniqueBuyerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_UniqueBuyer_Percent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_UniqueBuyer_Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_UniqueBuyer_Icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        pnl_UniqueBuyerLayout.setVerticalGroup(
            pnl_UniqueBuyerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_UniqueBuyerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbl_UniqueBuyer_Icon)
                .addGap(15, 15, 15)
                .addComponent(lbl_UniqueBuyer_Name)
                .addGap(10, 10, 10)
                .addGroup(pnl_UniqueBuyerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_UniqueBuyer_SoLuong)
                    .addComponent(lbl_UniqueBuyer_Ammount))
                .addGap(10, 10, 10)
                .addComponent(lbl_UniqueBuyer_Percent)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_Dashboard_Grid.add(pnl_UniqueBuyer);

        tblPendingOrder.setAutoCreateRowSorter(true);
        tblPendingOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MÃ HĐ", "KHÁCH HÀNG", "NGÀY LẬP", "LOẠI HĐ", "TRẠNG THÁI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPendingOrder.setFocusable(false);
        jScrollPane1.setViewportView(tblPendingOrder);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_Dashboard_Grid, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_Dashboard_Grid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void getConnection(Connection connection) {
        this.connection = connection;
        hoaDonDAO = new HoaDonDAO(this.connection);
        khachHangDAO = new KhachHangDAO(this.connection);

        loadDataToTblPendingOrder();
    }

    public void loadDataToTblPendingOrder() {
        try {
            modelTblPendingOrder.setRowCount(0);

            List<HoaDon> hoaDonList = hoaDonDAO.findExportPendingOrder();

            for (HoaDon hd : hoaDonList) {
                int id = hd.getMaHd();
                String tenKhach = khachHangDAO.getTenKhachByID(hd.getMaKhach());
                String ngayLap = hd.getNgayLapHoaDon();
                String loaiHD = hd.getLoaiHoaDon();
                String trangThai = hd.getTrangThai();

                modelTblPendingOrder.addRow(new Object[]{id, tenKhach, ngayLap, loaiHD, trangThai});
            }
        } catch (SQLException ex) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lbl_PendingOrder_Ammount;
    private javax.swing.JLabel lbl_PendingOrder_DaGiao;
    private javax.swing.JLabel lbl_PendingOrder_DeliveredAmmount;
    private javax.swing.JLabel lbl_PendingOrder_Icon;
    private javax.swing.JLabel lbl_PendingOrder_Name;
    private javax.swing.JLabel lbl_PendingOrder_SoLuong;
    private javax.swing.JLabel lbl_RevenueName;
    private javax.swing.JLabel lbl_Revenue_Currency;
    private javax.swing.JLabel lbl_Revenue_Icon;
    public javax.swing.JLabel lbl_Revenue_Money;
    public javax.swing.JLabel lbl_Revenue_Percent;
    public javax.swing.JLabel lbl_UniqueBuyer_Ammount;
    private javax.swing.JLabel lbl_UniqueBuyer_Icon;
    private javax.swing.JLabel lbl_UniqueBuyer_Name;
    public javax.swing.JLabel lbl_UniqueBuyer_Percent;
    private javax.swing.JLabel lbl_UniqueBuyer_SoLuong;
    private javax.swing.JPanel pnl_Dashboard_Grid;
    public javax.swing.JPanel pnl_PendingOrder;
    private javax.swing.JPanel pnl_Revenue;
    private javax.swing.JPanel pnl_UniqueBuyer;
    private javax.swing.JTable tblPendingOrder;
    // End of variables declaration//GEN-END:variables
}
