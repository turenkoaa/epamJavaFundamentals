package task3;

/**
 * Created by Anastasia on 11.06.2017.
 */
public class Task3 {

    public static void getValues(double a, double b, double step){

        String leftAlignFormat = "| %-15f | %-30f |%n";

        System.out.format("+--------------------------------------------------+%n");
        System.out.format("| x               | F(x)                           |%n");
        System.out.format("+-----------------+--------------------------------+%n");

        for (double i = a; i <= b; i += step){
            System.out.format(leftAlignFormat, i, function(i));
        }

        System.out.format("+-----------------+--------------------------------+%n");
    }

    public static double function(double x){
        return Math.tan(2*x) - 3;
    }
}
