import java.util.ArrayList;

public class Aggregator {
    private Menu menu = new Menu();    
    private Table tab;    
    private Orders orders;
    
    // Store all menu items from all strategies for lookup
    private ArrayList<MenuItem> allMenuItems = new ArrayList<>();

    public Aggregator(Table arg_tab){
        tab = arg_tab;
        orders = new Orders(tab);
        initializeAllMenuItems();
    }
    
    // Populate all menu items from all strategies
    private void initializeAllMenuItems() {
        // Appetizers (items 1-4)
        allMenuItems.add(new MenuItem("Fried Calamari", 9, 1));
        allMenuItems.add(new MenuItem("Mozzarella Sticks", 8, 2));
        allMenuItems.add(new MenuItem("Garlic Bread", 6, 3));
        allMenuItems.add(new MenuItem("Bruschetta", 7, 4));
        
        // Entrees (items 5-9)
        allMenuItems.add(new MenuItem("Spaghetti Bolognese", 18, 5));
        allMenuItems.add(new MenuItem("Chicken Marsala", 22, 6));
        allMenuItems.add(new MenuItem("Chicken Parmesean", 22, 7));
        allMenuItems.add(new MenuItem("Meat Lovers Pizza", 16, 8));
        allMenuItems.add(new MenuItem("Napoli Calzone", 12, 9));
        
        // Desserts (items 10-13)
        allMenuItems.add(new MenuItem("Tiramisu", 8, 10));
        allMenuItems.add(new MenuItem("Panna Cotta", 9, 11));
        allMenuItems.add(new MenuItem("Gelato Sundae", 7, 12));
        allMenuItems.add(new MenuItem("Cannoli", 6, 13));
    }

    //gets the name from a passed order number from order item number
    public String getName(int order_inumber){
        for (MenuItem item : allMenuItems) {
            if(item.item_number == order_inumber){
                return item.name;
            }
        }
        return "No item associated with that item number";
    }

    //returns price from passes inum
    public double getPrice(int order_inumber){
        for (MenuItem item : allMenuItems) {
            if(item.item_number == order_inumber){
                return item.price;
            }
        }
        return -1;
    }

    public Menu getMenu(){
        return menu;
    }

    public Orders getOrders(){
        return orders;
    }

    public Table getTable(){
        return tab;
    }
}
