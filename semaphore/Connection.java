package semaphore;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection {
    
    private static Connection instance = new Connection();
    
    private Semaphore semaphore = new Semaphore(10, true);
    
    private int connections = 0;
    
    private Connection(){
        
    }
    
    static Connection getInstance(){
        return instance;
    }
    
    public void connect() throws InterruptedException{
        try{
            semaphore.acquire();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        try{
            doConnect();
        }
        finally{
            semaphore.release();
        }
    }
    
    public void doConnect() throws InterruptedException{
        
        synchronized(this){
            connections++;
            System.out.println("Current connections: "+connections);
        }
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        synchronized(this){
            connections--;
        }
    }
}
