package component.PanelForMainMenu;

import component.ComponentsForDashboard.chart.PopupChart;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import model.Object.HoaDon;
import model.DAO.HoaDonDAO;
import model.DAO.KhachHangDAO;
import customTable.TableCustom;
import java.awt.Point;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Object.KhachHang;
import swing.MainMenu;

public class PanelDashboard extends ConnectionPanel {

    private DefaultTableModel modelTblPendingOrder;
    private TableColumnModel columnModelTblPendingOrder;
    private HoaDonDAO hoaDonDAO;
    private KhachHangDAO khachHangDAO;

    public PanelDashboard() {
        initComponents();
        modelTblPendingOrder = (DefaultTableModel) tblPendingOrder.getModel();
        columnModelTblPendingOrder = tblPendingOrder.getColumnModel();

        columnModelTblPendingOrder.getColumn(0).setPreferredWidth(30);
        columnModelTblPendingOrder.getColumn(1).setPreferredWidth(200);
        columnModelTblPendingOrder.getColumn(2).setPreferredWidth(200);
        columnModelTblPendingOrder.getColumn(3).setPreferredWidth(90);
        columnModelTblPendingOrder.getColumn(4).setPreferredWidth(50);

        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
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
        lbl_Revenue_LastTwoMonth = new javax.swing.JLabel();
        pnl_PendingOrder = new javax.swing.JPanel();
        lbl_PendingOrder_Icon = new javax.swing.JLabel();
        lbl_PendingOrder_Name = new javax.swing.JLabel();
        lbl_PendingOrder_SoLuong = new javax.swing.JLabel();
        lbl_PendingOrder_Ammount = new javax.swing.JLabel();
        lbl_PendingOrder_DaHuy = new javax.swing.JLabel();
        lbl_PendingOrder_CancelledAmmount = new javax.swing.JLabel();
        pnl_UniqueBuyer = new javax.swing.JPanel();
        lbl_UniqueBuyer_Icon = new javax.swing.JLabel();
        lbl_UniqueBuyer_Name = new javax.swing.JLabel();
        lbl_UniqueBuyer_Percent = new javax.swing.JLabel();
        lbl_UniqueBuyer_SoLuong = new javax.swing.JLabel();
        lbl_UniqueBuyer_Ammount = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPendingOrder = new javax.swing.JTable();
        lblDHCG = new javax.swing.JLabel();

        pnl_Dashboard_Grid.setLayout(new java.awt.GridLayout(1, 0, 30, 3));

        pnl_Revenue.setBackground(new java.awt.Color(0, 153, 51));
        pnl_Revenue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_Revenue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_RevenueMousePressed(evt);
            }
        });

        lbl_Revenue_Icon.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Revenue_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MainMenuIcon/revenue.png"))); // NOI18N

        lbl_RevenueName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_RevenueName.setForeground(new java.awt.Color(255, 255, 255));
        lbl_RevenueName.setText("Doanh Số Bán Hàng 2023 (Tháng x)");

        lbl_Revenue_Currency.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Revenue_Currency.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Revenue_Currency.setText("VNĐ");

        lbl_Revenue_Money.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Revenue_Money.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Revenue_Money.setText("000.000");

        lbl_Revenue_LastTwoMonth.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_Revenue_LastTwoMonth.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Revenue_LastTwoMonth.setText("Tháng x: VNĐ ");

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
                    .addComponent(lbl_Revenue_LastTwoMonth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_RevenueName, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
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
                .addComponent(lbl_Revenue_LastTwoMonth)
                .addGap(56, 56, 56))
        );

        pnl_Dashboard_Grid.add(pnl_Revenue);

        pnl_PendingOrder.setBackground(new java.awt.Color(255, 153, 0));

        lbl_PendingOrder_Icon.setForeground(new java.awt.Color(255, 255, 255));
        lbl_PendingOrder_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MainMenuIcon/pending_order.png"))); // NOI18N

        lbl_PendingOrder_Name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_PendingOrder_Name.setForeground(new java.awt.Color(255, 255, 255));
        lbl_PendingOrder_Name.setText("Đơn Xuất Kho Chưa Giao");

        lbl_PendingOrder_SoLuong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_PendingOrder_SoLuong.setForeground(new java.awt.Color(255, 255, 255));
        lbl_PendingOrder_SoLuong.setText("Số lượng: ");

        lbl_PendingOrder_Ammount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_PendingOrder_Ammount.setForeground(new java.awt.Color(255, 255, 255));
        lbl_PendingOrder_Ammount.setText("X");

        lbl_PendingOrder_DaHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_PendingOrder_DaHuy.setForeground(new java.awt.Color(255, 255, 255));
        lbl_PendingOrder_DaHuy.setText("Đơn xuất kho bị hủy:");

        lbl_PendingOrder_CancelledAmmount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_PendingOrder_CancelledAmmount.setForeground(new java.awt.Color(255, 255, 255));
        lbl_PendingOrder_CancelledAmmount.setText("X");

        javax.swing.GroupLayout pnl_PendingOrderLayout = new javax.swing.GroupLayout(pnl_PendingOrder);
        pnl_PendingOrder.setLayout(pnl_PendingOrderLayout);
        pnl_PendingOrderLayout.setHorizontalGroup(
            pnl_PendingOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_PendingOrderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnl_PendingOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_PendingOrderLayout.createSequentialGroup()
                        .addComponent(lbl_PendingOrder_DaHuy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_PendingOrder_CancelledAmmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnl_PendingOrderLayout.createSequentialGroup()
                        .addComponent(lbl_PendingOrder_SoLuong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_PendingOrder_Ammount, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                    .addComponent(lbl_PendingOrder_Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_PendingOrderLayout.createSequentialGroup()
                        .addComponent(lbl_PendingOrder_Icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(53, 53, 53)))
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
                    .addComponent(lbl_PendingOrder_DaHuy)
                    .addComponent(lbl_PendingOrder_CancelledAmmount))
                .addGap(56, 56, 56))
        );

        pnl_Dashboard_Grid.add(pnl_PendingOrder);

        pnl_UniqueBuyer.setBackground(new java.awt.Color(204, 0, 0));

        lbl_UniqueBuyer_Icon.setForeground(new java.awt.Color(255, 255, 255));
        lbl_UniqueBuyer_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MainMenuIcon/unique_customer.png"))); // NOI18N

        lbl_UniqueBuyer_Name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_UniqueBuyer_Name.setForeground(new java.awt.Color(255, 255, 255));
        lbl_UniqueBuyer_Name.setText("Khách Hàng Độc Nhất");

        lbl_UniqueBuyer_Percent.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_UniqueBuyer_Percent.setForeground(new java.awt.Color(255, 255, 255));
        lbl_UniqueBuyer_Percent.setText("Giảm 14.7%");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_UniqueBuyer_Ammount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbl_UniqueBuyer_Percent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_UniqueBuyer_Name, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                    .addComponent(lbl_UniqueBuyer_Icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
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
                .addContainerGap())
        );

        pnl_Dashboard_Grid.add(pnl_UniqueBuyer);

        tblPendingOrder.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tblPendingOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        tblPendingOrder.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPendingOrder.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPendingOrder.setShowGrid(true);
        tblPendingOrder.getTableHeader().setReorderingAllowed(false);
        tblPendingOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPendingOrderMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblPendingOrder);

        lblDHCG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDHCG.setText("ĐƠN XUẤT KHO CHƯA GIAO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDHCG, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_Dashboard_Grid, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_Dashboard_Grid, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(lblDHCG)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblPendingOrderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPendingOrderMousePressed
        Point point = evt.getPoint();
        int row = tblPendingOrder.rowAtPoint(point);
        if (evt.getClickCount() == 2 && tblPendingOrder.getSelectedRow() != -1) {
            int id = (int) tblPendingOrder.getValueAt(row, 0);
            this.mainMenu.switchCardExportOrder(id);
        }
    }//GEN-LAST:event_tblPendingOrderMousePressed

    private void pnl_RevenueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_RevenueMousePressed
        PopupChart popup = new PopupChart(this.connection);
        popup.setVisible(true);
    }//GEN-LAST:event_pnl_RevenueMousePressed

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
        hoaDonDAO = new HoaDonDAO(this.connection);
        khachHangDAO = new KhachHangDAO(this.connection);

        loadDataToTblPendingOrder();
        loadDataRevenuePanel();
        loadDataOrderPanel();
    }

    @Override
    public void connectMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
        this.role = mainMenu.getUserRole();
    }

    @Override
    public void resetPanelData() {
        loadDataRevenuePanel();
        loadDataOrderPanel();
        loadDataToTblPendingOrder();
    }

    public void loadDataToTblPendingOrder() {
        try {
            modelTblPendingOrder.setRowCount(0);

            List<HoaDon> hoaDonList = hoaDonDAO.findExportPendingOrder();

            for (HoaDon hd : hoaDonList) {
                int id = hd.getMaHd();
                String tenKhach = khachHangDAO.getNameByID(hd.getMaKhach());
                String ngayLap = hd.getNgayLapHoaDon();
                String loaiHD = hd.getLoaiHoaDon();
                String trangThai = hd.getTrangThai();

                modelTblPendingOrder.addRow(new Object[]{id, tenKhach, ngayLap, loaiHD, trangThai});
            }

            List<KhachHang> khList = khachHangDAO.findUniqueCustomer();
            lbl_UniqueBuyer_Ammount.setText(khList.size() + "");
        } catch (SQLException ex) {
        }
    }

    public void loadDataRevenuePanel() {
        try {
            LocalDate currentDate = LocalDate.now();
            int thisMonth = currentDate.getMonthValue();
            int lastMonth = currentDate.getMonthValue() - 1;

            int revenueThisMonth = hoaDonDAO.totalRevenueByMonth(thisMonth);
            int revenueLastMonth = hoaDonDAO.totalRevenueByMonth(lastMonth);

            lbl_RevenueName.setText("Doanh Số Bán Hàng 2023 (Tháng " + thisMonth + ")");

            lbl_Revenue_Money.setText(formatMoneyString(revenueThisMonth));

            lbl_Revenue_LastTwoMonth.setText("Tháng " + lastMonth + ": VNĐ " + formatMoneyString(revenueLastMonth));
        } catch (SQLException ex) {
            Logger.getLogger(PanelDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDataOrderPanel() {
        List<HoaDon> hoaDonList = hoaDonDAO.findExportPendingOrder();
        lbl_PendingOrder_Ammount.setText(hoaDonList.size() + "");

        List<HoaDon> cancelledHoaDonList = hoaDonDAO.findCancelledOrder();
        lbl_PendingOrder_CancelledAmmount.setText(cancelledHoaDonList.size() + "");
    }

    public String formatMoneyString(int money) {
        double number = money;

        NumberFormat numberFormat = new DecimalFormat("#,###");

        return numberFormat.format(number);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDHCG;
    public javax.swing.JLabel lbl_PendingOrder_Ammount;
    private javax.swing.JLabel lbl_PendingOrder_CancelledAmmount;
    private javax.swing.JLabel lbl_PendingOrder_DaHuy;
    private javax.swing.JLabel lbl_PendingOrder_Icon;
    private javax.swing.JLabel lbl_PendingOrder_Name;
    private javax.swing.JLabel lbl_PendingOrder_SoLuong;
    private javax.swing.JLabel lbl_RevenueName;
    private javax.swing.JLabel lbl_Revenue_Currency;
    private javax.swing.JLabel lbl_Revenue_Icon;
    public javax.swing.JLabel lbl_Revenue_LastTwoMonth;
    public javax.swing.JLabel lbl_Revenue_Money;
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
