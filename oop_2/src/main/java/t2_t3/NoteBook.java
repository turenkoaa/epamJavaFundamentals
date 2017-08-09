package t2_t3;

/**
 * Created by Anastasia on 19.07.2017.
 */
public class NoteBook extends PaperAccessory{

    private String manufacture;

    public NoteBook(int price, int pageCount, String manufacture) {
        super(price, pageCount);
        this.manufacture = manufacture;
    }


    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
