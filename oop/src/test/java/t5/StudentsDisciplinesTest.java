package t5;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class StudentsDisciplinesTest {

    private static Student student1;
    private static Student student2;
    private static Student student3;
    private static Student student4;
    private static Student student5;
    private static Student student6;

    private static Group<Integer> group1;
    private static Group<Integer> group2;
    private static  Group<Double> group3;
    private static Group<Double> group4;

    @BeforeClass
    public static void init() throws Exception {

        student1 = new Student();
        student2 = new Student();
        student3 = new Student();
        student4 = new Student();
        student5 = new Student();
        student6 = new Student();

        group1 = new Group<>(Group.Discipline.ALGEBRA);
        group2 = new Group<>(Group.Discipline.GEOMETRY);
        group3 = new Group<>(Group.Discipline.C);
        group4 = new Group<>(Group.Discipline.JAVA);

        group1.addStudent(student1, 5);
        group1.addStudent(student2, 4);
        group1.addStudent(student3, 3);
        group1.addStudent(student4, 2);
        group1.addStudent(student5, 1);

        group2.addStudent(student6, 1);
        group2.addStudent(student2, 2);
        group2.addStudent(student3, 3);
        group2.addStudent(student4, 4);

        group3.addStudent(student1, 6.4);
        group3.addStudent(student2, 7.3);
        group3.addStudent(student4, 8.2);
        group3.addStudent(student6, 7.2);

        group4.addStudent(student1, 5.1);
        group4.addStudent(student2, 4.2);
        group4.addStudent(student3, 3.4);
        group4.addStudent(student4, 2.1);
        group4.addStudent(student5, 1.9);
    }

    @Test
    public void disciplinesTest() {

        Journal journal = new Journal();

        journal.addGroup(group1);
        journal.addGroup(group2);
        journal.addGroup(group3);
        journal.addGroup(group4);

        journal.getMarksInGroupsOfStudent(student1);

        Set<Group.Discipline> disciplinesOfStudent1 = new HashSet<>();
        disciplinesOfStudent1.add(group1.getDiscipline());
        disciplinesOfStudent1.add(group4.getDiscipline());
        disciplinesOfStudent1.add(group3.getDiscipline());

        assertThat(journal.getMarksInGroupsOfStudent(student1).keySet(), equalTo(disciplinesOfStudent1));
    }

    /*@Test
    public void marksTest(){
        Journal journal = new Journal();

        journal.addGroup(group1);
        journal.addGroup(group2);
        journal.addGroup(group4);

        assertThat(journal.getGratestMarkOfSturent(student2)[0], equalTo(4.2));
    }*/
}
