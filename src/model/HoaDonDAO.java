package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HoaDonDAO {

    private Connection connection;

    public HoaDonDAO(Connection connection) {
        this.connection = connection;
    }

    public void addHoaDon(HoaDon hoaDon) throws SQLException {
        String query = "INSERT INTO HOADON (MAKHACH, MAKHO, NGAYLAPHOADON, LOAIHOADON, TRANGTHAI) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, hoaDon.getMaKhach());
            statement.setInt(2, hoaDon.getMaKho());
            statement.setString(3, hoaDon.getNgayLapHoaDon());
            statement.setString(4, hoaDon.getLoaiHoaDon());
            statement.setString(5, hoaDon.getTrangThai());

            statement.executeUpdate();
        }
    }

    public void updateHoaDon(HoaDon hoaDon) throws SQLException {
        String query = "UPDATE HOADON SET MAKHACH = ?, MAKHO = ?, NGAYLAPHOADON = ?, LOAIHOADON = ?, TRANGTHAI = ? WHERE MAHD = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, hoaDon.getMaKhach());
            statement.setInt(2, hoaDon.getMaKho());
            statement.setString(3, hoaDon.getNgayLapHoaDon());
            statement.setString(4, hoaDon.getLoaiHoaDon());
            statement.setString(5, hoaDon.getTrangThai());
            statement.setInt(6, hoaDon.getMaHd());

            statement.executeUpdate();
        }
    }

    public void deleteHoaDon(int maHd) throws SQLException {
        String query = "DELETE FROM HOADON WHERE MAHD = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maHd);
            statement.executeUpdate();
        }
    }

    public List<HoaDon> findAll() {
        List<HoaDon> hoaDonList = new ArrayList<>();

        String query = "SELECT * FROM HOADON";

        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int maHd = resultSet.getInt("MAHD");
                int maKhach = resultSet.getInt("MAKHACH");
                int maKho = resultSet.getInt("MAKHO");
                String ngayLapHoaDon = resultSet.getString("NGAYLAPHOADON");
                String loaiHoaDon = resultSet.getString("LOAIHOADON");
                String trangThai = resultSet.getString("TRANGTHAI");

                hoaDonList.add(new HoaDon(maHd, maKhach, maKho, ngayLapHoaDon, loaiHoaDon, trangThai));
            }
        } catch (SQLException ex) {
        }

        return hoaDonList;
    }

    public HoaDon findById(int maHd) throws SQLException {
        String query = "SELECT * FROM HOADON WHERE MAHD = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maHd);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int maKhach = resultSet.getInt("MAKHACH");
                    int maKho = resultSet.getInt("MAKHO");
                    String ngayLapHoaDon = resultSet.getString("NGAYLAPHOADON");
                    String loaiHoaDon = resultSet.getString("LOAIHOADON");
                    String trangThai = resultSet.getString("TRANGTHAI");

                    return new HoaDon(maHd, maKhach, maKho, ngayLapHoaDon, loaiHoaDon, trangThai);
                }
            }
        }
        return null;
    }

    public List<HoaDon> findExportPendingOrder() {
        List<HoaDon> hoaDonList = new ArrayList<>();

        String query = "SELECT * FROM HOADON WHERE TRANGTHAI LIKE 'Pending' AND LOAIHOADON LIKE N'Xuất'";

        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int maHd = resultSet.getInt("MAHD");
                int maKhach = resultSet.getInt("MAKHACH");
                int maKho = resultSet.getInt("MAKHO");
                String ngayLapHoaDon = resultSet.getString("NGAYLAPHOADON");
                String loaiHoaDon = resultSet.getString("LOAIHOADON");
                String trangThai = resultSet.getString("TRANGTHAI");

                hoaDonList.add(new HoaDon(maHd, maKhach, maKho, ngayLapHoaDon, loaiHoaDon, trangThai));
            }
        } catch (SQLException ex) {
        }

        return hoaDonList;
    }
}
