package VirtualThread_08;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        //1. Simple Virtual thread with Completable Future Code. 
        // ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

        // try{
        //     CompletableFuture<Integer>sumTaskFuture = CompletableFuture.supplyAsync(new SumTask(),
        //     executorService
        // );

        // sumTaskFuture.thenApplyAsync(num-> num*10)
        // .thenAcceptAsync(num-> System.out.println("num: "+num))
        // .join();
        // }
        // catch(Exception ex){

        // }
        // finally{
        //     executorService.shutdown();
        // }


        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

        try{
            CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(()->{
                System.out.println("User: "+Thread.currentThread());
                sleep(2000);
                return "Shiv Soni User";
            }, executorService);

            CompletableFuture<String> orderFuture = CompletableFuture.supplyAsync(()->{
                System.out.println("Order: "+Thread.currentThread());
                sleep(3000);
                return "Order";
            }, executorService);

            CompletableFuture<String> paymentFuture = CompletableFuture.supplyAsync(()->{
                System.out.println("Payment: "+Thread.currentThread());
                sleep(1000);
                return "Payment";
            }, executorService);

            CompletableFuture.allOf(
                userFuture,
                orderFuture,
                paymentFuture
                ).join();

            System.out.println("User: " + userFuture.join());
            System.out.println("Order: " + orderFuture.join());
            System.out.println("Payment: " + paymentFuture.join());
        }
        finally{
            executorService.shutdown();
        }
    }

    public static void sleep(long millisecond){
        try{
            Thread.sleep(millisecond);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
