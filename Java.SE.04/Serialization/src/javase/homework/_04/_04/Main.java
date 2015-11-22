package javase.homework._04._04;

import java.io.*;

/**
 * Created by Yana on 01.11.2015.
 */
public class Main {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Yana\\IdeaProjects\\Serialization\\src\\javase\\homework\\_04\\_04\\films.txt";

        FilmCollection filmCollection = new FilmCollection();
//        filmCollection.addFilm(new Film("Film1", "Actor1", 2015));
//        filmCollection.addFilm(new Film("Film2", "Actor1", 2011));
//        filmCollection.addFilm(new Film("Film3", "Actor2", 2012));
//        filmCollection.addFilm(new Film("Film4", "Actor3", 2015));
//        filmCollection.addFilm(new Film("Film5", "Actor2", 2010));
//
//        filmCollection.editFilmActor("Film4", "Actor4");

        FilmCollection readedCollection;
        FileInputStream fileInputStream = null;
        ObjectInputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            fileInputStream = new FileInputStream(fileName);
            inputStream = new ObjectInputStream(fileInputStream);

            filmCollection = (FilmCollection) inputStream.readObject();
            fileInputStream.close();
            inputStream.close();
            System.out.println("Read objects: ");
            filmCollection.print();

            fileOutputStream = new FileOutputStream(fileName);
            outputStream = new ObjectOutputStream(fileOutputStream);

            filmCollection.editFilmActor("Film4", "Actor1");
            filmCollection.editFilmName("Film1", "Film6");
            filmCollection.editYear("Film3", 1989);
            outputStream.writeObject(filmCollection);
            fileOutputStream.close();
            outputStream.close();
            System.out.println("Write collection: ");
            filmCollection.print();

            fileInputStream = new FileInputStream(fileName);
            inputStream = new ObjectInputStream(fileInputStream);

            readedCollection = (FilmCollection) inputStream.readObject();
            fileInputStream.close();
            inputStream.close();
            System.out.println("Read objects: ");
            readedCollection.print();
//            System.out.println("equals " + filmCollection.equals(readedCollection));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
