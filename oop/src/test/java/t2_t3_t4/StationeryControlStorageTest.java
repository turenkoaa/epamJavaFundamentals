package t2_t3_t4;

import org.junit.Before;
import org.junit.Test;
import t2_t3_t4.*;
import t2_t3_t4.stationeries.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class StationeryControlStorageTest {

    private StationeryControlStorage storage;
    private Employee employee;

    @Before
    public void init() throws Exception {
        storage = new StationeryControlStorage();
        employee = new Employee();
    }

    @Test
    public void addChanceryToEmployee() throws Exception {
        Pen pen = new Pen(25, "SMTH", WritingAccessory.Color.BLUE, 0.7);
        storage.addChanceryToEmployee(employee, pen);
        List<Stationery> chanceries = storage.getEmpChancery(employee);
        assertThat(chanceries.size(), equalTo(1));
        assertThat(chanceries.get(0), equalTo(pen));
    }

    @Test
    public void getFullPrice() throws Exception {
        double[] prices = {20, 50, 60};

        Stationery pen = new Pen(prices[0], "SMTH2", WritingAccessory.Color.BLUE, 0.7);
        Stationery folder = new Folder(prices[1], "SMTH1", 50);
        Stationery noteBook = new NoteBook(prices[2], 24, "SMTH");

        storage.addChanceryToEmployee(employee, pen);
        storage.addChanceryToEmployee(employee, folder);
        storage.addChanceryToEmployee(employee, noteBook);

        assertThat(storage.getSumPrice(employee), equalTo(Arrays.stream(prices).sum()));
    }



    @Test
    public void get0SumPrice() throws Exception {
        assertThat(storage.getSumPrice(employee), equalTo(0.0));
    }


}
