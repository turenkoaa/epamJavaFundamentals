package main.java.t02_t03.chanceries;


import main.java.t02_t03.chanceries.Chancery;

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
