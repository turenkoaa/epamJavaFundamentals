package t5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Journal {

    private List<Group> groups;

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void addGroup(Group group){
        groups.add(group);
    }

    public Journal() {
        this.groups = new ArrayList<>();
    }

    public Journal(List<Group> groups) {
        this.groups = groups;
    }

    public Map<Group.Discipline, Number> getMarksInGroupsOfStudent(Student student){
        Map<Group.Discipline, Number> result = new HashMap<>();
        for (Group group: groups){
            if (group.getStudents().contains(student)) {
                result.put(group.getDiscipline(), group.getMarkOfStudent(student));
            }
        }
        return result;
    }



}
