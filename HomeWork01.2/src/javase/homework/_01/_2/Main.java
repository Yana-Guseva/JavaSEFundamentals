package javase.homework._01._2;

import static java.lang.Math.*;

/**
 * Created by Yana on 29.09.2015.
 */
public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Enter the command line arguments");
            return;
        }
        double eps = Double.parseDouble(args[0]);
        if (eps < 0) {
            return;
        }
        int i;
        double a = 0.25;
        for (i = 1; a >= eps; i++) {
            a = 1 / pow(i + 1, 2);
            System.out.println("a[" + i + "] = " + a);
        }
        if (--i > 0) {
            System.out.println("min number: " + i);
        } else {
            System.out.println("There is no such element");
        }
    }
}

