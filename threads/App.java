package threads;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private int count = 0;

    public static void main(String[] args) throws InterruptedException{
        Worker worker = new Worker();
        worker.main();
    }

}