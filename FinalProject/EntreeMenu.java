import java.util.ArrayList;

public class EntreeMenu implements MenuStrategy {
    private ArrayList<MenuItem> entrees = new ArrayList<>();
    
    public EntreeMenu() {
        entrees.add(new MenuItem("Spaghetti Bolognese", 18, 5));
        entrees.add(new MenuItem("Chicken Marsala", 22, 6));
        entrees.add(new MenuItem("Chicken Parmesean", 22, 7));
        entrees.add(new MenuItem("Meat Lovers Pizza", 16, 8));
        entrees.add(new MenuItem("Napoli Calzone", 12, 9));
    }
    
    @Override
    public ArrayList<MenuItem> getMenuItems() {
        return entrees;
    }
    
    @Override
    public String getMenuName() {
        return "ENTREES";
    }
    
    @Override
    public void display() {
        System.out.println("\t" + getMenuName());
        System.out.println("-----------------------");
        for (MenuItem item : entrees) {
            System.out.println(item.item_number + ") " + item.name + " $" + item.price);
        }
        System.out.println("-----------------------");
    }
}