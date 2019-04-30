package threading.waitNotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) throws InterruptedException {

        final WaitAndNotify notify = new WaitAndNotify();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    notify.produce();
                } catch (InterruptedException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    notify.consume();
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
