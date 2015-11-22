package javase.homework._01._3;

import java.util.Scanner;

import static java.lang.Math.*;

/**
 * Created by Yana on 05.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter border a: ");
        double a = sc.nextDouble();
        System.out.print("\nEnter border b: ");
        double b = sc.nextDouble();
        if (a > b) {
            System.out.println("Wrong value! b must be greater than a");
            return;
        }
        System.out.print("\nEnter the step: ");
        double step = sc.nextDouble();
        sc.close();

        double x = a;
        do {
            System.out.format("x = %.5f\tF(x) = %.5f",x, function(x));
            System.out.println();
            x += step;
        } while ((a <= x) && (x <= b));
        if ((x - step) != b) {
            System.out.format("x = %.5f\tF(x) = %.5f",b, function(b));
        }
    }

    private static double function(double x) {
            return tan(2 * x) - 3;
    }
}
