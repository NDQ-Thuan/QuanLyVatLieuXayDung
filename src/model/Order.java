
package model;


public class Order {
    
    private int id;
    private int name;
    private int kho;
    private String date;
    private String loai;
    private String trangthai;

    public Order() {
    }

    public Order(int id, int name, int kho, String date, String loai, String trangthai) {
        this.id = id;
        this.name = name;
        this.kho = kho;
        this.date = date;
        this.loai = loai;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getKho() {
        return kho;
    }

    public void setKho(int kho) {
        this.kho = kho;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
    
}
