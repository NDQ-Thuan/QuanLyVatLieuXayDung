package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiHangDAO {

    private Connection connection;

    // Constructor
    public LoaiHangDAO(Connection connection) {
        this.connection = connection;
    }

    // Methods for CRUD operations
    public void insert(LoaiHang loaiHang) throws SQLException {
        String query = "INSERT INTO LOAIHANG (TENLOAI, DVT) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, loaiHang.getTenLoai());
            statement.setString(2, loaiHang.getDvt());

            statement.executeUpdate();
        }
    }

    public void update(LoaiHang loaiHang) throws SQLException {
        String query = "UPDATE LOAIHANG SET TENLOAI = ?, DVT = ? WHERE MALH = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, loaiHang.getTenLoai());
            statement.setString(2, loaiHang.getDvt());
            statement.setInt(3, loaiHang.getMaLh());

            statement.executeUpdate();
        }
    }

    public void delete(int maLh) throws SQLException {
        String query = "DELETE FROM LOAIHANG WHERE MALH = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maLh);

            statement.executeUpdate();
        }
    }

    public LoaiHang findById(int maLh) throws SQLException {
        String query = "SELECT * FROM LOAIHANG WHERE MALH = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maLh);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String tenLoai = resultSet.getString("TENLOAI");
                    String dvt = resultSet.getString("DVT");

                    return new LoaiHang(maLh, tenLoai, dvt);
                }
            }
        }

        return null;
    }

    public List<LoaiHang> findAll() throws SQLException {
        List<LoaiHang> loaiHangList = new ArrayList<>();

        String query = "SELECT * FROM LOAIHANG";

        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int maLh = resultSet.getInt("MALH");
                String tenLoai = resultSet.getString("TENLOAI");
                String dvt = resultSet.getString("DVT");

                loaiHangList.add(new LoaiHang(maLh, tenLoai, dvt));
            }
        }

        return loaiHangList;
    }
}
