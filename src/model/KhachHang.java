package model;

public class KhachHang {

    private int maKhach;
    private String tenKhach;
    private String diaChi;
    private String sdt;

    // Constructor
    public KhachHang(int maKhach, String tenKhach, String diaChi, String sdt) {
        this.maKhach = maKhach;
        this.tenKhach = tenKhach;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    // Getters and setters
    public int getMaKhach() {
        return maKhach;
    }

    public void setMaKhach(int maKhach) {
        this.maKhach = maKhach;
    }

    public String getTenKhach() {
        return tenKhach;
    }

    public void setTenKhach(String tenKhach) {
        this.tenKhach = tenKhach;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
