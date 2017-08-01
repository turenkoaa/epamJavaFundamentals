package main.java;

import t02_t03.Chancery;
import t02_t03.NoteBook;
import t02_t03.Pen;
import t02_t03.WritingAccessory.Color;

public class Main {
    public static void main(String[] args) {

        Chancery redPen = new Pen(25, Color.RED, 0.5);
        Chancery noteBook90 = new NoteBook(50, 90, "smth");
    }
}
