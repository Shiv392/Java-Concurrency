package AsyncPrograming_04.ThenCombine_08;

import java.util.List;
import java.util.function.Supplier;

public class GetAllOrders implements Supplier<List<Order>> {
    
    private final OrderList orderList;

    public GetAllOrders(OrderList _orderList){
        orderList = _orderList;
    }
    
    @Override 
    public List<Order> get(){
        return orderList.getOrders();
    }
}
