package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoaDonChiTietDAO {

    private Connection connection;

    public HoaDonChiTietDAO(Connection connection) {
        this.connection = connection;
    }

    public void addHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet) throws SQLException {
        String query = "INSERT INTO HOADONCHITIET (MASP, MAHD, SOLUONG) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, hoaDonChiTiet.getMaSp());
            statement.setInt(2, hoaDonChiTiet.getMaHd());
            statement.setInt(3, hoaDonChiTiet.getSoLuong());

            statement.executeUpdate();
        }
    }

    public void updateHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet) throws SQLException {
        String query = "UPDATE HOADONCHITIET SET SOLUONG = ? WHERE MASP = ? AND MAHD = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, hoaDonChiTiet.getSoLuong());
            statement.setInt(2, hoaDonChiTiet.getMaSp());
            statement.setInt(3, hoaDonChiTiet.getMaHd());

            statement.executeUpdate();
        }
    }

    public void deleteHoaDonChiTiet(int maSp, int maHd) throws SQLException {
        String query = "DELETE FROM HOADONCHITIET WHERE MASP = ? AND MAHD = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maSp);
            statement.setInt(2, maHd);

            statement.executeUpdate();
        }
    }

    public List<HoaDonChiTiet> findByMaHd(int maHd) throws SQLException {
        List<HoaDonChiTiet> hoaDonChiTietList = new ArrayList<>();

        String query = "SELECT * FROM HOADONCHITIET WHERE MAHD = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maHd);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int maSp = resultSet.getInt("MASP");
                    int soLuong = resultSet.getInt("SOLUONG");

                    hoaDonChiTietList.add(new HoaDonChiTiet(maSp, maHd, soLuong));
                }
            }
        }

        return hoaDonChiTietList;
    }
}
