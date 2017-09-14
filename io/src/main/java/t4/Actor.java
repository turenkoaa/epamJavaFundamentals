package t4;


import java.io.Serializable;

public class Actor implements Serializable {
    private String firstName;
    private String lastName;
    private String nationality;

    public Actor(String firstName, String lastName, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s)", firstName, lastName, nationality);
    }
}