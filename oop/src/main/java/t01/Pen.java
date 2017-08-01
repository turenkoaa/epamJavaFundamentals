package main.java.t01;

public class Pen {

    private int price;
    private String manufacturer;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Pen(int price, String manufacturer) {
        this.price = price;
        this.manufacturer = manufacturer;
    }


    @Override
    public String toString() {
        return getClass().getName() + '@' + "price: " + price
                + ", manufacturer: " + manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        if (price != pen.price) return false;
        return manufacturer.equals(pen.manufacturer);
    }

    @Override
    public int hashCode() {
        return 31 * price + ((null == manufacturer) ? 0 : manufacturer.hashCode());
    }
}
