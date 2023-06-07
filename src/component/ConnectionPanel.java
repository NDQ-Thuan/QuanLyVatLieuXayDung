package component;

import java.sql.Connection;
import swing.MainMenu;

public abstract class ConnectionPanel extends javax.swing.JPanel {

    Connection connection;
    MainMenu mainMenu;

    String role = "QL";

    public abstract void setConnection(Connection connection);

    public abstract void resetPanelData();

    public abstract void connectMainMenu(MainMenu mainMenu);
}
