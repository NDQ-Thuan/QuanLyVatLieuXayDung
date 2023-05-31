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

public class ModelProduct {

    public DefaultTableModel model;

    private Connection con;

    private ResultSet rs;

    public ModelProduct(JTable tbl) {
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
            String query = "SELECT *\n"
                    + "FROM LOAIHANG LH\n"
                    + "JOIN SANPHAM SP ON LH.MALH = SP.MALH";
            rs = stm.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("MASP");
                String tensp = rs.getString("TENSP");
                String tenlh = rs.getString("TENLOAI");
                String dvt = rs.getString("DVT");
                int gia = rs.getInt("GIA");
                ////////////////////////////////////////////////////////////////
                model.addRow(new Object[]{id, tensp, tenlh, dvt, gia});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addData(int MASP, String TENSP, String TENLOAI, String DVT, int GIA) {
        try {
            String query = "INSERT INTO SANPHAM (MASP, TENSP, TENLOAI, DVT, GIA)\n"
                    + "SELECT SP.MASP, SP.TENSP, LH.TENLOAI, LH.DVT, SP.GIA\n"
                    + "FROM SANPHAM SP\n"
                    + "JOIN LOAIHANG LH ON SP.MALH = LH.MALH;"
                    + "VALUES(?, ?, ?, ?, ?);";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, MASP);
            pst.setString(2, TENSP);
            pst.setString(3, TENLOAI);
            pst.setString(4, DVT);
            pst.setInt(5, GIA);
            pst.executeUpdate();
            System.out.println("Add Successfully :" + MASP);
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }

        public void updateData(int MASP, String TENSP, String TENLOAI, String DVT, int GIA) {
        try {
            String query = "UPDATE SANPHAM SET TENSP=?,TENLOAI=?,DVT=?,GIA=? "
                    + " FROM LOAIHANG LH"
                    + " WHERE MASP='" + MASP + "'";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, TENSP);
            pst.setString(2, TENLOAI);
            pst.setString(3, DVT);
            pst.setInt(4, GIA);
            pst.executeUpdate();
            System.out.println("Update Successfully :" + MASP);
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }
        

    public void deleteData(String MASP) {
        try {
            String query = "DELETE FROM SANPHAM WHERE MASP='" + MASP + "'";
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            System.out.println("Delete  Successfully: " + MASP);
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }
    
    
    public SuppProduct getSuppProduct(int id) {
        String tensp = ""; 
        String tenlh = "";
        String dvt = ""; 
        int gia = 0;
        try {
            Statement stm = con.createStatement();
            String query = "SELECT * FROM SANPHAM WHERE ID LIKE '" + id + "'";
            rs = stm.executeQuery(query);

            while (rs.next()) {
                if (rs.getString("MASP").equals(String.valueOf(id))) {
                    tensp = rs.getString("TENSP");
                    tenlh = rs.getString("TENLOAI");
                    dvt = rs.getString("DVT");
                    gia = rs.getInt("GIA");
                }
            }

            System.out.println("Kết nối thành công");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return new SuppProduct(id, tensp, dvt,gia);
    }  

    
}
