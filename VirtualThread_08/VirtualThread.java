package VirtualThread_08;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualThread {

    public static void main(String[] args) throws InterruptedException {

        // Manage 100,000 tasks using 200 platform threads
        int totalTasks = 10000;

        //1. Using Fixed sized Thread pool 
        ExecutorService pool = Executors.newFixedThreadPool(200);
        long start = System.currentTimeMillis();
        try {

            for (int i = 0; i < totalTasks; i++) {

                pool.execute(() -> {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }

        } finally {

            pool.shutdown();
            pool.awaitTermination(1, TimeUnit.MINUTES);
        }

        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Total time taken using Fixed thread pool: " + elapsed + " ms");
        //Output ---------------------> Total Time Take : 2622 ms i.e 2.6 seconds 


        //2. Using Virtual Threads ----------------------------------------->
        ExecutorService virtualThreadPool = Executors.newVirtualThreadPerTaskExecutor();
        long start2 = System.currentTimeMillis();
        try {
            for (int i = 0; i < totalTasks; i++) {
                virtualThreadPool.execute(() -> {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }

        } finally {
            virtualThreadPool.shutdown();
            virtualThreadPool.awaitTermination(1, TimeUnit.MINUTES);
        }

        long elapsed2 = System.currentTimeMillis() - start2;
        System.out.println("Total time taken using Virtual Thread: " + elapsed2 + " ms");
        //Output ---------------------> Total Time Take : 137ms ms i.e 0.13seconds 
    }
}