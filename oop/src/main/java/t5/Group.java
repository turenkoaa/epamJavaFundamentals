package t5;

import java.util.*;

public class  Group <T extends Number> {

    public enum Discipline{
        C, JAVA, GEOMETRY, ALGEBRA;
    }

    private Discipline discipline;
    private Map<Student, T> students;

    public Group(Discipline discipline) {
        this.discipline = discipline;
        students = new HashMap<Student, T>();
    }

    public void addStudent(Student student, T mark){
        students.put(student, mark);
    }

    public Set<Student> getStudents(){
        return students.keySet();
    }

    public T getMarkOfStudent(Student student) {
        return students.get(student);
    }

    public Discipline getDiscipline() {
        return discipline;
    }
}
