package CustomThreadPool_09;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class CustomRejectionHandler implements RejectedExecutionHandler  {
    
    @Override 
    public void rejectedExecution(Runnable r, ThreadPoolExecutor pool){
        //loggin etc
    }
}
