package model.Object;

import java.util.Objects;

public class SanPham {

    private int maSp;
    private int maLh;
    private int maNcc;
    private String tenSp;
    private int gia;
    private boolean flag = false;

    // Constructor
    public SanPham() {
    }

    public SanPham(int maLh, int maNcc, String tenSp, int gia) {
        this.maLh = maLh;
        this.maNcc = maNcc;
        this.tenSp = tenSp;
        this.gia = gia;
    }

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

    public boolean isFlagged() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
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
        final SanPham other = (SanPham) obj;
        if (this.maSp != other.maSp) {
            return false;
        }
        if (this.maLh != other.maLh) {
            return false;
        }
        if (this.maNcc != other.maNcc) {
            return false;
        }
        if (this.gia != other.gia) {
            return false;
        }
        if (this.flag != other.flag) {
            return false;
        }
        return Objects.equals(this.tenSp, other.tenSp);
    }

}
