package javase.homework._01._4;

/**
 * Created by Yana on 06.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        if (args.length <= 1) {
            System.out.println("The number of command line arguments must be greater than 1.");
            return;
        }

        double arr[] = new double[args.length];
        for (int i = 0; i < args.length; i++) {
            try {
                arr[i] = Double.parseDouble(args[i]);
            } catch (Exception ex) {
                ex.printStackTrace();
                return;
            }
        }

        System.out.println("Max value: " + getMax(arr));
    }

    private static double getMax(double[] arr) {
        double max = 0;
        double sum;
        for (int i = 0; i < (arr.length - 1); i++) {
            sum = arr[i] + arr[i + 1];
            if(sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
