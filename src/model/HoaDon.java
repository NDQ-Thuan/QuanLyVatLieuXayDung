package model;

import java.util.Date;

public class HoaDon {

    private int maHd;
    private int maKhach;
    private int maKho;
    private String ngayLapHoaDon;
    private String loaiHoaDon;
    private String trangThai;

    // Constructor
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
}
