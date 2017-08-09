package main.java;


import main.java.t02_t03.chanceries.Chancery;
import main.java.t02_t03.chanceries.NoteBook;
import main.java.t02_t03.chanceries.Pen;
import main.java.t02_t03.chanceries.WritingAccessory;

public class Main {
    public static void main(String[] args) {

        Chancery redPen = new Pen(25, WritingAccessory.Color.RED, 0.5);
        Chancery noteBook90 = new NoteBook(50, 90, "smth");
    }
}
