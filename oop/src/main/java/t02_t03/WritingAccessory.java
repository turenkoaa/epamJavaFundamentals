package main.java.t02_t03;


public class WritingAccessory extends Chancery {

    public enum Color{
        RED,
        GREEN,
        BLUE,
        BLACK
    }

    public WritingAccessory(int price, Color color) {
        super(price);
        this.color = color;
    }

    private Color color;
}
