package javase.homework._03._03;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yana on 25.10.2015.
 */
public class Main {
    public static final String PATH = "C://Users/Yana/epam/test.html";

    public static void main(String[] args) {

        String text = null;
        try {
            text = readFile(PATH);
        } catch (FileNotFoundException e) {
            System.out.println("no such file");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (text != null) {
            if (LinkSequence.checkSequence(text)) {
                System.out.println("—сылки идут последовательно.");
            } else {
                System.out.println("ѕоследовательность ссылок была нарушена.");
            }

            LinkSequence.printSentenceWithPicture(text);
        }
    }

    public static String readFile(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
        try (BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
            String s;
            while ((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
