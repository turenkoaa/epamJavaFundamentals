package t2_t3_t4.stationeries;

/**
 * Created by Anastasia on 19.07.2017.
 */
public class Pen extends WritingAccessory {

    private double thickness;

    public Pen(double price, String manufacture, Enum<Color> color,  double thickness) {
        super(price, manufacture, color);
        this.thickness = thickness;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

}
