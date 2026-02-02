import java.util.ArrayList;

public class AppetizerMenu implements MenuStrategy {
    private ArrayList<MenuItem> appetizers = new ArrayList<>();
    
    public AppetizerMenu() {
        appetizers.add(new MenuItem("Fried Calamari", 9, 1));
        appetizers.add(new MenuItem("Mozzarella Sticks", 8, 2));
        appetizers.add(new MenuItem("Garlic Bread", 6, 3));
        appetizers.add(new MenuItem("Bruschetta", 7, 4));
    }
    
    @Override
    public ArrayList<MenuItem> getMenuItems() {
        return appetizers;
    }
    
    @Override
    public String getMenuName() {
        return "APPETIZERS";
    }
    
    @Override
    public void display() {
        System.out.println("\t" + getMenuName());
        System.out.println("-----------------------");
        for (MenuItem item : appetizers) {
            System.out.println(item.item_number + ") " + item.name + " $" + item.price);
        }
        System.out.println("-----------------------");
    }
}