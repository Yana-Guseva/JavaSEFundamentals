package javase.homework._03._02;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Yana on 24.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        QuestionsProperty property;
        AnswersProperty answProperty;
        System.out.println("1 - ru");
        System.out.println("2 - en");
        try (Scanner sc = new Scanner(System.in)) {
            int loc = sc.nextInt();
            switch (loc) {
                case 1:
                    property = new QuestionsProperty(new Locale("ru", "RU"));
                    answProperty = new AnswersProperty(new Locale("ru", "RU"));

                    break;
                case 2:
                    property = new QuestionsProperty(new Locale("en", "US"));
                    answProperty = new AnswersProperty(new Locale("en", "US"));
                    break;
                default:
                    property = new QuestionsProperty(new Locale("en", "US"));
                    answProperty = new AnswersProperty(new Locale("ru", "RU"));
            }

            try {
                property.getAllValues();
                int number = sc.nextInt();
                System.out.println(answProperty.getValue("answer" + number));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
