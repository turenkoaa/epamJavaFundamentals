package t2_t3_t4;

import t2_t3_t4.stationeries.Stationery;

import java.util.*;

public class StationeryControlStorage {

    private Map<Employee, List<Stationery>> empChancery = new HashMap<>();

    List<Stationery> getChanceries(Employee employee) {
        return empChancery.getOrDefault(employee, Collections.emptyList());
    }

    public void addChanceryToEmployee(Employee employee, Stationery stationery) {
        List<Stationery> chanceries = empChancery.getOrDefault(employee, new ArrayList<>());
        chanceries.add(stationery);
        empChancery.put(employee, chanceries);
    }

    public double getSumPrice(Employee e) {
        return empChancery
                .getOrDefault(e, Collections.<Stationery>emptyList())
                .parallelStream()
                .mapToDouble(Stationery::getPrice)
                .sum();
    }

    public List<Stationery> getEmpChancery(Employee employee) {
        return empChancery.get(employee);
    }
}
