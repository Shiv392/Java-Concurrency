package AsyncPrograming_04.ThenCompose_07;

import java.util.function.Supplier;
import java.util.List;

public class GetOrdersTask implements Supplier<List<Order>> {

    private final OrderList orderList;
    private final User user;

    public GetOrdersTask(OrderList _OrderList, User _user){
        orderList = _OrderList;
        user = _user;
    }
 
    @Override
    public List<Order> get(){
        return orderList.getOrders().stream()
        .filter(order-> user.getId() == order.getUserId())
        .toList();
    }
}
