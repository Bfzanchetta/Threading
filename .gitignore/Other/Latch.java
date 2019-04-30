package threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

class Processor1 implements Runnable {

    private CountDownLatch latch;

    public Processor1(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        System.out.println("Started.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Processor1.class.getName()).log(Level.SEVERE, null, ex);
        }
        latch.countDown();
    }
}

public class Latch {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executor.submit(new Processor1(latch));
        }
        latch.await();
        System.out.println("Completed.");
    }
}
