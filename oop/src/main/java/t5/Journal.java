package t5;

import java.util.*;


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

    /*public Collection<Number> getGratestMarkOfSturent(Student student){

        List<Map.Entry<Group.Discipline, Number>> list =
                new LinkedList<>(getMarksInGroupsOfStudent(student).entrySet());

        Collections.sort(list, (o1, o2) -> (o1.getValue()).compareTo(o2.getValue()));

        Map<Group.Discipline, Number> result = new LinkedHashMap<>();
        for (Map.Entry<Group.Discipline, Number> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result.values();
    }*/

}
