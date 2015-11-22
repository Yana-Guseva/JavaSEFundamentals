package javase.homework._06._02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Yana on 04.11.2015.
 */
public class PropertyReader {
    private final Properties properties = new Properties();
    private Map<String, String> map = new HashMap<String, String>();

    private PropertyReader() {
        String name = "C:\\Users\\Yana\\IdeaProjects\\Map\\src\\resources\\my.property";
        try (FileInputStream inputStream = new FileInputStream(name)) {
            properties.load(inputStream);
            map = getMap();
        } catch (FileNotFoundException e) {
            System.out.println("No such *.property file.");
        } catch (IOException e) {
            System.out.println("Input/output error.");
        }
    }

    private Map getMap() {
        for (Map.Entry entry : properties.entrySet()) {
            map.put((String) entry.getKey(), (String) entry.getValue());
        }
        return map;
    }

    public static class PropertyHolder {
        private static final PropertyReader PROPERTY_READER = new PropertyReader();
    }

    public static PropertyReader getPropertyReader() {
        return PropertyHolder.PROPERTY_READER;
    }

    public String getProperty(String key) {
        try {
            if (!containsKey(key)) {
                throw new KeyException();
            }
        } catch (KeyException e) {
            System.out.println(e.getMessage());
        }
        return (String) map.get(key);
    }

    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    public static void main(String[] args) {
        System.out.println(PropertyReader.getPropertyReader().getProperty("key1"));
        System.out.println(PropertyReader.getPropertyReader().getProperty("key2"));
        System.out.println(PropertyReader.getPropertyReader().getProperty("key4"));
    }
}
