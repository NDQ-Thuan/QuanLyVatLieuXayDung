package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        String query = "SELECT * FROM HOADON ORDER BY NGAYLAPHOADON DESC";

        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int maHd = resultSet.getInt("MAHD");
                int maKhach = resultSet.getInt("MAKHACH");
                int maKho = resultSet.getInt("MAKHO");
                String ngayLapHoaDon = formatDate(resultSet.getString("NGAYLAPHOADON"));
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
                    String ngayLapHoaDon = formatDate(resultSet.getString("NGAYLAPHOADON"));
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

        String query = """
                SELECT * FROM HOADON
                WHERE TRANGTHAI LIKE 'Pending'
                AND LOAIHOADON LIKE N'Xuất'
                ORDER BY NGAYLAPHOADON DESC""";

        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int maHd = resultSet.getInt("MAHD");
                int maKhach = resultSet.getInt("MAKHACH");
                int maKho = resultSet.getInt("MAKHO");
                String ngayLapHoaDon = formatDate(resultSet.getString("NGAYLAPHOADON"));
                String loaiHoaDon = resultSet.getString("LOAIHOADON");
                String trangThai = resultSet.getString("TRANGTHAI");

                hoaDonList.add(new HoaDon(maHd, maKhach, maKho, ngayLapHoaDon, loaiHoaDon, trangThai));
            }
        } catch (SQLException ex) {
        }

        return hoaDonList;
    }

    public List<HoaDon> findCancelledOrder() {
        List<HoaDon> hoaDonList = new ArrayList<>();

        String query = "SELECT * FROM HOADON WHERE TRANGTHAI LIKE 'Cancelled' AND LOAIHOADON LIKE N'Xuất'";

        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int maHd = resultSet.getInt("MAHD");
                int maKhach = resultSet.getInt("MAKHACH");
                int maKho = resultSet.getInt("MAKHO");
                String ngayLapHoaDon = formatDate(resultSet.getString("NGAYLAPHOADON"));
                String loaiHoaDon = resultSet.getString("LOAIHOADON");
                String trangThai = resultSet.getString("TRANGTHAI");

                hoaDonList.add(new HoaDon(maHd, maKhach, maKho, ngayLapHoaDon, loaiHoaDon, trangThai));
            }
        } catch (SQLException ex) {
        }

        return hoaDonList;
    }

    public int totalRevenueByMonth(int month) throws SQLException {
        String query = """
                       SELECT SUM(sanpham.GIA * hoadonchitiet.SOLUONG) AS TotalAmount
                       FROM HOADON
                       JOIN HOADONCHITIET ON hoadon.MAHD = hoadonchitiet.MAHD
                       JOIN SANPHAM ON hoadonchitiet.MASP = sanpham.MASP
                       WHERE MONTH(hoadon.NGAYLAPHOADON) = ?
                       AND YEAR(hoadon.NGAYLAPHOADON) = YEAR(GETDATE())
                       AND hoadon.LOAIHOADON LIKE N'Xuất' AND hoadon.TRANGTHAI LIKE 'Delivered'""";

        int total = 0;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, month);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    total = resultSet.getInt("TotalAmount");
                }
            }
        }
        return total;
    }

    public String formatDate(String dateFromSQL) {
        String dateStringFromSQL = dateFromSQL;

        // Create a SimpleDateFormat instance to parse the SQL date string
        DateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String europeanDateString = "";
        try {
            // Parse the SQL date string into a Date object
            Date date = sqlDateFormat.parse(dateStringFromSQL);

            // Create a SimpleDateFormat instance with the desired European date format
            DateFormat europeanDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            // Format the date into the European date string
            europeanDateString = europeanDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return europeanDateString;
    }
}
