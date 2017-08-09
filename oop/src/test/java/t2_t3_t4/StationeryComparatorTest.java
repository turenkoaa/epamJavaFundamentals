package t2_t3_t4;

import org.junit.Before;
import org.junit.Test;
import t2_t3_t4.stationeries.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Anastasia on 07.08.2017.
 */
public class StationeryComparatorTest {

    private final Stationery[] stationeryObjects = {
            new Pen(15, "SMTH2", WritingAccessory.Color.BLUE, 0.7),
            new Folder(30, "SMTH1", 50),
            new NoteBook(15, 24, "SMTH")};

    private List<Stationery> stationeries;
    private List<Stationery> sorted;

    @Before
    public void init() {
        stationeries = new ArrayList<>();
        stationeries.add(stationeryObjects[0]);
        stationeries.add(stationeryObjects[1]);
        stationeries.add(stationeryObjects[2]);
    }

    @Test
    public void stationeryPriceComparator() {

        sorted  = new ArrayList<>();
        sorted.add(stationeryObjects[0]);
        sorted.add(stationeryObjects[2]);
        sorted.add(stationeryObjects[1]);

        stationeries.sort(new StationeryPriceComparator());
        assertThat("Sorting by price failed!", stationeries, equalTo(sorted));
    }

    @Test
    public void stationeryManufactureComparator() {
        sorted  = new ArrayList<>();
        sorted.add(stationeryObjects[2]);
        sorted.add(stationeryObjects[1]);
        sorted.add(stationeryObjects[0]);

        stationeries.sort(new StationeryManufactureComparator());
        assertThat("Sorting by name failed!", stationeries, equalTo(sorted));
    }

    @Test
    public void stationeryModelAndPriceComparator() {
        sorted  = new ArrayList<>();
        sorted.add(stationeryObjects[2]);
        sorted.add(stationeryObjects[0]);
        sorted.add(stationeryObjects[1]);

        stationeries.sort(new StationeryPriceComparator().thenComparing(new StationeryManufactureComparator()));
        assertThat("Sorting by name and price failed!", stationeries, equalTo(sorted));
    }


}
