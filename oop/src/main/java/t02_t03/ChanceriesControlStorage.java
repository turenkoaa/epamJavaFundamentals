package main.java.t02_t03;

import main.java.t02_t03.chanceries.Chancery;

import java.util.*;

public class ChanceriesControlStorage {

    private Map<Employee, List<Chancery>> empChancery = new HashMap<>();

    List<Chancery> getChanceries(Employee employee) {
        return empChancery.getOrDefault(employee, Collections.emptyList());
    }

    void addChanceryToEmployee(Employee employee, Chancery chancery) {
        List<Chancery> chanceries = empChancery.getOrDefault(employee, new ArrayList<>());
        chanceries.add(chancery);
        empChancery.put(employee, chanceries);
    }

    double getSumPrice(Employee e) {
        return empChancery
                .getOrDefault(e, Collections.emptyList())
                .parallelStream()
                .mapToDouble(Chancery::getPrice)
                .sum();
    }

}
