package threading.waitNotify;

import java.util.Scanner;

public class WaitAndNotify {
    
    public void produce() throws InterruptedException{
        synchronized (this){
            System.out.println("Producer thread running");
            wait();
            System.out.println("Resumed.");
        }
    }
    
    public void consume() throws InterruptedException{
        Thread.sleep(2000);
        Scanner s = new Scanner(System.in);
        
        synchronized (this){
            System.out.println("Waiting for return key");
            s.nextLine();
            System.out.println("Return key pressed");
            notify();
            Thread.sleep(5000);
            
        }
    }
    
}
