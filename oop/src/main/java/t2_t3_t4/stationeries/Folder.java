package t2_t3_t4.stationeries;

public class Folder extends Stationery {

    private int size;

    public Folder(double price, String manufacture, int size) {
        super(price, manufacture);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
