package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhoHangDAO {

    private Connection connection;

    // Constructor
    public KhoHangDAO(Connection connection) {
        this.connection = connection;
    }

    // Methods for CRUD operations
    public void insert(KhoHang khoHang) throws SQLException {
        String query = "INSERT INTO KHOHANG (DIACHI, SDTQUANLY) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, khoHang.getDiaChi());
            statement.setString(2, khoHang.getSdtQuanLy());

            statement.executeUpdate();
        }
    }

    public void update(KhoHang khoHang) throws SQLException {
        String query = "UPDATE KHOHANG SET DIACHI = ?, SDTQUANLY = ? WHERE MAKHO = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, khoHang.getDiaChi());
            statement.setString(2, khoHang.getSdtQuanLy());
            statement.setInt(3, khoHang.getMaKho());

            statement.executeUpdate();
        }
    }

    public void delete(int maKho) throws SQLException {
        String query = "DELETE FROM KHOHANG WHERE MAKHO = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maKho);

            statement.executeUpdate();
        }
    }

    public KhoHang findById(int maKho) throws SQLException {
        String query = "SELECT * FROM KHOHANG WHERE MAKHO = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maKho);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String diaChi = resultSet.getString("DIACHI");
                    String sdtQuanLy = resultSet.getString("SDTQUANLY");

                    return new KhoHang(maKho, diaChi, sdtQuanLy);
                }
            }
        }

        return null;
    }

    public List<KhoHang> findAll() throws SQLException {
        List<KhoHang> khoHangList = new ArrayList<>();

        String query = "SELECT * FROM KHOHANG";

        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int maKho = resultSet.getInt("MAKHO");
                String diaChi = resultSet.getString("DIACHI");
                String sdtQuanLy = resultSet.getString("SDTQUANLY");

                khoHangList.add(new KhoHang(maKho, diaChi, sdtQuanLy));
            }
        }

        return khoHangList;
    }
}
