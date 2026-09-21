package CustomThreadPool_09;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(
            10, 
            100, 
            120, TimeUnit.SECONDS, 
            new ArrayBlockingQueue<>(100),
            new CustomRejectionHandler()
         );

         try {
            for(int i=0;i<10;i++){
            pool.execute(()->{
                System.out.println("Thread working............. "+Thread.currentThread().getName());
            });
            }
         } 
         finally{
            pool.shutdown();
         }
    }
}
