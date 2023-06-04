package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhaCungCapDAO {

    private Connection connection;

    // Constructor
    public NhaCungCapDAO(Connection connection) {
        this.connection = connection;
    }

    // Methods for CRUD operations
    public void insert(NhaCungCap nhaCungCap) throws SQLException {
        String query = "INSERT INTO NHACUNGCAP (TENNCC, DIACHI, SDT) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nhaCungCap.getTenNCC());
            statement.setString(2, nhaCungCap.getDiaChi());
            statement.setString(3, nhaCungCap.getSdt());

            statement.executeUpdate();
        }
    }

    public void update(NhaCungCap nhaCungCap) throws SQLException {
        String query = "UPDATE NHACUNGCAP SET TENNCC = ?, DIACHI = ?, SDT = ? WHERE MANCC = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nhaCungCap.getTenNCC());
            statement.setString(2, nhaCungCap.getDiaChi());
            statement.setString(3, nhaCungCap.getSdt());
            statement.setInt(4, nhaCungCap.getMaNCC());

            statement.executeUpdate();
        }
    }

    public void delete(int maNCC) throws SQLException {
        String query = "DELETE FROM NHACUNGCAP WHERE MANCC = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maNCC);

            statement.executeUpdate();
        }
    }

    public NhaCungCap findById(int maNCC) throws SQLException {
        String query = "SELECT * FROM NHACUNGCAP WHERE MANCC = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maNCC);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String tenNCC = resultSet.getString("TENNCC");
                    String diaChi = resultSet.getString("DIACHI");
                    String sdt = resultSet.getString("SDT");

                    return new NhaCungCap(maNCC, tenNCC, diaChi, sdt);
                }
            }
        }

        return null;
    }

    public List<NhaCungCap> findAll() throws SQLException {
        List<NhaCungCap> nhaCungCapList = new ArrayList<>();

        String query = "SELECT * FROM NHACUNGCAP ORDER BY MANCC ASC";

        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int maNCC = resultSet.getInt("MANCC");
                String tenNCC = resultSet.getString("TENNCC");
                String diaChi = resultSet.getString("DIACHI");
                String sdt = resultSet.getString("SDT");

                nhaCungCapList.add(new NhaCungCap(maNCC, tenNCC, diaChi, sdt));
            }
        }

        return nhaCungCapList;
    }
}
