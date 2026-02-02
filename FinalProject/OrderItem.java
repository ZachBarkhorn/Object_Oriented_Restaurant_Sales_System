public class OrderItem {
    protected int item_number;
    protected int amount_ordered = 1;

    public OrderItem(int arg_inum){
        item_number = arg_inum;
    }

    public void addOne(){
        amount_ordered++;
    }
}
