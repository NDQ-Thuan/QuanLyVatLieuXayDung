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

        tabbedPane = new javax.swing.JTabbedPane();
        tabPanelExport = new component.ComponentsForPanelOrder.TabPanelExport();

        tabbedPane.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        tabbedPane.addTab("XUẤT HÀNG", tabPanelExport);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
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

    public void exportDragTableToID(int id) {
        this.tabPanelExport.dragTableToID(id);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.ComponentsForPanelOrder.TabPanelExport tabPanelExport;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables

}
