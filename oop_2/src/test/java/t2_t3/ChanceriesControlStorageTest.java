package t2_t3;

import java.util.List;

public class ChanceriesControlStorageTest {

    private ChanceriesControlStorage storage;
    private Employee employee;

    @BeforeEach
    void init() throws Exception {
        storage = new ChanceriesControlStorage();
        employee = new Employee();
    }

    @Test
    void addChanceryToEmployee() throws Exception {
        Pen pen = new Pen(25, WritingAccessory.Color.BLUE, 0.7);
        storage.addChanceryToEmployee(employee, pen);
        List<Chancery> chanceries = storage.getEmpChancery(employee);
        assertThat(chanceries.size(), equalTo(1));
        assertThat(chanceries.get(0), equalTo(pen));
    }


}
