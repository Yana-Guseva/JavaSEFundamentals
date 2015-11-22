package javase.homework._04._01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String inputFileName = "C:\\Users\\Yana\\IdeaProjects\\BinaryStream\\src\\javase\\homework\\_04\\_01\\Main.java";
        String outputFileName = "C:\\Users\\Yana\\IdeaProjects\\BinaryStream\\src\\javase\\homework\\_04\\_01\\output.txt";

        StringBuilder text = readInputStream(inputFileName);
        StringBuilder result = findKeywords(text);
        writeOutputStream(outputFileName, result);
    }

    public static StringBuilder readInputStream(String fileName) {
        StringBuilder strBuilder = new StringBuilder();
        try (FileInputStream inputFile = new FileInputStream(fileName)) {
            int next;
            while ((next = inputFile.read()) != -1) {
                strBuilder.append((char) next);
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

    public static void writeOutputStream(String fileName, StringBuilder result) {
        try (FileOutputStream outputFile = new FileOutputStream(fileName)) {
            outputFile.write(result.toString().getBytes());
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + fileName + " не найден");
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода " + e.toString());
        }
    }
}
