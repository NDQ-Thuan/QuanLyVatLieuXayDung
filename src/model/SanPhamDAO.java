package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SanPhamDAO {

    private Connection connection;

    // Constructor
    public SanPhamDAO(Connection connection) {
        this.connection = connection;
    }

    // Methods for CRUD operations
    public void insert(SanPham sanPham) throws SQLException {
        String query = "INSERT INTO SANPHAM (MALH, MANCC, TENSP, GIA) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, sanPham.getMaLh());
            statement.setInt(2, sanPham.getMaNcc());
            statement.setString(3, sanPham.getTenSp());
            statement.setInt(4, sanPham.getGia());

            statement.executeUpdate();
        }
    }

    public void update(SanPham sanPham) throws SQLException {
        String query = "UPDATE SANPHAM SET MALH = ?, MANCC = ?, TENSP = ?, GIA = ? WHERE MASP = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, sanPham.getMaLh());
            statement.setInt(2, sanPham.getMaNcc());
            statement.setString(3, sanPham.getTenSp());
            statement.setInt(4, sanPham.getGia());
            statement.setInt(5, sanPham.getMaSp());

            statement.executeUpdate();
        }
    }

    public void flag(int maSp) throws SQLException {
        String query = "UPDATE SANPHAM SET FLAG = 1 WHERE MASP = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maSp);

            statement.executeUpdate();
        }
    }

    public SanPham findById(int maSp) throws SQLException {
        String query = "SELECT * FROM SANPHAM WHERE MASP = ? ORDER BY MASP ASC";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maSp);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int maLh = resultSet.getInt("MALH");
                    int maNcc = resultSet.getInt("MANCC");
                    String tenSp = resultSet.getString("TENSP");
                    int gia = resultSet.getInt("GIA");

                    return new SanPham(maSp, maLh, maNcc, tenSp, gia);
                }
            }
        }

        return null;
    }

    public List<SanPham> findAll() {
        List<SanPham> sanPhamList = new ArrayList<>();

        String query = "SELECT * FROM SANPHAM ORDER BY MASP ASC";

        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int maSp = resultSet.getInt("MASP");
                int maLh = resultSet.getInt("MALH");
                int maNcc = resultSet.getInt("MANCC");
                String tenSp = resultSet.getString("TENSP");
                int gia = resultSet.getInt("GIA");

                sanPhamList.add(new SanPham(maSp, maLh, maNcc, tenSp, gia));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sanPhamList;
    }

    public List<SanPham> findByNCC(int maNCC) throws SQLException {
        List<SanPham> sanPhamList = new ArrayList<>();

        String query = "SELECT * FROM SANPHAM WHERE MANCC = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maNCC);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int maSp = resultSet.getInt("MASP");
                    int maLh = resultSet.getInt("MALH");
                    int maNcc = resultSet.getInt("MANCC");
                    String tenSp = resultSet.getString("TENSP");
                    int gia = resultSet.getInt("GIA");

                    sanPhamList.add(new SanPham(maSp, maLh, maNcc, tenSp, gia));
                }
            }
        }

        return sanPhamList;
    }

}
