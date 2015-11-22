package javase.homework._04._04;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Yana on 01.11.2015.
 */
public class FilmCollection implements Serializable {
    ArrayList<Film> films;

    FilmCollection() {
        films = new ArrayList<>();
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

    public void addFilm(Film film) {
        films.add(film);
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
        FilmCollection filmCollection = (FilmCollection) obj;
        if (filmCollection.films.size() != films.size()) {
            return false;
        }
        for (int i = 0; i < films.size(); i++) {
            if(!films.get(i).equals(filmCollection.films.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void removeFilm(String name) {
        for(Film film : films) {
            if (film.getName().equals(name)) {
                films.remove(film);
            }
        }
    }

    public void editFilmName(String filmName, String newName) {
        for(Film film : films) {
            if (film.getName().equals(filmName)) {
                film.setName(newName);
            }
        }
    }

    public void editFilmActor(String filmName, String actor) {
        for(Film film : films) {
            if (film.getName().equals(filmName)) {
                film.setActor(actor);
            }
        }
    }

    public void editYear(String filmName, int year) {
        for(Film film : films) {
            if (film.getName().equals(filmName)) {
                film.setYearOfCreation(year);
            }
        }
    }

    public void print() {
        for(Film film : films) {
            System.out.println(film.toString());
        }
    }
}
