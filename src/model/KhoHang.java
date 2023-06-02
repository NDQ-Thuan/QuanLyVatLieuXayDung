package model;

public class KhoHang {

    private int maKho;
    private String diaChi;
    private String sdtQuanLy;

    // Constructor
    public KhoHang(int maKho, String diaChi, String sdtQuanLy) {
        this.maKho = maKho;
        this.diaChi = diaChi;
        this.sdtQuanLy = sdtQuanLy;
    }

    // Getters and setters
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
