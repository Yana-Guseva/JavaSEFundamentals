package javase.homework._04._04;

import java.io.Serializable;

/**
 * Created by Yana on 01.11.2015.
 */
public class Film implements Serializable {
    private String name;
    private String actor;
    private Integer yearOfCreation;

    public Film(String name, String actor, int year) {
        this.name = name;
        this.actor = actor;
        this.yearOfCreation = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public void setYearOfCreation(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Actor: " + actor + " Year: " + yearOfCreation;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Film newFilm = (Film) obj;
        if (!name.equals(newFilm.getName())) {
            return false;
        }
        if (!actor.equals(newFilm.getActor())) {
            return false;
        }
        if (!yearOfCreation.equals(newFilm.yearOfCreation)) {
            return false;
        }
        return true;
    }
}