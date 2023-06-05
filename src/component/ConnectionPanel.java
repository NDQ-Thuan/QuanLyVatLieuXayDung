package component;

import javax.swing.JPanel;
import java.sql.Connection;

public abstract class ConnectionPanel extends javax.swing.JPanel {

    public abstract void getConnection(Connection connection);

    public abstract void disableButtonOnUserRole();
}
