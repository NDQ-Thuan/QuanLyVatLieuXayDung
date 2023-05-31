package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class DataTest {

    public static DefaultTableModel model;

    private static Connection con;

    private static ResultSet rs;

    public DataTest() {
        String url = "jdbc:sqlserver://localhost:1433;databasename=QLXD";
        try {
            con = DriverManager.getConnection(url, "sa", "123");
        } catch (SQLException ex) {
            Logger.getLogger(DataTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadData() {
        try {
            model.setRowCount(0);
            Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM STUDENTS";
            rs = stm.executeQuery(query);

            while (rs.next()) {

            }
        } catch (SQLException ex) {
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databasename=QLXD";
        try {
            con = DriverManager.getConnection(url, "sa", "123");
        } catch (SQLException ex) {
            Logger.getLogger(DataTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM HOADON";
            rs = stm.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("NGAYLAPHOADON"));
            }
        } catch (SQLException ex) {
        }
    }
}
