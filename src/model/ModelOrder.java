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

public final class ModelOrder {

    public DefaultTableModel model;

    private Connection con;

    private ResultSet rs;

    public ModelOrder() {

        String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyVatLieuXayDung";
        try {
            con = DriverManager.getConnection(url, "sa", "123");
        } catch (SQLException ex) {
            Logger.getLogger(ModelOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDataToTable(JTable tbl) {
        this.model = (DefaultTableModel) tbl.getModel();

        try {
            model.setRowCount(0);
            Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = """
                           SELECT HOADON.MAHD, KHOHANG.DIACHI, KHACHHANG.TENKHACH,  HOADON.NGAYLAPHOADON, HOADON.LOAIHOADON, HOADON.TRANGTHAI
                           FROM HOADON
                           JOIN KHACHHANG ON HOADON.MAKHACH = KHACHHANG.MAKHACH
                           JOIN KHOHANG ON HOADON.MAKHO = KHOHANG.MAKHO""";
            rs = stm.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("MAHD");
                String kho = rs.getString("DIACHI");
                String name = rs.getString("TENKHACH");
                String date = rs.getString("NGAYLAPHOADON");
                String loai = rs.getString("LOAIHOADON");
                String trangthai = rs.getString("TRANGTHAI");
                ////////////////////////////////////////////////////////////////

                model.addRow(new Object[]{id, name, kho, date, loai, trangthai});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addData(int MAHD, int MAKHACH, int MAKHO, String NGAYLAPHOADON, String LOAIHOADON, String TRANGTHAI) {
        try {
            String query = "INSERT INTO HOADON(MAHD, MAKHACH, MAKHO, NGAYLAPHOADON, LOAIHOADON, TRANGTHAI)VALUES(?, ?, ?, ?, ?, ?);";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, MAHD);
            pst.setInt(2, MAKHACH);
            pst.setInt(3, MAKHO);
            pst.setString(4, NGAYLAPHOADON);
            pst.setString(5, LOAIHOADON);
            pst.setString(6, TRANGTHAI);
            pst.executeUpdate();
            System.out.println("Add Successfully :" + MAHD);
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }

    public void updateData(int MAHD, int MAKHACH, int MAKHO, String NGAYLAPHOADON, String LOAIHOADON, String TRANGTHAI) {
        try {
            String query = "UPDATE HOADON SET MAKHACH=?, MAKHO=?, NGAYLAPHOADON=?, LOAIHOADON=?, TRANGTHAI=? WHERE MAHD='" + MAHD + "'";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, MAKHACH);
            pst.setInt(2, MAKHO);
            pst.setString(3, NGAYLAPHOADON);
            pst.setString(4, LOAIHOADON);
            pst.setString(5, TRANGTHAI);
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

    public Order getOrder(int id) {
        int name = 0;
        int kho = 0;
        String date = "";
        String loai = "";
        String trangthai = "";

        try {
            Statement stm = con.createStatement();
            String query = "SELECT * FROM HOADON WHERE ID LIKE '" + id + "'";
            rs = stm.executeQuery(query);

            while (rs.next()) {
                if (rs.getString("MAKH").equals(String.valueOf(id))) {
                    name = rs.getInt("MAKHACH");
                    kho = rs.getInt("MAKHO");
                    date = rs.getString("NGAYLAPHOADON");
                    loai = rs.getString("LOAIHOADON");
                    trangthai = rs.getString("TRANGTHAI");
                }
            }

            System.out.println("Kết nối thành công");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return new Order(id, name, kho, date, loai, trangthai);
    }
}
