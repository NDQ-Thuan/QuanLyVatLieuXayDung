package swing;

import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import component.ConnectionPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainMenu extends javax.swing.JFrame {

    private String role = "QL";

    private JLabel[] lblMenuList;
    private CardLayout cardLayout;

    private ConnectionPanel[] componentPanel;

    private Connection connection;

    public MainMenu() {
        initComponents();

        setLocationRelativeTo(null);

        componentPanel = new ConnectionPanel[]{panelDashboard, panelSupplier, panelWarehouse, panelProduct, panelOrder};

        lblMenuList = new JLabel[]{lblMenu_Dashboard, lblMenu_Warehouse, lblMenu_Product, lblMenu_Supplier, lblMenu_LogOut, lblMenu_Order};

        cardLayout = (CardLayout) pnlCardLayout.getLayout();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCardLayout = new javax.swing.JPanel();
        panelDashboard = new component.PanelDashboard();
        panelSupplier = new component.PanelSupplier();
        panelWarehouse = new component.PanelWarehouse();
        panelProduct = new component.PanelProduct();
        panelOrder = new component.PanelOrder();
        pnlMenu = new javax.swing.JPanel();
        pnlUserInfo = new javax.swing.JPanel();
        lblInfo_Img = new javax.swing.JLabel();
        lblInfo_UserName = new javax.swing.JLabel();
        lblInfo_Job = new javax.swing.JLabel();
        lblInfo_Company = new javax.swing.JLabel();
        lblMenu_Dashboard = new javax.swing.JLabel();
        lblMenu_Supplier = new javax.swing.JLabel();
        lblMenu_Warehouse = new javax.swing.JLabel();
        lblMenu_Product = new javax.swing.JLabel();
        lblMenu_LogOut = new javax.swing.JLabel();
        lblMenu_Order = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlCardLayout.setLayout(new java.awt.CardLayout());
        pnlCardLayout.add(panelDashboard, "cardDashboard");
        pnlCardLayout.add(panelSupplier, "cardSupplier");
        pnlCardLayout.add(panelWarehouse, "cardWarehouse");

        panelProduct.setName(""); // NOI18N
        pnlCardLayout.add(panelProduct, "cardProduct");
        pnlCardLayout.add(panelOrder, "cardOrder");

        pnlMenu.setBackground(new java.awt.Color(0, 0, 102));

        pnlUserInfo.setBackground(new java.awt.Color(0, 0, 102));
        pnlUserInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        pnlUserInfo.setForeground(new java.awt.Color(255, 255, 255));

        lblInfo_Img.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblInfo_Img.setForeground(new java.awt.Color(255, 255, 255));
        lblInfo_Img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfo_Img.setText("ẢNH");
        lblInfo_Img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        lblInfo_UserName.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblInfo_UserName.setForeground(new java.awt.Color(255, 255, 255));
        lblInfo_UserName.setText("Tên user: Thuận Đẹp Trai");

        lblInfo_Job.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblInfo_Job.setForeground(new java.awt.Color(255, 255, 255));
        lblInfo_Job.setText("Chức vụ: Trùm Nhóm");

        lblInfo_Company.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblInfo_Company.setForeground(new java.awt.Color(255, 255, 255));
        lblInfo_Company.setText("Công ty: 3BROS SCMS");

        javax.swing.GroupLayout pnlUserInfoLayout = new javax.swing.GroupLayout(pnlUserInfo);
        pnlUserInfo.setLayout(pnlUserInfoLayout);
        pnlUserInfoLayout.setHorizontalGroup(
            pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInfo_Img, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInfo_UserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInfo_Job, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInfo_Company, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlUserInfoLayout.setVerticalGroup(
            pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUserInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlUserInfoLayout.createSequentialGroup()
                        .addComponent(lblInfo_UserName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblInfo_Company))
                    .addGroup(pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblInfo_Img, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblInfo_Job)))
                .addContainerGap())
        );

        lblMenu_Dashboard.setBackground(new java.awt.Color(0, 0, 102));
        lblMenu_Dashboard.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblMenu_Dashboard.setForeground(new java.awt.Color(255, 255, 255));
        lblMenu_Dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/dashboard.png"))); // NOI18N
        lblMenu_Dashboard.setText("  Thống Kê");
        lblMenu_Dashboard.setAlignmentX(0.5F);
        lblMenu_Dashboard.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        lblMenu_Dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMenu_Dashboard.setOpaque(true);
        lblMenu_Dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMenu_DashboardMousePressed(evt);
            }
        });

        lblMenu_Supplier.setBackground(new java.awt.Color(0, 0, 102));
        lblMenu_Supplier.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblMenu_Supplier.setForeground(new java.awt.Color(255, 255, 255));
        lblMenu_Supplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/nha_cung_cap.png"))); // NOI18N
        lblMenu_Supplier.setText("  Nhà Cung Cấp");
        lblMenu_Supplier.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        lblMenu_Supplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMenu_Supplier.setOpaque(true);
        lblMenu_Supplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMenu_SupplierMousePressed(evt);
            }
        });

        lblMenu_Warehouse.setBackground(new java.awt.Color(0, 0, 102));
        lblMenu_Warehouse.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblMenu_Warehouse.setForeground(new java.awt.Color(255, 255, 255));
        lblMenu_Warehouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/inventory.png"))); // NOI18N
        lblMenu_Warehouse.setText("  Kho hàng");
        lblMenu_Warehouse.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        lblMenu_Warehouse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMenu_Warehouse.setOpaque(true);
        lblMenu_Warehouse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMenu_WarehouseMousePressed(evt);
            }
        });

        lblMenu_Product.setBackground(new java.awt.Color(0, 0, 102));
        lblMenu_Product.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblMenu_Product.setForeground(new java.awt.Color(255, 255, 255));
        lblMenu_Product.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/material.png"))); // NOI18N
        lblMenu_Product.setText("  Danh sách vật liệu");
        lblMenu_Product.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        lblMenu_Product.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMenu_Product.setOpaque(true);
        lblMenu_Product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMenu_ProductMousePressed(evt);
            }
        });

        lblMenu_LogOut.setBackground(new java.awt.Color(0, 0, 102));
        lblMenu_LogOut.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblMenu_LogOut.setForeground(new java.awt.Color(255, 255, 255));
        lblMenu_LogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/logout.png"))); // NOI18N
        lblMenu_LogOut.setText("  Đăng xuất");
        lblMenu_LogOut.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        lblMenu_LogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMenu_LogOut.setOpaque(true);
        lblMenu_LogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMenu_LogOutMousePressed(evt);
            }
        });

        lblMenu_Order.setBackground(new java.awt.Color(0, 0, 102));
        lblMenu_Order.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblMenu_Order.setForeground(new java.awt.Color(255, 255, 255));
        lblMenu_Order.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/receipt.png"))); // NOI18N
        lblMenu_Order.setText("  Đơn hàng");
        lblMenu_Order.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        lblMenu_Order.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMenu_Order.setOpaque(true);
        lblMenu_Order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMenu_OrderMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMenu_Dashboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlUserInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMenu_Supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMenu_Warehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMenu_Product, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMenu_LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMenu_Order, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlUserInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu_Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblMenu_Supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblMenu_Warehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblMenu_Product, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblMenu_Order, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMenu_LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlCardLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCardLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblMenu_DashboardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenu_DashboardMousePressed
        cardLayout.show(pnlCardLayout, "cardDashboard");
    }//GEN-LAST:event_lblMenu_DashboardMousePressed

    private void lblMenu_SupplierMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenu_SupplierMousePressed
        cardLayout.show(pnlCardLayout, "cardSupplier");
    }//GEN-LAST:event_lblMenu_SupplierMousePressed

    private void lblMenu_WarehouseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenu_WarehouseMousePressed
        cardLayout.show(pnlCardLayout, "cardWarehouse");
    }//GEN-LAST:event_lblMenu_WarehouseMousePressed

    private void lblMenu_ProductMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenu_ProductMousePressed
        cardLayout.show(pnlCardLayout, "cardProduct");
    }//GEN-LAST:event_lblMenu_ProductMousePressed

    private void lblMenu_OrderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenu_OrderMousePressed
        cardLayout.show(pnlCardLayout, "cardOrder");
    }//GEN-LAST:event_lblMenu_OrderMousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        addMouseEffectForPnlMenu();
        lblMenu_Dashboard.setBackground(new Color(0, 0, 55));

        connectAllPanelToMainMenu();
    }//GEN-LAST:event_formWindowOpened

    private void lblMenu_LogOutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenu_LogOutMousePressed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblMenu_LogOutMousePressed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightFlatIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainMenu().setVisible(true);
        });
    }

    public void connectAllPanelToMainMenu() {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyVatLieuXayDung";

            this.connection = DriverManager.getConnection(url, "sa", "123");

            for (ConnectionPanel conPnl : componentPanel) {
                conPnl.setConnection(connection);
                conPnl.connectMainMenu(this);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addMouseEffectForPnlMenu() {
        for (JLabel label : lblMenuList) {
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    for (JLabel label : lblMenuList) {
                        label.setBackground(new Color(0, 0, 102));
                    }
                    JLabel lbl = (JLabel) e.getSource();
                    lbl.setBackground(new Color(0, 0, 55));
                }
            });
        }
    }

    public void restartForm() {
        for (ConnectionPanel conPnl : componentPanel) {
            conPnl.resetPanelData();
        }
    }

    public void setUserRole(String role) {
        this.role = role;
    }

    public String getUserRole() {
        return this.role;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblInfo_Company;
    private javax.swing.JLabel lblInfo_Img;
    private javax.swing.JLabel lblInfo_Job;
    private javax.swing.JLabel lblInfo_UserName;
    private javax.swing.JLabel lblMenu_Dashboard;
    private javax.swing.JLabel lblMenu_LogOut;
    private javax.swing.JLabel lblMenu_Order;
    private javax.swing.JLabel lblMenu_Product;
    private javax.swing.JLabel lblMenu_Supplier;
    private javax.swing.JLabel lblMenu_Warehouse;
    private component.PanelDashboard panelDashboard;
    private component.PanelOrder panelOrder;
    private component.PanelProduct panelProduct;
    private component.PanelSupplier panelSupplier;
    private component.PanelWarehouse panelWarehouse;
    private javax.swing.JPanel pnlCardLayout;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlUserInfo;
    // End of variables declaration//GEN-END:variables
}
