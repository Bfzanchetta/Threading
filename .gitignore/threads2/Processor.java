package threads2;

import java.util.LinkedList;
import java.util.Random;

public class Processor {

    private LinkedList<Integer> list = new LinkedList<Integer>();
    private final int LIMIT = 10;
    private Object lock = new Object();

    public void producer() throws InterruptedException {

        int value = 0;
        while (true) {
            synchronized (lock) {

                while (list.size() == LIMIT) {
                    lock.wait();
                }

                list.add(value++);
                lock.notify();
            }
        }
    }

    public void consumer() throws InterruptedException {
        Random random = new Random();
        
        while (true) {
            synchronized (lock) {
                
                while(list.isEmpty()){
                    lock.wait();
                }
                
                System.out.println("List size: " + list.size());
                int aux = list.removeFirst();
                System.out.println("Value is: " + aux);
                lock.notify();
            }
            Thread.sleep(random.nextInt(1000));
        }

    }
}
