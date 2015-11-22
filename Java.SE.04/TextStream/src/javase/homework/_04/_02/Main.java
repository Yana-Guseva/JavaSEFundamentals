package javase.homework._04._02;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yana on 31.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        String inputFileName = "C:\\Users\\Yana\\IdeaProjects\\TextStream\\src\\javase\\homework\\_04\\_02\\Main.java";
        String outputFileName = "C:\\Users\\Yana\\IdeaProjects\\TextStream\\src\\javase\\homework\\_04\\_02\\output.txt";

        StringBuilder text = readFile(inputFileName);
        StringBuilder result = findKeywords(text);
        writeFile(outputFileName, result);
    }

    public static StringBuilder readFile(String fileName) {
        StringBuilder strBuilder = new StringBuilder();
        try (FileReader fileReader = new FileReader(fileName)) {
            int next;
            while ((next = fileReader.read()) != -1) {
                strBuilder.append(( char ) next);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + fileName + " не найден");
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода " + e.toString());
        }
        return strBuilder;
    }

    public static StringBuilder findKeywords(StringBuilder strBuilder) {
        Pattern pattern = Pattern.compile("abstarct |assert |boolean |break |byte |case |" +
                "catch |char |class |const |continue |default |do |double |else |enum |" +
                "extends |final |finally |float |for |goto |if |implements |import |instanceof |" +
                "int |interface |long |native |new |package |private |protected |public |return |" +
                "short |static |strictfp |super |switch |synchronized |this |throw |throws |transient |" +
                "try |void |volatile |while ");
        Matcher matcher = pattern.matcher(strBuilder);
        int counter = 0;
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            result.append(matcher.group());
            counter++;
        }
        result.append("Counter ");
        result.append(counter);
        return result;

    }

    public static void writeFile(String fileName, StringBuilder result) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(result.toString());
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + fileName + " не найден");
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода " + e.toString());
        }
    }
}
