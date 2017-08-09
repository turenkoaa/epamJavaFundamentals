package t2_t3_t4.stationeries;

import java.util.Comparator;

public class StationeryPriceComparator implements Comparator<Stationery> {
    @Override
    public int compare(Stationery o1, Stationery o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
