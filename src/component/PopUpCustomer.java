package component;

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
import model.KhachHang;
import model.KhachHangDAO;

public class PopUpCustomer extends javax.swing.JFrame {

    private int index = -1;

    private PanelOrder pnlOrder;
    private DefaultTableModel modelTblCustomer;

    private Connection connection;
    private KhachHangDAO khachDAO;

    public PopUpCustomer(PanelOrder pnlOrder) {
        initComponents();
        setLocationRelativeTo(null);

        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
        modelTblCustomer = (DefaultTableModel) tblCustomer.getModel();

        this.pnlOrder = pnlOrder;
        getConnection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        btnConfirm = new javax.swing.JButton();

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
        btnConfirm.setText("CHỌN KHÁCH HÀNG");
        btnConfirm.setFocusable(false);
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConfirm)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnConfirm)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCustomerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerMousePressed
        index = tblCustomer.getSelectedRow();
    }//GEN-LAST:event_tblCustomerMousePressed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        returnKhach();
    }//GEN-LAST:event_btnConfirmActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightFlatIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
        }

//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PopUpCustomer().setVisible(true);
//            }
//        });
    }

    public void getConnection() {
        this.connection = pnlOrder.getPnlConnection();

        khachDAO = new KhachHangDAO(this.connection);

        loadDataToTblCustomer();
    }

    public void loadDataToTblCustomer() {
        try {
            modelTblCustomer.setRowCount(0);

            List<KhachHang> khachList = khachDAO.findAll();

            for (KhachHang khach : khachList) {
                int maKhach = khach.getMaKhach();
                String tenKhach = khach.getTenKhach();
                String sdt = khach.getSdt();
                String diachi = khach.getDiaChi();
                modelTblCustomer.addRow(new Object[]{maKhach, tenKhach, sdt, diachi});
            }
        } catch (SQLException ex) {
            Logger.getLogger(PopUpCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void returnKhach() {
        try {
            int maKhach = (int) modelTblCustomer.getValueAt(index, 0);
            KhachHang khach = khachDAO.findById(maKhach);
            pnlOrder.addCustomerInfo(khach);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(PopUpCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCustomer;
    // End of variables declaration//GEN-END:variables
}
