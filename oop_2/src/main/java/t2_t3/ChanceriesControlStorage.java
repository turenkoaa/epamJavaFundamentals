package t2_t3;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChanceriesControlStorage {

    private Map<Employee, List<Chancery>> empChancery = new HashMap<Employee, List<Chancery>>();

    List<Chancery> getChanceries(Employee employee) {
        return empChancery.getOrDefault(employee, Collections.<Chancery>emptyList());
    }

    public void addChanceryToEmployee(Employee employee, Chancery chancery) {
        List<Chancery> chanceries = empChancery.getOrDefault(employee, new ArrayList<>());
        chanceries.add(chancery);
        empChancery.put(employee, chanceries);
    }

    double getSumPrice(Employee e) {
        return empChancery
                .getOrDefault(e, Collections.<Chancery>emptyList())
                .parallelStream()
                .mapToDouble(Chancery::getPrice)
                .sum();
    }

    public List<Chancery> getEmpChancery(Employee employee) {
        return empChancery.get(employee);
    }
}
