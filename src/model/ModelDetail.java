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

public final class ModelDetail {

    public DefaultTableModel model;

    private Connection con;

    private ResultSet rs;
    
    public ModelDetail(JTable tbl) {
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
            String query = "SELECT * FROM HOADONCHITIET";
            rs = stm.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("MAHD");
                int idsp = rs.getInt("MASP");
                int sl = rs.getInt("SOLUONG");
                ////////////////////////////////////////////////////////////////

                model.addRow(new Object[]{id, idsp, sl});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void addData(int MAHD, int MASP, int SOLUONG) {
        try {
            String query = "INSERT INTO HOADONCHITIET(MAHD, MASP, SOLUONG)VALUES(?, ?, ?);";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, MAHD);
            pst.setInt(2, MASP);
            pst.setInt(3, SOLUONG);
            pst.executeUpdate();
            System.out.println("Add Successfully :" + MAHD);
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }
    
    public void updateData(int MAHD, int MASP, int SOLUONG) {
        try {
            String query = "UPDATE HOADONCHITIET SET MASP=?,SOLUONG=? WHERE MAHD='" + MAHD + "'";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, MASP);
            pst.setInt(2, SOLUONG);
            pst.executeUpdate();
             System.out.println("Update Successfully :" + MAHD);
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }
    
    public void deleteData(String MAHD) {
        try {
            String query = "DELETE FROM HOADONCHITIET WHERE MAHD='" + MAHD + "'"
                    + "DELETE FROM HOADON WHERE MAHD='" + MAHD + "'";
            PreparedStatement pst = con.prepareStatement(query);

            pst.executeUpdate();
            System.out.println("Delete  Successfully: " + MAHD);
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }
    
    public Detail getDetail(int id) {
        int idsp = 0; 
        int sl = 0; 
        try {
            Statement stm = con.createStatement();
            String query = "SELECT * FROM HOADONCHITIET WHERE ID LIKE '" + id + "'";
            rs = stm.executeQuery(query);

            while (rs.next()) {
                if (rs.getString("MAHD").equals(String.valueOf(id))) {
                    idsp = rs.getInt("MASP");
                    sl = rs.getInt("SOLUONG");

                }
            }

            System.out.println("Kết nối thành công");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return new Detail(id, idsp, sl);
    }
}
