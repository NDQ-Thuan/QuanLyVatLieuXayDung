package model.Object;

public class SanPhamDatHang {

    private int maSp;
    private String tenSp;
    private int soLuong;

    public SanPhamDatHang() {
    }

    public SanPhamDatHang(int maSp, String tenSp, int soLuong) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
    }

    public int getMaSp() {
        return maSp;
    }

    public void setMaSp(int maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
