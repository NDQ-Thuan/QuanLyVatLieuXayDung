package model.Object;

public class HoaDon {

    private int maHd;
    private int maKhach;
    private int maKho;
    private String ngayLapHoaDon;
    private String loaiHoaDon;
    private String trangThai;

    // Constructor
    public HoaDon() {
    }

    public HoaDon(int maHd, int maKhach, int maKho, String ngayLapHoaDon, String loaiHoaDon, String trangThai) {
        this.maHd = maHd;
        this.maKhach = maKhach;
        this.maKho = maKho;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.loaiHoaDon = loaiHoaDon;
        this.trangThai = trangThai;
    }

    // Getters and setters
    public int getMaHd() {
        return maHd;
    }

    public void setMaHd(int maHd) {
        this.maHd = maHd;
    }

    public int getMaKhach() {
        return maKhach;
    }

    public void setMaKhach(int maKhach) {
        this.maKhach = maKhach;
    }

    public int getMaKho() {
        return maKho;
    }

    public void setMaKho(int maKho) {
        this.maKho = maKho;
    }

    public String getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(String ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public String getLoaiHoaDon() {
        return loaiHoaDon;
    }

    public void setLoaiHoaDon(String loaiHoaDon) {
        this.loaiHoaDon = loaiHoaDon;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HoaDon other = (HoaDon) obj;
        if (this.maKhach != other.maKhach) {
            return false;
        }
        return this.maKho == other.maKho;
    }

}
