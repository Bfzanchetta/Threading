package lowLevelSync;

import threading.waitNotify.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) throws InterruptedException {

        WaitAndNotify test = new WaitAndNotify();
        
        Thread thread1 = new Thread(new Runnable(){
            public void run(){
                
            }
        });
            
        
    }

}
