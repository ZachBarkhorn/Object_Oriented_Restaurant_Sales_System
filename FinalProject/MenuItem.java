public class MenuItem {
    protected String name;
    protected double price;
    protected String description;
    protected int item_number;

    public MenuItem(String arg_name, double arg_price, String arg_description, int arg_min){
        name = arg_name;
        price = arg_price;
        description = arg_description;
        item_number = arg_min;
    }

}
