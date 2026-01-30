public class Aggregator {
    private Menu menu = new Menu();
    private Orders orders = new Orders();

    public Aggregator(){}

    //gets the name from a passed order number from order item number
    public String getName(int order_inumber){
        for (MenuItem item : menu.menu_items) {
            if(item.item_number == order_inumber){
                return item.name;
            }
        }
        return "No item associated with that item number";
    }

    public double getPrice(int order_inumber){
        for (MenuItem item : menu.menu_items) {
            if(item.item_number == order_inumber){
                return item.price;
            }
        }
        return -1;
    }

    public Menu getMenu(){
        return new Menu();
    }

    public Orders getOrders(){
        return new Orders();
    }
}
