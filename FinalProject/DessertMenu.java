import java.util.ArrayList;

public class DessertMenu implements MenuStrategy {
    private ArrayList<MenuItem> desserts = new ArrayList<>();
    
    public DessertMenu() {
        desserts.add(new MenuItem("Tiramisu", 8, 10));
        desserts.add(new MenuItem("Panna Cotta", 9, 11));
        desserts.add(new MenuItem("Gelato Sundae", 7, 12));
        desserts.add(new MenuItem("Cannoli", 6, 13));
    }
    
    @Override
    public ArrayList<MenuItem> getMenuItems() {
        return desserts;
    }
    
    @Override
    public String getMenuName() {
        return "DESSERTS";
    }
    
    @Override
    public void display() {
        System.out.println("\t" + getMenuName());
        System.out.println("-----------------------");
        for (MenuItem item : desserts) {
            System.out.println(item.item_number + ") " + item.name + " $" + item.price);
        }
        System.out.println("-----------------------");
    }
}