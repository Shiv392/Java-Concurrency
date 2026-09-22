package AsyncPrograming_04.ThenCompose_07;

public class Order {
    private int orderId;
    private double price;
    private String name;
    private int userId;

    public Order(int _orderId, double _price, String _name, int _userId){
        orderId = _orderId;
        price = _price;
        name = _name;
        userId = _userId;
    }

    public int getOrderId(){
        return orderId;
    }
    public double getOrderPrice(){
        return price;
    }
    public String getOrderName(){
        return name;
    }
    public int getUserId(){
        return userId;
    }
}
