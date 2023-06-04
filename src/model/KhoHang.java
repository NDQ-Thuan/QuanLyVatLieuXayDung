package model;

public class KhoHang {

    private int maKho;
    private String tenKho;
    private String diaChi;
    private String sdtQuanLy;

    public KhoHang() {
    }

    public KhoHang(int maKho, String tenKho, String diaChi, String sdtQuanLy) {
        this.maKho = maKho;
        this.tenKho = tenKho;
        this.diaChi = diaChi;
        this.sdtQuanLy = sdtQuanLy;
    }

    // Getters and setters
    public String getTenKho() {
        return tenKho;
    }

    public void setTenKho(String tenKho) {
        this.tenKho = tenKho;
    }

    public int getMaKho() {
        return maKho;
    }

    public void setMaKho(int maKho) {
        this.maKho = maKho;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdtQuanLy() {
        return sdtQuanLy;
    }

    public void setSdtQuanLy(String sdtQuanLy) {
        this.sdtQuanLy = sdtQuanLy;
    }
}
