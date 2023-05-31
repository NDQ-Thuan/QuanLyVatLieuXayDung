
package model;


public class Detail {
    private int id;
    private int idsp;
    private int sl;

    public Detail() {
    }

    public Detail(int id, int idsp, int sl) {
        this.id = id;
        this.idsp = idsp;
        this.sl = sl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdsp() {
        return idsp;
    }

    public void setIdsp(int idsp) {
        this.idsp = idsp;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }
    
    
}
