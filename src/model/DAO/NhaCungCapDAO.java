package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Object.NhaCungCap;

public class NhaCungCapDAO {

    private Connection connection;

    public NhaCungCapDAO(Connection connection) {
        this.connection = connection;
    }

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

    public void flag(int maNCC) throws SQLException {
        String query = "UPDATE NHACUNGCAP SET FLAG = 1 WHERE MANCC = ?; UPDATE SANPHAM SET MANCC = NULL WHERE MANCC = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maNCC);
            statement.setInt(2, maNCC);

            statement.executeUpdate();
        }
    }

    public void unflag(int maNCC) throws SQLException {
        String query = "UPDATE NHACUNGCAP SET FLAG = 0 WHERE MANCC = ?;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maNCC);

            statement.executeUpdate();
        }
    }

    public NhaCungCap findById(int maNCC) throws SQLException {
        NhaCungCap ncc;
        String query = "SELECT * FROM NHACUNGCAP WHERE MANCC = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maNCC);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String tenNCC = resultSet.getString("TENNCC");
                    String diaChi = resultSet.getString("DIACHI");
                    String sdt = resultSet.getString("SDT");
                    boolean flag = resultSet.getBoolean("FLAG");

                    ncc = new NhaCungCap(maNCC, tenNCC, diaChi, sdt);
                    ncc.setFlag(flag);

                    return ncc;
                }
            }
        }

        return new NhaCungCap(maNCC, "CHỜ BỔ SUNG", "", "");
    }

    public List<NhaCungCap> findAll() throws SQLException {
        List<NhaCungCap> nhaCungCapList = new ArrayList<>();

        String query = "SELECT * FROM NHACUNGCAP ORDER BY FLAG ASC, MANCC";

        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int maNCC = resultSet.getInt("MANCC");
                String tenNCC = resultSet.getString("TENNCC");
                String diaChi = resultSet.getString("DIACHI");
                String sdt = resultSet.getString("SDT");

                boolean flag = resultSet.getBoolean("FLAG");

                NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, diaChi, sdt);
                ncc.setFlag(flag);

                nhaCungCapList.add(ncc);
            }
        }

        return nhaCungCapList;
    }

    public List<NhaCungCap> findAllByCustomQuery(String query) throws SQLException {
        List<NhaCungCap> nhaCungCapList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int maNCC = resultSet.getInt("MANCC");
                    String tenNCC = resultSet.getString("TENNCC");
                    String diaChi = resultSet.getString("DIACHI");
                    String sdt = resultSet.getString("SDT");

                    boolean flag = resultSet.getBoolean("FLAG");

                    NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, diaChi, sdt);
                    ncc.setFlag(flag);

                    nhaCungCapList.add(ncc);
                }
            }
        }

        return nhaCungCapList;
    }

    public int findIDByName(String tenNCC) throws SQLException {
        String query = "SELECT MANCC FROM NHACUNGCAP WHERE TENNCC LIKE N'" + tenNCC + "'";

        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("MANCC");
        }
        return 0;
    }
}
