package deadlocks;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    
    public static void main(String[] args) throws InterruptedException{
        Runner runner = new Runner();
        
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                try {
                    runner.firstThread();
                } catch (InterruptedException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        Thread t2 = new Thread(new Runnable(){
            public void run(){
                try {
                    runner.secondThread();
                } catch (InterruptedException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        runner.finished();
    }
    
}
