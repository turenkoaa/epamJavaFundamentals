package main.java.t02_t03.chanceries;

import main.java.t02_t03.chanceries.Chancery;

public class PaperAccessory extends Chancery {

    private int pageCount;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public PaperAccessory(int price, int pageCount) {
        super(price);
        this.pageCount = pageCount;
    }
}
