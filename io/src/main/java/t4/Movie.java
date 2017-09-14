package t4;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Movie implements Serializable, Comparable<Movie> {
    private String title;
    private int year;
    private List<Actor> actors;


    public Movie(String title, int year, List<Actor> actors) {
        this.title = title;
        this.year = year;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<Actor> getActors() {
        return actors;
    }

    private List<String> getActorsAsStrings() {
        return actors.stream().map(actor -> actor.toString()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return new StringBuilder(title).append(" [").append(year).append("] (Cast: ")
                .append(String.join(", ", getActorsAsStrings()))
                .append(')').toString();
    }

    @Override
    public int compareTo(Movie o) {
        return title.compareTo(o.getTitle());
    }
}
