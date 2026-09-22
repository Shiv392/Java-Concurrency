package AsyncPrograming_04.ThenCompose_07;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        UserList userList = new UserList();
        OrderList orderList = new OrderList();
        
        userList.addUser();
        orderList.addOrders();

        try{
            //1. first find the user with id 10
            CompletableFuture<User> user = CompletableFuture.
            supplyAsync(new GetUserTask(userList, 10), pool);

            //2. now get the list of all order by this user.
            CompletableFuture<List<Order>>orders = user.thenCompose(currUser ->
                CompletableFuture.supplyAsync(new GetOrdersTask(orderList, currUser), 
                pool
                )
            );

            orders.thenAccept(orderlist-> {
                System.out.println("Orders==================>");
                orderlist.forEach(order->{
                    System.out.println("Order Id: "+order.getOrderId()+" "+"Order Name: "+order.getOrderName()
                    +" " + "Order price: "+order.getOrderPrice()+" "+"User Id: "+order.getUserId()
                    );

                    System.out.println("");
                });
            });
        }
        finally{
            pool.shutdown();
        }
    }
}
