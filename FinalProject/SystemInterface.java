public class SystemInterface{

    public static void DisplayMenu(Aggregator agg){
        Invoker remote = new Invoker();
        Menu menu = agg.getMenu();
        DisplayMenuCommand dispMenu = new DisplayMenuCommand(menu);

        remote.setCommand(dispMenu);
        remote.buttonPress();
    }

    public static void SubmitOrder(Aggregator agg){
        Invoker remote2 = new Invoker();        
        Orders order = agg.getOrders();         //sends common order instance
        
        //sets instance for command to common that has been written to
        SubmitOrderCommand submOrder = new SubmitOrderCommand(order);

        //sets command to do submit order without coupling
        remote2.setCommand(submOrder);

        //executes command
        remote2.buttonPress();
    }

    public static void DisplayTab(Aggregator agg){
        Invoker remote3 = new Invoker();
        Table tab = agg.getTable();

        DisplayTabCommand dispTab = new DisplayTabCommand(tab);

        remote3.setCommand(dispTab);

        remote3.buttonPress();
    }
}