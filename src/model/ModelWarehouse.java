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

public class ModelWarehouse {

    public DefaultTableModel model;

    private Connection con;

    private ResultSet rs;

    public ModelWarehouse(JTable tbl) {
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
                    + "JOIN SANPHAM SP ON LH.MALH = SP.MALH\n"
                    + "JOIN KHOHANGCHITIET KHC ON SP.MASP = KHC.MASP;";
            rs = stm.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("MASP");
                String tensp = rs.getString("TENSP");
                String dvt = rs.getString("DVT");
                int gia = rs.getInt("GIA");
                int sl = rs.getInt("SOLUONG");
                ////////////////////////////////////////////////////////////////
                model.addRow(new Object[]{id, tensp, dvt, gia, sl});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
