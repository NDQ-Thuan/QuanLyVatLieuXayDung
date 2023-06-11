package component.ComponentsForDashboard.chart;

import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAO.HoaDonDAO;

public class PopupChart extends javax.swing.JFrame {

    private Connection con;
    private HoaDonDAO hoaDonDAO;

    public PopupChart(Connection con) {
        initComponents();

        setTitle("Thống Kê");
        setLocationRelativeTo(null);

        this.con = con;
        hoaDonDAO = new HoaDonDAO(this.con);
        try {
            loadRevenueToChart();
        } catch (SQLException ex) {
            Logger.getLogger(PopupChart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chartRevenue = new component.ComponentsForDashboard.chart.Chart();
        chartOrder = new component.ComponentsForDashboard.chart.Chart();
        lblRevenueName = new javax.swing.JLabel();
        lblRevenueName1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chartRevenue.setBackground(new java.awt.Color(204, 204, 204));

        chartOrder.setBackground(new java.awt.Color(153, 153, 153));

        lblRevenueName.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblRevenueName.setForeground(new java.awt.Color(0, 102, 0));
        lblRevenueName.setText("DOANH SỐ BÁN HÀNG NĂM 2023");

        lblRevenueName1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblRevenueName1.setForeground(new java.awt.Color(0, 0, 153));
        lblRevenueName1.setText("TỔNG SỐ HÓA ĐƠN ĐẶT HÀNG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chartRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRevenueName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblRevenueName1)
                        .addGap(397, 397, 397))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(chartOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRevenueName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chartRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRevenueName1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chartOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PopupChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PopupChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PopupChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PopupChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    public void loadRevenueToChart() throws SQLException {
        chartRevenue.addLegend("Doanh Thu Theo Tháng (VNĐ)", new Color(0, 153, 0));

        for (int i = 1; i <= 12; i++) {
            int revenue = hoaDonDAO.totalRevenueByMonth(i);
            chartRevenue.addData(new ModelChart(i + "", new double[]{revenue}));
        }

        chartOrder.addLegend("Đơn Đặt Hàng Theo Tháng", new Color(0, 0, 153));

        for (int i = 1; i <= 12; i++) {
            int amount = hoaDonDAO.totalOrderByMonth(i);
            chartOrder.addData(new ModelChart(i + "", new double[]{amount}));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.ComponentsForDashboard.chart.Chart chartOrder;
    private component.ComponentsForDashboard.chart.Chart chartRevenue;
    private javax.swing.JLabel lblRevenueName;
    private javax.swing.JLabel lblRevenueName1;
    // End of variables declaration//GEN-END:variables
}
