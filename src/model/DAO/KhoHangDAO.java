package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Object.KhoHang;

public class KhoHangDAO {

    private Connection connection;

    public KhoHangDAO(Connection connection) {
        this.connection = connection;
    }

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
                    String tenKho = resultSet.getString("TENKHOHANG");
                    String diaChi = resultSet.getString("DIACHI");
                    String sdtQuanLy = resultSet.getString("SDTQUANLY");

                    return new KhoHang(maKho, tenKho, diaChi, sdtQuanLy);
                }
            }
        }

        return null;
    }

    public List<KhoHang> findAll() throws SQLException {
        List<KhoHang> khoHangList = new ArrayList<>();

        String query = "SELECT * FROM KHOHANG ORDER BY MAKHO ASC";

        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int maKho = resultSet.getInt("MAKHO");
                String tenKho = resultSet.getString("TENKHOHANG");
                String diaChi = resultSet.getString("DIACHI");
                String sdtQuanLy = resultSet.getString("SDTQUANLY");

                khoHangList.add(new KhoHang(maKho, tenKho, diaChi, sdtQuanLy));
            }
        }

        return khoHangList;
    }

    public int findIdByName(String tenKho) throws SQLException {
        String query = "SELECT * FROM KHOHANG WHERE TENKHOHANG LIKE N'" + tenKho + "'";

        int maKho = 0;

        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                maKho = resultSet.getInt("MAKHO");
            }
        }

        return maKho;
    }
}
