package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

class Processor implements Runnable {
    
    private int id;
    
    public Processor(int id){
        this.id = id;
    }
    
    public void run(){
        System.out.println("Starting: " + id);
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Completed: "+ id);
    }
    
}

public class Executor{
    
    public static void main(String[] args) throws InterruptedException{
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        for(int i=0; i<5; i++){
            executor.submit(new Processor(i));
        }
        
        executor.shutdown();
        
        System.out.println("All tasks submited.");
        
        executor.awaitTermination(1, TimeUnit.DAYS);
        
        System.out.println("All tasks completed.");
    }
}
