package t2_t3_t4.stationeries;

public class PaperAccessory extends Stationery {

    private int pageCount;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public PaperAccessory(double price, String manufacture, int pageCount) {
        super(price, manufacture);
        this.pageCount = pageCount;
    }
}
