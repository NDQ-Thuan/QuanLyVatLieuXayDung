package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Object.KhoHangChiTiet;
import model.Object.SanPham;

public class KhoHangChiTietDAO {

    private Connection connection;

    public KhoHangChiTietDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(KhoHangChiTiet khoHangChiTiet) throws SQLException {
        String query = "INSERT INTO KHOHANGCHITIET (MAKHO, MASP, SOLUONG) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, khoHangChiTiet.getMaKho());
            statement.setInt(2, khoHangChiTiet.getMaSp());
            statement.setInt(3, khoHangChiTiet.getSoLuong());

            statement.executeUpdate();
        }
    }

    public void update(KhoHangChiTiet khoHangChiTiet) throws SQLException {
        String query = "UPDATE KHOHANGCHITIET SET SOLUONG = ? WHERE MAKHO = ? AND MASP = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, khoHangChiTiet.getSoLuong());
            statement.setInt(2, khoHangChiTiet.getMaKho());
            statement.setInt(3, khoHangChiTiet.getMaSp());

            statement.executeUpdate();
        }
    }

    public void delete(int maKho, int maSp) throws SQLException {
        String query = "DELETE FROM KHOHANGCHITIET WHERE MAKHO = ? AND MASP = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maKho);
            statement.setInt(2, maSp);

            statement.executeUpdate();
        }
    }

    public List<KhoHangChiTiet> findByWarehouseID(int maKho) throws SQLException {
        List<KhoHangChiTiet> khoHangChiTietList = new ArrayList<>();

        String query = """
            SELECT * FROM KHOHANGCHITIET khct JOIN SANPHAM sp ON khct.MASP = sp.MASP
            WHERE MAKHO = ? ORDER BY FLAG ASC, khct.MASP""";

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

    public List<KhoHangChiTiet> findByWarehouseIDWithoutFlagged(int maKho) throws SQLException {
        List<KhoHangChiTiet> khoHangChiTietList = new ArrayList<>();

        String query = """
            SELECT * FROM KHOHANGCHITIET khct JOIN SANPHAM sp ON khct.MASP = sp.MASP
            WHERE khct.MAKHO = ? AND sp.FLAG = 0 ORDER BY khct.MASP ASC""";

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

    public List<KhoHangChiTiet> findAllByProductID(int maSp) throws SQLException {
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

    public List<KhoHangChiTiet> findAllByProductList(List<SanPham> spList) throws SQLException {
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

    public KhoHangChiTiet findOneByWarehouseAndProductID(int maKho, int maSp) throws SQLException {
        String query = "SELECT * FROM KHOHANGCHITIET WHERE MAKHO = ? AND MASP = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maKho);
            statement.setInt(2, maSp);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int soLuong = resultSet.getInt("SOLUONG");

                    return new KhoHangChiTiet(maKho, maSp, soLuong);
                }
            }
        }

        return null;
    }
}
