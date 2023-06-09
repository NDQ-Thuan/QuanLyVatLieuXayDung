package component.PanelForMainMenu;

import java.sql.Connection;
import swing.MainMenu;

public final class PanelOrder extends ConnectionPanel {

    public PanelOrder() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        tabPanelExport = new component.ComponentsForPanelOrder.TabPanelExport();

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jTabbedPane1.addTab("XUẤT HÀNG", tabPanelExport);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;

        tabPanelExport.getConnection(this.connection, this);
    }

    @Override
    public void connectMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
        this.role = mainMenu.getUserRole();
    }

    @Override
    public void resetPanelData() {
        tabPanelExport.resetPanel();
    }

    public String getUserRole() {
        return this.role;
    }

    public void askMainMenuToRestart() {
        this.mainMenu.restartForm();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    private component.ComponentsForPanelOrder.TabPanelExport tabPanelExport;
    // End of variables declaration//GEN-END:variables

}
