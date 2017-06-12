package task4;

/**
 * Created by Anastasia on 11.06.2017.
 */
public class Task4 {

    public static double getMax(double a[]){
        int length = a.length;
        double max = a[0]+a[2*length-1];
        double sum;
        if ( length%2 != 0) {
            for (int i = 1; i < length / 2; i++) {
                sum = a[i] + a[length - i - 1];
                if (max <= sum)
                    max = sum;
            }
        }

        return max;
    }
}
