import java.util.Scanner;

// Main UI - handles all the restaurant service flow
// Shows off the Command, Observer, and Strategy patterns in action
public class UserInterface {
    public static void main(String[] args) {
        
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║   Welcome to the Automated Italian Restaurant!     ║");
        System.out.println("║        Your host today will be me, your digital    ║");
        System.out.println("║                    digital server.                 ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");

        // Set up the manager - it'll watch all the tables and track what's happening
        // (Observer Pattern: manager observes all tables)
        RestaurantManager manager = new RestaurantManager();
        
        // Create 3 tables - each one has its own Menu, Orders, and Tab (bill)
        Table table1 = new Table(1);
        Table table2 = new Table(2);
        Table table3 = new Table(3);
        
        // Add them to the manager so it knows about them
        manager.getActiveTables().add(table1);
        manager.getActiveTables().add(table2);
        manager.getActiveTables().add(table3);
        
        // Tell each table to notify the manager when something happens
        // (orders submitted, table becomes free, etc.)
        table1.registerObserver(manager);
        table2.registerObserver(manager);
        table3.registerObserver(manager);
        
        System.out.println("[RESTAURANT OPENING] 3 tables available for seating.\n");

        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("════════════════════════════════════════════════════");
        System.out.println("DEMONSTRATING OBSERVER PATTERN - Multi-Table Service");
        System.out.println("════════════════════════════════════════════════════\n");
        
        // Seat table 1, take their order, print their bill
        System.out.println(">>> SEATING TABLE 1 <<<");
        table1.setOccupied(true);  // Manager gets notified
        serveTable(table1, keyboard, manager);
        table1.setOccupied(false); // Manager gets notified again
        
        // Check which tables are free now
        System.out.println("\n[RESTAURANT STATUS] Checking available tables...");
        Table nextAvailable = manager.findAvailableTable();
        if (nextAvailable != null) {
            System.out.println("[MANAGER] Table " + nextAvailable.getTableNumber() + " is available for new guests!\n");
        }
        
        // Do it all again for table 2
        System.out.println(">>> SEATING TABLE 2 <<<");
        table2.setOccupied(true);
        serveTable(table2, keyboard, manager);
        table2.setOccupied(false);
        
        // And table 3
        System.out.println("\n>>> SEATING TABLE 3 <<<");
        table3.setOccupied(true);
        serveTable(table3, keyboard, manager);
        table3.setOccupied(false);
        
        // Show what happened across all tables
        System.out.println("\n════════════════════════════════════════════════════");
        System.out.println("END OF SERVICE - FINAL RESTAURANT STATUS");
        System.out.println("════════════════════════════════════════════════════");
        manager.printTableStatus();  // Shows total sales and table statuses
        
        keyboard.close();
    }//end main

    // Takes one table through the whole dining experience
    // Appetizers -> Entrees -> Desserts -> Bill
    // (Strategy Pattern: menu type switches between each course)
    public static void serveTable(Table table, Scanner keyboard, RestaurantManager manager) {
        // Aggregator is like the "hub" that connects the Table to Menu and Orders
        // It knows the prices, item names, and can keep track of what's ordered
        Aggregator agg = table.getAggregator();
        Menu menu = agg.getMenu();
        
        System.out.println("\n┌─ DEMONSTRATING STRATEGY PATTERN - Multi-Menu Selection ─┐");
        System.out.println("│ This table will order from: Appetizers → Entrees → Desserts");
        System.out.println("└──────────────────────────────────────────────────────────┘\n");
        
        // APPETIZERS ROUND - items 1-4
        System.out.println(">>> APPETIZERS <<<");
        menu.setMenuStrategy(new AppetizerMenu());  // Switch menu to appetizers
        SystemInterface.DisplayMenu(agg);           // Show the menu (Command Pattern)
        System.out.println("To order, please enter the item number (1-4) associated with the food item.");
        int order_num = getValidatedMenuInput(keyboard, 1, 4);
        
        // Let them add as many appetizers as they want
        if (order_num != -1) {
            collectOrderItems(order_num, keyboard, agg, 1, 4);
        }
        
        // ENTREES ROUND - items 5-9
        System.out.println("\n>>> ENTREES <<<");
        menu.setMenuStrategy(new EntreeMenu());     // Switch to entree menu
        System.out.println("\nWould you like to add an entree? (Press item number 5-9, or -1 to skip)");
        SystemInterface.DisplayMenu(agg);           // Show the menu
        order_num = getValidatedMenuInput(keyboard, 5, 9);
        
        // Let them add multiple entrees if they want
        if (order_num >= 5 && order_num <= 9) {
            collectOrderItems(order_num, keyboard, agg, 5, 9);
        }
        
        // DESSERTS ROUND - items 10-13
        System.out.println("\n>>> DESSERTS <<<");
        menu.setMenuStrategy(new DessertMenu());    // Switch to dessert menu
        System.out.println("\nWould you like to add a dessert? (Press item number 10-13, or -1 to skip)");
        SystemInterface.DisplayMenu(agg);           // Show the menu
        order_num = getValidatedMenuInput(keyboard, 10, 13);
        
        // Let them add multiple desserts
        if (order_num >= 10 && order_num <= 13) {
            collectOrderItems(order_num, keyboard, agg, 10, 13);
        }
        
        // All items from all 3 courses are ready - send to kitchen
        // (Manager gets notified here - Observer Pattern kicks in)
        System.out.println("\nSubmitting complete order to kitchen...\n");
        SystemInterface.SubmitOrder(agg);  // Submit command (Command Pattern)
        
        // Print out the final bill with everything they ordered
        System.out.println("\n┌─ FINAL CHECK FOR TABLE " + table.getTableNumber() + " ─┐");
        SystemInterface.DisplayTab(agg);   // Display the bill (Command Pattern)
        System.out.println("└─ Table " + table.getTableNumber() + " payment complete. ─┘");
    }

    // Makes sure the user enters valid numbers for the current menu
    // If they enter something outside the range, keep asking until they get it right
    public static int getValidatedMenuInput(Scanner keyboard, int minRange, int maxRange){
        int num = keyboard.nextInt();
        while(num < minRange || num > maxRange ){
            if(num == -1){  // -1 means skip this course
                System.out.println("Skipping this course...\n");
                return num;
            }
            System.out.println("Error, invalid input. Please enter a value from " + minRange + "-" + maxRange + ".");
            num = keyboard.nextInt();
        }
        return num;
    }

    // Loops through collecting multiple items from one menu
    // Person picks first item, then we ask if they want more from same menu
    // All items pile up in the Orders object until we submit the whole thing
    public static void collectOrderItems(int initialSelection, Scanner keyboard, Aggregator agg, int minRange, int maxRange){
        int itemSelection = initialSelection;
        while(itemSelection != -1){            
            // Add this item to the Orders list (tracks quantity if they order the same thing twice)
            Orders orders = agg.getOrders();
            orders.add(itemSelection);
            System.out.println("To continue your order, please enter another number associated with the menu item you would like.\n"
                            + "Otherwise, enter \"-1\" to move to the next course!");
            // Loop - let them keep adding more
            itemSelection = getValidatedMenuInput(keyboard, minRange, maxRange);
        } 
    }
}
