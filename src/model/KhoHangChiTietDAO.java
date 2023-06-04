package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhoHangChiTietDAO {

    private Connection connection;

    public KhoHangChiTietDAO(Connection connection) {
        this.connection = connection;
    }

    public void addKhoHangChiTiet(KhoHangChiTiet khoHangChiTiet) throws SQLException {
        String query = "INSERT INTO KHOHANGCHITIET (MAKHO, MASP, SOLUONG) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, khoHangChiTiet.getMaKho());
            statement.setInt(2, khoHangChiTiet.getMaSp());
            statement.setInt(3, khoHangChiTiet.getSoLuong());

            statement.executeUpdate();
        }
    }

    public void updateKhoHangChiTiet(KhoHangChiTiet khoHangChiTiet) throws SQLException {
        String query = "UPDATE KHOHANGCHITIET SET SOLUONG = ? WHERE MAKHO = ? AND MASP = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, khoHangChiTiet.getSoLuong());
            statement.setInt(2, khoHangChiTiet.getMaKho());
            statement.setInt(3, khoHangChiTiet.getMaSp());

            statement.executeUpdate();
        }
    }

    public void deleteKhoHangChiTiet(int maKho, int maSp) throws SQLException {
        String query = "DELETE FROM KHOHANGCHITIET WHERE MAKHO = ? AND MASP = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maKho);
            statement.setInt(2, maSp);

            statement.executeUpdate();
        }
    }

    public List<KhoHangChiTiet> findByMaKho(int maKho) throws SQLException {
        List<KhoHangChiTiet> khoHangChiTietList = new ArrayList<>();

        String query = "SELECT * FROM KHOHANGCHITIET WHERE MAKHO = ? ORDER BY MASP ASC";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maKho);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int maSp = resultSet.getInt("MASP");
                    int soLuong = resultSet.getInt("SOLUONG");

                    khoHangChiTietList.add(new KhoHangChiTiet(maKho, maSp, soLuong));
                }
            }
        }

        return khoHangChiTietList;
    }

    public List<KhoHangChiTiet> findAllByMaSP(int maSp) throws SQLException {
        List<KhoHangChiTiet> khoHangChiTietList = new ArrayList<>();

        String query = "SELECT * FROM KHOHANGCHITIET WHERE MASP = ? ORDER BY MAKHO ASC";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maSp);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int maKho = resultSet.getInt("MAKHO");
                    int soLuong = resultSet.getInt("SOLUONG");

                    khoHangChiTietList.add(new KhoHangChiTiet(maKho, maSp, soLuong));
                }
            }
        }

        return khoHangChiTietList;
    }

    public List<KhoHangChiTiet> findAllBySanPhamList(List<SanPham> spList) throws SQLException {
        List<KhoHangChiTiet> khoHangChiTietList = new ArrayList<>();

        String query = "SELECT * FROM KHOHANGCHITIET WHERE MASP = ? ORDER BY MASP ASC";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            for (SanPham sp : spList) {
                statement.setInt(1, sp.getMaSp());
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int maSp = resultSet.getInt("MASP");
                        int maKho = resultSet.getInt("MAKHO");
                        int soLuong = resultSet.getInt("SOLUONG");

                        khoHangChiTietList.add(new KhoHangChiTiet(maKho, maSp, soLuong));
                    }
                }
            }
        }

        return khoHangChiTietList;
    }

}
