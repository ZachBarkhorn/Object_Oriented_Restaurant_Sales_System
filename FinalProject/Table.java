import java.util.ArrayList;

public class Table {
    private ArrayList<TableObserver> observers = new ArrayList<>();
    private int table_number;
    private boolean isOccupied = false;

    protected ArrayList<String> tab_items = new ArrayList<>();
    private Aggregator aggregator = new Aggregator(this);
    private double total = 0;
    
    
    public Table(int tbl_num){
        table_number = tbl_num;
    }

    public boolean isOccupied(){
        return isOccupied;
    }

    public void setOccupied(boolean occupied){
        isOccupied = occupied;
        notifyObservers();
    }

    public int getTableNumber(){
        return table_number;
    }

    public double getTotalPrice(){
        return total;
    }

    public Aggregator getAggregator(){
        return aggregator;
    }

    public void addToTab(ArrayList<OrderItem> order_items){
        //take item number and convert it into the name and price of the item
        for (OrderItem item : order_items) {            
            String name = aggregator.getName(item.item_number);
            double price = aggregator.getPrice(item.item_number);
            tab_items.add(item.amount_ordered + "x " + name + " $" 
                + String.format("%.2f", price * item.amount_ordered) + "\n");
            total += (price * item.amount_ordered);
        }
        // Notify observers only once per submission, not per item
        notifyObservers();
    }
   

    public void display(){
        System.out.println("----------------------");
        System.out.println("\tCheck");
        System.out.println("----------------------");
        for (String item : tab_items) {            
            System.out.println(item);
        }
        System.out.println("----------------------");
        System.out.printf("Total: $%.2f\n", total);
        System.out.println("     Thank You!");
    }    


    public void registerObserver(TableObserver observer){
        observers.add(observer);
    }

    public void removeObserver(TableObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for (TableObserver observer : observers) {
            observer.update(this);
        }
    }
}
