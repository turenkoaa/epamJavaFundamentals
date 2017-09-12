package t6;

import org.hamcrest.core.Is;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class NuclearSubmarineTest {

    @Test
    public void getValueOfSomeInfo() throws Exception {
        assertThat(NuclearSubmarine.getValueOfSomeInfo(), is("NuclearSubmarine"));
    }

    @Test
    public void swim() throws Exception {
        NuclearSubmarine nuclearSubmarine  = new NuclearSubmarine("Some submarine", 1000);
        assertThat(nuclearSubmarine.swim(), is("Submarine name: Some submarine\nEngine power: 1000"));
    }


}