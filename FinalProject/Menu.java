
import java.util.ArrayList;

public class Menu {
    private MenuStrategy strategy;
    protected ArrayList<MenuItem> menu_items = new ArrayList<>();

    public Menu(){
        strategy = new AppetizerMenu();
        menu_items = strategy.getMenuItems();
    }

    public void setMenuStrategy(MenuStrategy newStrategy) {
        strategy = newStrategy;
        menu_items = strategy.getMenuItems();
    }

    public void display(){  
        strategy.display();
    }

    public String getCurrentMenuName() {
        return strategy.getMenuName();
    }
}
