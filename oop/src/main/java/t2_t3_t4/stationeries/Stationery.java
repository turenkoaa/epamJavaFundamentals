package t2_t3_t4.stationeries;

public class Stationery {

    private double price;
    private String manufacture;

    public Stationery(double price, String manufacture) {

        this.price = price;
        this.manufacture = manufacture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public int compareTo(Stationery o){
        return this.getManufacture().compareTo(o.getManufacture());
    }
}
