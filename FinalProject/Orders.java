import java.util.ArrayList;

public class Orders {
    protected ArrayList<OrderItem> order_items = new ArrayList<>();

    public Orders(){
        order_items.add(new OrderItem(001));
        order_items.add(new OrderItem(002));
        order_items.add(new OrderItem(003));        
    }

    public void submit(){
        
    }
}
