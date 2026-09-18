package VirtualThread_08;

import java.util.function.Supplier;

public class SumTask implements Supplier<Integer> {
    
    @Override 
    public Integer get(){
        System.out.println("Thread name........... "+Thread.currentThread().getName());
        return 10+20;
    }
}
