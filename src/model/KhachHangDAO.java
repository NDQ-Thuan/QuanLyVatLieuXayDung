package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO {

    private Connection connection;

    // Constructor
    public KhachHangDAO(Connection connection) {
        this.connection = connection;
    }

    // Methods for CRUD operations
    public void insert(KhachHang khachHang) throws SQLException {
        String query = "INSERT INTO KHACHHANG (TENKHACH, DIACHI, SDT) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, khachHang.getTenKhach());
            statement.setString(2, khachHang.getDiaChi());
            statement.setString(3, khachHang.getSdt());

            statement.executeUpdate();
        }
    }

    public void update(KhachHang khachHang) throws SQLException {
        String query = "UPDATE KHACHHANG SET TENKHACH = ?, DIACHI = ?, SDT = ? WHERE MAKHACH = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, khachHang.getTenKhach());
            statement.setString(2, khachHang.getDiaChi());
            statement.setString(3, khachHang.getSdt());
            statement.setInt(4, khachHang.getMaKhach());

            statement.executeUpdate();
        }
    }

    public void delete(int maKhach) throws SQLException {
        String query = "DELETE FROM KHACHHANG WHERE MAKHACH = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maKhach);

            statement.executeUpdate();
        }
    }

    public KhachHang findById(int maKhach) throws SQLException {
        String query = "SELECT * FROM KHACHHANG WHERE MAKHACH = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maKhach);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String tenKhach = resultSet.getString("TENKHACH");
                    String diaChi = resultSet.getString("DIACHI");
                    String sdt = resultSet.getString("SDT");

                    return new KhachHang(maKhach, tenKhach, diaChi, sdt);
                }
            }
        }

        return null;
    }

    public List<KhachHang> findAll() throws SQLException {
        List<KhachHang> khachHangList = new ArrayList<>();

        String query = "SELECT * FROM KHACHHANG";

        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int maKhach = resultSet.getInt("MAKHACH");
                String tenKhach = resultSet.getString("TENKHACH");
                String diaChi = resultSet.getString("DIACHI");
                String sdt = resultSet.getString("SDT");

                khachHangList.add(new KhachHang(maKhach, tenKhach, diaChi, sdt));
            }
        }

        return khachHangList;
    }

    public String getTenKhachByID(int maKhach) throws SQLException {
        String query = "SELECT TENKHACH FROM KHACHHANG WHERE MAKHACH = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maKhach);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("TENKHACH");
                }
            }
        }

        return null;
    }
}
