package task2;

/**
 * Created by Anastasia on 10.06.2017.
 */
public class Task2 {

    public static int findMinIndex(double eps){
        int index = 1;
        while (sequenceValue(index) >= eps)
            index++;

        return index;
    }

    private static double sequenceValue(int index){
        return 1/Math.pow(1+index, 2);
    }
}
