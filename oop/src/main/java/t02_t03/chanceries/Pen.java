package main.java.t02_t03.chanceries;

/**
 * Created by Anastasia on 19.07.2017.
 */
public class Pen extends WritingAccessory {

    private double thickness;

    public Pen(int price, Enum<Color> color, double thickness) {
        super(price, color);
        this.thickness = thickness;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

}
