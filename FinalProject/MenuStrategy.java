import java.util.ArrayList;

public interface MenuStrategy {
    ArrayList<MenuItem> getMenuItems();
    String getMenuName();
    void display();
}

