package main.java.t02_t03;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;
    private List<Chancery> chanceries;

    public Employee(String name) {
        this.name = name;
        this.chanceries = new ArrayList<Chancery>();
    }

    public Employee(List<Chancery> chanceries, String name) {
        this.chanceries = chanceries;
        this.name = name;
    }

    public void addChancery(Chancery chancery) {
        chanceries.add(chancery);
    }

    public void deleteChancery(Chancery chancery){
        if (chanceries.contains(chancery)) chanceries.remove(chancery);
    }

    public int getPriceOfChanceries() {
        int sum = 0;
        for (Chancery chancery: chanceries) {
            sum += chancery.getPrice();
        }

        return sum;
    }
}
