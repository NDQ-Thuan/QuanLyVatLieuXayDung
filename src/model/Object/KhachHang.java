package model.Object;

import java.util.Objects;

public class KhachHang {

    private int maKhach;
    private String tenKhach;
    private String diaChi;
    private String sdt;

    // Constructor
    public KhachHang() {
    }

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

    @Override
    public int hashCode() {
        int hash = 7;
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
        final KhachHang other = (KhachHang) obj;
        if (this.maKhach != other.maKhach) {
            return false;
        }
        if (!Objects.equals(this.tenKhach, other.tenKhach)) {
            return false;
        }
        if (!Objects.equals(this.diaChi, other.diaChi)) {
            return false;
        }
        return Objects.equals(this.sdt, other.sdt);
    }

}
