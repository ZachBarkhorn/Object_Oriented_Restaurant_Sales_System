import java.util.ArrayList;

public class Orders {
    protected ArrayList<OrderItem> order_items = new ArrayList<>();
    Table tab;        //creates a new instance of tab class. Only orders will interact with tab.

    //creates order capabilities by passing a tab to order to.
    public Orders(Table arg_tab){
        tab = arg_tab;
    }

    //takes a item number from user and adds item to ordered items list
    public void add(int inum){
        if(!searchAndAdd(inum)){
            order_items.add(new OrderItem(inum));
        }        
    }

    //searches through existing order items to see if item already exists
    private boolean searchAndAdd(int inum){
        for (OrderItem item : order_items) {
            if(item.item_number == inum){
                item.addOne();
                return true;
            }
        }
        return false;
    }

    public void submit(){
        //take a field (tbd) that indicates what item will be ordered. Say a number which corresponds to the item number then sent to the tab class
        //The tab class will use the aggregator to obtain the data from menu class then add to the string arraylist of what was ordered so far
        submit_helper(order_items);  // i need the orders to contain actually ordered items      
    }

    private void submit_helper(ArrayList<OrderItem> order_items){
        tab.addToTab(order_items);
        order_items.clear();        //clear in case more orders come so duplicates are not added to tab
    }
}
