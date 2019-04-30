package threads;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Worker {

    private Random random = new Random();
    private Object lock1=new Object();
    private Object lock2=new Object();

    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();

    public void stageOne() throws InterruptedException {
        synchronized (lock1) {
            Thread.sleep(10);
            list1.add(random.nextInt(100));
        }
    }

    public void stageTwo() throws InterruptedException {
        synchronized (lock2) {
            Thread.sleep(10);
            list2.add(random.nextInt(100));
        }
    }

    public void process() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public void main() throws InterruptedException {
        System.out.println("Starting ...");

        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        thread.start();
        thread.join();
        long end = System.currentTimeMillis();
        System.out.println("Final time: " + (end - start));
    }

}
