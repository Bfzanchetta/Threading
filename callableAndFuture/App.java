package callableAndFuture;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;


public class App {
    
    public static void main(String[] args){
        ExecutorService executor = Executors.newCachedThreadPool();
        
        executor.submit(new Callable<Integer>(){
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                int duration = random.nextInt(4000);
                
                System.out.println("Starting...");
                
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                System.out.println("Finished.");
                return duration;
            }
        });
        
        executor.shutdown();
    }
}
