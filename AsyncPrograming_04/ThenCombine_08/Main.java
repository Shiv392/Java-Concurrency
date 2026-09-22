package AsyncPrograming_04.ThenCombine_08;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        OrderList orderList = new OrderList();
        UserList userList = new UserList();
        orderList.addOrders();
        userList.addUser();

        try{
            //first get the user future response 
            CompletableFuture<User>userFuture = CompletableFuture.supplyAsync(new GetUserTask(userList, 10));

            //now get the order futures list 
            CompletableFuture<List<Order>>orderFuture = CompletableFuture.supplyAsync(new GetAllOrders(orderList));

            //now when both futures are done then combine both of them
            CompletableFuture<String>resultFuture = userFuture.thenCombine(orderFuture,
                (user, order)-> {
                    return user.getName()+" has "+order.size()+" orders";
                }
            );
            resultFuture.thenAccept(result-> System.out.println(result));
        }
        finally{
            pool.shutdown();
        }
    }
}
