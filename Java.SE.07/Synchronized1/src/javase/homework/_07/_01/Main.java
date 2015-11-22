package javase.homework._07._01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Yana on 14.11.2015.
 */
public class Main {
    public static void main(String[] args) {

        Account account1 = new Account(1, 1000);
        Account account2 = new Account(2, 1000);

        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("C:\\Users\\Yana\\IdeaProjects\\Synchronized1\\test.txt"))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                String infoAcc[] = str.split(" ");
                if(Integer.parseInt(infoAcc[0]) == 1) {
                    new Operator(account1, account2, Integer.parseInt(infoAcc[2])).start();
                } else {
                    new Operator(account2, account1, Integer.parseInt(infoAcc[2])).start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
