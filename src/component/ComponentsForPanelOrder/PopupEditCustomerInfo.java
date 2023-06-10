package component.ComponentsForPanelOrder;

import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import model.Object.KhachHang;
import model.DAO.KhachHangDAO;

public class PopupEditCustomerInfo extends javax.swing.JFrame {

    private int index = -1;

    private TabPanelExport pnlExport;

    private Connection connection;
    private KhachHangDAO khachDAO;

    public PopupEditCustomerInfo(TabPanelExport panelExport) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        this.pnlExport = panelExport;
        getConnection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExit = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblName.setText("TÊN KHÁCH");

        txtName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        lblID.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        lblID.setFocusable(false);
        lblID.setRequestFocusEnabled(false);
        lblID.setVerifyInputWhenFocusTarget(false);

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAddress.setText("ĐỊA CHỈ");

        txtAddress.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPhone.setText("SỐ ĐIỆN THOẠI");

        txtPhone.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblName)
                        .addGap(144, 144, 144)
                        .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                    .addComponent(txtPhone)
                    .addComponent(txtAddress)
                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddress)
                            .addComponent(lblPhone))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(lblID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblPhone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnConfirm))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        updateKhachHang();
    }//GEN-LAST:event_btnConfirmActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightFlatIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
        }
    }

    public void errorMessage(String str) {
        JOptionPane.showMessageDialog(null, str, "LỖI", JOptionPane.ERROR_MESSAGE);
    }

    public int customConfirmDialog(String str) {
        return JOptionPane.showConfirmDialog(null, str, "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    public void getConnection() {
        this.connection = pnlExport.getPnlConnection();
        khachDAO = new KhachHangDAO(this.connection);

        loadExistedCustomer();
    }

    public void loadExistedCustomer() {
        KhachHang khachHang = this.pnlExport.getCurrentKhachHang();

        lblID.setText(khachHang.getMaKhach() + "");
        txtName.setText(khachHang.getTenKhach());
        txtAddress.setText(khachHang.getDiaChi());
        txtPhone.setText(khachHang.getSdt());
    }

    public KhachHang readForm() {
        int id = Integer.parseInt(lblID.getText());
        String ten = txtName.getText();
        String diaChi = txtAddress.getText();
        String sdt = txtPhone.getText();

        return new KhachHang(id, ten, diaChi, sdt);
    }

    public boolean validateInfo() {
        boolean flag = true;

        String ten = txtName.getText().trim();
        String diaChi = txtAddress.getText().trim();
        String sdt = txtPhone.getText().trim();

        if (ten.isBlank() || diaChi.isBlank() || sdt.isBlank()) {
            errorMessage("Vui lòng không để trống thông tin khách hàng!!!");
            return false;
        }

        if (ten.length() > 50) {
            errorMessage("Tên khách hàng không được vượt quá 50 ký tự!!!");
            flag = false;
        }

        if (diaChi.length() > 50) {
            errorMessage("Địa chỉ của khách hàng không được vượt quá 100 ký tự");
            flag = false;
        }

        if (sdt.length() > 15) {
            errorMessage("Số điện thoại của khách hàng không được vượt quá 15 chữ số");
            flag = false;
        }

        return flag;
    }

    public void updateKhachHang() {
        if (validateInfo()) {
            KhachHang oldKhach = this.pnlExport.getCurrentKhachHang();
            KhachHang newKhachHang = readForm();

            if (!oldKhach.equals(newKhachHang)) {
                if (customConfirmDialog("Tiếp tục cập nhật thông tin khách hàng này?") == JOptionPane.YES_OPTION) {
                    lblID.setText(newKhachHang.getMaKhach() + "");
                    txtName.setText(newKhachHang.getTenKhach());
                    txtAddress.setText(newKhachHang.getDiaChi());
                    txtPhone.setText(newKhachHang.getSdt());

                    try {
                        khachDAO.update(newKhachHang);
                    } catch (SQLException ex) {
                        Logger.getLogger(PopupEditCustomerInfo.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    returnKhach();
                }
            }
        }
    }

    public void returnKhach() {
        this.pnlExport.addCustomerInfo(readForm());
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
