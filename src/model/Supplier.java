
package model;

public class Supplier {
    private int id;
    private String tenncc;
    private String diachi;
    private String sdt;

    public Supplier() {
    }

    public Supplier(int id, String tenncc, String diachi, String sdt) {
        this.id = id;
        this.tenncc = tenncc;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenncc() {
        return tenncc;
    }

    public void setTenncc(String tenncc) {
        this.tenncc = tenncc;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    
}
