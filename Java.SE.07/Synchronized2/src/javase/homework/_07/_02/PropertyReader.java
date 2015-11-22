package javase.homework._07._02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static java.lang.Thread.sleep;

/**
 * Created by Yana on 04.11.2015.
 */
public class PropertyReader {
    private final Properties properties = new Properties();

    private PropertyReader() {
        String name = "C:\\Users\\Yana\\IdeaProjects\\Synchronized2\\src\\resources\\my.property";
        try (FileInputStream inputStream = new FileInputStream(name)) {
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            System.out.println("No such *.property file.");
        } catch (IOException e) {
            System.out.println("Input/output error.");
        }
    }

    public static class PropertyHolder {
        private static final PropertyReader PROPERTY_READER = new PropertyReader();
    }

    public static PropertyReader getPropertyReader() {
        return PropertyHolder.PROPERTY_READER;
    }

    public synchronized String getProperty(String key) {
        try {
            if (!containsKey(key)) {
                throw new KeyException();
            }
        } catch (KeyException e) {
            System.out.println(e.getMessage());
        }
        return properties.getProperty(key);
    }

    public boolean containsKey(String key) {
        return properties.containsKey(key);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(PropertyReader.getPropertyReader().getProperty("key1"));
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(PropertyReader.getPropertyReader().getProperty("key2"));
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(PropertyReader.getPropertyReader().getProperty("key1"));
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}