package model;

public class HoaDonChiTiet {

    private int maSp;
    private int maHd;
    private int soLuong;

    // Constructor
    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int maSp, int maHd, int soLuong) {
        this.maSp = maSp;
        this.maHd = maHd;
        this.soLuong = soLuong;
    }

    // Getters and setters
    public int getMaSp() {
        return maSp;
    }

    public void setMaSp(int maSp) {
        this.maSp = maSp;
    }

    public int getMaHd() {
        return maHd;
    }

    public void setMaHd(int maHd) {
        this.maHd = maHd;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
