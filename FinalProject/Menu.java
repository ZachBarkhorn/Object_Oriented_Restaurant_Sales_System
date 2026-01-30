
import java.util.ArrayList;

public class Menu {
    protected ArrayList<MenuItem> menu_items = new ArrayList<>();

    public Menu(){
        menu_items.add(new MenuItem("Roast Beef",15.99,
             "Roast beef with potatoes and gravy",001));
        menu_items.add(new MenuItem("Chicken Korma",13.99,
            "yummy yummy in my tummy tummy",002));
        menu_items.add(new MenuItem("Jiaozi",17.99,
            "I don't even know what this is",003));
    }

    public void display(){  
        int x = 1;
        for (MenuItem item : menu_items) {            
            System.out.println(x + ") " + item.name + " $" + item.price);
            System.out.println("\t" + item.description);
            x++;
        }
    }
}
