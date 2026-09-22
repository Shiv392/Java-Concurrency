package AsyncPrograming_04.ThenCombine_08;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    List<Order> orders = new ArrayList<>();

    public void addOrders() {
        for (int i = 1; i <= 50; i++) {
            int userId = ((i - 1) % 20) + 1;
            orders.add(
                    new Order(
                            i,
                            100 + (i * 10),
                            "Order" + i,
                            userId
                        ));
        }
    }

    public List<Order> getOrders(){
        return orders;
    }
}
