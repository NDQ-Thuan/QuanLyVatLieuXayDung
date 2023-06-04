package model;

public class KhoHangChiTiet {

    private int maKho;
    private int maSp;
    private int soLuong;

    // Constructor
    public KhoHangChiTiet() {
    }

    public KhoHangChiTiet(int maKho, int maSp, int soLuong) {
        this.maKho = maKho;
        this.maSp = maSp;
        this.soLuong = soLuong;
    }

    // Getters and setters
    public int getMaKho() {
        return maKho;
    }

    public void setMaKho(int maKho) {
        this.maKho = maKho;
    }

    public int getMaSp() {
        return maSp;
    }

    public void setMaSp(int maSp) {
        this.maSp = maSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
