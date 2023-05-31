
package model;


public class Product {
    private int id;
    private String tensp;
    private String tenlh;
    private String dvt;
    private int gia;

    public Product() {
    }

    public Product(int id, String tensp, String tenlh, String dvt, int gia) {
        this.id = id;
        this.tensp = tensp;
        this.tenlh = tenlh;
        this.dvt = dvt;
        this.gia = gia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getTenlh() {
        return tenlh;
    }

    public void setTenlh(String tenlh) {
        this.tenlh = tenlh;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
  
    
    
}
