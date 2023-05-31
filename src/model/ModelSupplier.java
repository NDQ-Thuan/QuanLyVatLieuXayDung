
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public final class ModelSupplier {
    public DefaultTableModel model;

    private Connection con;

    private ResultSet rs;
    
    public ModelSupplier(JTable tbl) {
        this.model = (DefaultTableModel) tbl.getModel();

        String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyVatLieuXayDung";
        try {
            con = DriverManager.getConnection(url, "sa", "123");
        } catch (SQLException ex) {
            Logger.getLogger(ModelOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadData();
    }
    
    
    public void loadData() {
        try {
            model.setRowCount(0);
            Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM NHACUNGCAP";
            rs = stm.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("MANCC");
                String tenncc = rs.getString("TENNCC");
                String diachi = rs.getString("DIACHI");
                String sdt = rs.getString("SDT");
                ////////////////////////////////////////////////////////////////

                model.addRow(new Object[]{id, tenncc, diachi,sdt});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void addData(int MANCC, String TENNCC, String DIACHI, String SDT) {
        try {
            String query = "INSERT INTO NHACUNGCAP(MANCC, TENNCC, DIACHI, SDT)VALUES(?, ?, ?, ?);";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, MANCC);
            pst.setString(2, TENNCC);
            pst.setString(3, DIACHI);
            pst.setString(3, SDT);
            pst.executeUpdate();
            System.out.println("Add Successfully :" + MANCC);
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }
    
    public void updateData(int MANCC, String TENNCC, String DIACHI, String SDT) {
        try {
            String query = "UPDATE NHACUNGCAP SET TENNCC=?,DIACHI=?, SDT=? WHERE MANCC='" + MANCC + "'";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, MANCC);
            pst.setString(2, TENNCC);
            pst.setString(2, DIACHI);
            pst.setString(2, SDT);
            pst.executeUpdate();
             System.out.println("Update Successfully :" + MANCC);
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }
    
    public void deleteData(String MANCC) {
        try {
            String query = "DELETE FROM NHACUNGCAP WHERE MANCC='" + MANCC + "'";

            PreparedStatement pst = con.prepareStatement(query);

            pst.executeUpdate();
            System.out.println("Delete  Successfully: " + MANCC);
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }
    
    public Supplier getSupplier(int id) {
        String tenncc = "";
        String diachi = "";
        String sdt = "";
        try {
            Statement stm = con.createStatement();
            String query = "SELECT * FROM NHACUNGCAP WHERE ID LIKE '" + id + "'";
            rs = stm.executeQuery(query);

            while (rs.next()) {
                if (rs.getString("MANCC").equals(String.valueOf(id))) {
                    tenncc = rs.getString("TENNCC");
                    diachi = rs.getString("DIACHI");
                    sdt = rs.getString("SDT");

                }
            }

            System.out.println("Kết nối thành công");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return new Supplier(id, tenncc, diachi,sdt);
    }
}
