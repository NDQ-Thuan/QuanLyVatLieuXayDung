package model;

public class SanPham {

    private int maSp;
    private int maLh;
    private int maNcc;
    private String tenSp;
    private int gia;

    // Constructor
    public SanPham(int maSp, int maLh, int maNcc, String tenSp, int gia) {
        this.maSp = maSp;
        this.maLh = maLh;
        this.maNcc = maNcc;
        this.tenSp = tenSp;
        this.gia = gia;
    }

    // Getters and setters
    public int getMaSp() {
        return maSp;
    }

    public void setMaSp(int maSp) {
        this.maSp = maSp;
    }

    public int getMaLh() {
        return maLh;
    }

    public void setMaLh(int maLh) {
        this.maLh = maLh;
    }

    public int getMaNcc() {
        return maNcc;
    }

    public void setMaNcc(int maNcc) {
        this.maNcc = maNcc;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
