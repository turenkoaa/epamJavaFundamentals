package t2_t3_t4.stationeries;

public class WritingAccessory extends Stationery {

    Enum<Color> color;

    public enum Color{
        RED, GREEN, BLUE, BLACK
    }

    public WritingAccessory(double price, String manufacture, Enum<Color> color) {
        super(price, manufacture);
        this.color = color;
    }

}
