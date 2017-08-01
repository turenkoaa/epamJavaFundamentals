package main.java.t02_t03;

public class Folder extends Chancery {

    private int size;

    public Folder(int price, int size) {
        super(price);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
