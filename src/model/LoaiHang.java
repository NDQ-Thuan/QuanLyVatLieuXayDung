package model;

public class LoaiHang {

    private int maLh;
    private String tenLoai;
    private String dvt;

    // Constructor
    public LoaiHang() {
    }

    public LoaiHang(int maLh, String tenLoai, String dvt) {
        this.maLh = maLh;
        this.tenLoai = tenLoai;
        this.dvt = dvt;
    }

    // Getters and setters
    public int getMaLh() {
        return maLh;
    }

    public void setMaLh(int maLh) {
        this.maLh = maLh;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }
}
