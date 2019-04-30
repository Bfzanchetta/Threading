package threads2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) throws InterruptedException {

        Processor processor = new Processor();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    processor.producer();
                } catch (InterruptedException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    processor.consumer();
                } catch (InterruptedException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}
