package semaphore;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    
    public static void main(String[] args) throws Exception{
        
        
        ExecutorService executor = Executors.newCachedThreadPool();
        
        for(int i=0; i<200; i++){
            executor.submit(new Runnable(){
                public void run(){
                    try {
                        Connection.getInstance().connect();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
        
        executor.shutdown();
        
        executor.awaitTermination(1, TimeUnit.DAYS);
        
    }
}
