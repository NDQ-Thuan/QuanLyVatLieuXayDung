package component.ComponentsForPanelOrder;

import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import customTable.TableCustom;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;
import model.Object.KhachHang;
import model.DAO.KhachHangDAO;
import model.DAO.KhoHangDAO;

public class PopupWarehouse extends javax.swing.JFrame {

    private int index = -1;

    private TabPanelImport panelImport;
    private DefaultTableModel modelTblCustomer;

    private Connection connection;
    private KhachHangDAO khachDAO;

    public PopupWarehouse(TabPanelImport panelImport) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        modelTblCustomer = (DefaultTableModel) tblCustomer.getModel();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);

        this.panelImport = panelImport;
        getConnection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        btnConfirm = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ KHÁCH", "TÊN KHÁCH", "SĐT", "ĐỊA CHỈ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCustomer.setFocusable(false);
        tblCustomer.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblCustomer.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblCustomer.getTableHeader().setReorderingAllowed(false);
        tblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblCustomerMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomer);

        btnConfirm.setBackground(new java.awt.Color(0, 102, 0));
        btnConfirm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConfirm.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirm.setText("XÁC NHẬN");
        btnConfirm.setFocusable(false);
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(153, 0, 0));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("HỦY");
        btnExit.setFocusable(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConfirm)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnExit)
                .addGap(108, 108, 108)
                .addComponent(btnConfirm))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCustomerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerMousePressed
        index = tblCustomer.getSelectedRow();
    }//GEN-LAST:event_tblCustomerMousePressed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        returnKhach();
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightFlatIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
        }
    }

    public void getConnection() {
        this.connection = panelImport.getPnlConnection();

        khachDAO = new KhachHangDAO(this.connection);

        loadDataToTblCustomer();
    }

    public void loadDataToTblCustomer() {
        try {
            modelTblCustomer.setRowCount(0);

            List<KhachHang> khachList = khachDAO.findWarehouse();

            for (KhachHang khach : khachList) {
                int maKhach = khach.getMaKhach();
                String tenKhach = khach.getTenKhach();
                String sdt = khach.getSdt();
                String diachi = khach.getDiaChi();
                modelTblCustomer.addRow(new Object[]{maKhach, tenKhach, sdt, diachi});
            }
        } catch (SQLException ex) {
            Logger.getLogger(PopupWarehouse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void returnKhach() {
        try {
            int maKhach = (int) modelTblCustomer.getValueAt(index, 0);
            KhachHang khach = khachDAO.findById(maKhach);
            panelImport.addWarehouseInfo(khach);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(PopupWarehouse.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnExit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCustomer;
    // End of variables declaration//GEN-END:variables
}
