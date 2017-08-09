package t2_t3;

public class WritingAccessory extends Chancery {

    Enum<Color> color;

    public enum Color{
        RED, GREEN, BLUE, BLACK
    }

    public WritingAccessory(int price, Enum<Color> color) {
        super(price);
        this.color = color;
    }

}
