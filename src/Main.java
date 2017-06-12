import task5.Task5;
import task2.Task2;
import task3.Task3;

public class Main {

    public static void main(String[] args) {

        System.out.println("Task 2. Min index of sequence: " + Task2.findMinIndex(0.000011));

        System.out.println("Task 3.");
        Task3.getValues(0, 6*Math.PI, Math.PI/8);

        System.out.println("Task 4.");
        //double a = {1, 2, 3 ,1, 2, 3 ,4 ,5};
        //task4.getMax(a);

        System.out.println("Task 5.");
        Task5.printMatrix(Task5.getMatrix(21));


    }
}
