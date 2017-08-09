package t2_t3_t4.stationeries;

import java.util.Comparator;

/**
 * Created by Anastasia on 07.08.2017.
 */
public class StationeryManufactureComparator implements Comparator<Stationery> {
    @Override
    public int compare(Stationery o1, Stationery o2) {
        return o1.getManufacture().compareTo(o2.getManufacture());
    }
}
