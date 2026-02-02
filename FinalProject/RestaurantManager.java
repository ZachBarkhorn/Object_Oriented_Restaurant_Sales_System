import java.util.ArrayList;

public class RestaurantManager implements TableObserver {
    private ArrayList<Table> tables = new ArrayList<>();
    private int nextTableNumber = 1;
    
    // Seat a new table
    public Table seatTable() {
        Table newTable = new Table(nextTableNumber++);
        newTable.setOccupied(true);  // Mark as occupied
        tables.add(newTable);
        newTable.registerObserver(this);  // Register manager as observer
        System.out.println("[MANAGER] Table " + newTable.getTableNumber() + " has been seated.");
        return newTable;
    }
    
    // Called automatically when ANY table calls notifyObservers()
    @Override
    public void update(Table table) {
        System.out.println("[MANAGER ALERT] Table " + table.getTableNumber() + 
            " submitted an order! Current bill: $" + String.format("%.2f", table.getTotalPrice()));
    }

    // Get all active tables
    public ArrayList<Table> getActiveTables() {
        return tables;
    }
    
    // Find next available table for new guests
    public Table findAvailableTable() {
        for (Table table : tables) {
            if (!table.isOccupied()) {  // Find first unoccupied table
                return table;
            }
        }
        return null;  // No tables available
    }
    
    // Calculate total revenue from all tables
    public double getTotalRevenue() {
        double total = 0;
        for (Table table : tables) {
            total += table.getTotalPrice();
        }
        return total;
    }
    
    // Display status of all tables
    public void printTableStatus() {
        System.out.println("\n========== TABLE STATUS ==========");
        for (Table table : tables) {
            String status;
            if (table.isOccupied()) {
                status = "OCCUPIED";
            } else {
                status = "AVAILABLE";
            }
            System.out.println("Table " + table.getTableNumber() + " - " + status + 
                " - Current bill: $" + String.format("%.2f", table.getTotalPrice()));
        }
        System.out.println("Total Restaurant Revenue: $" + String.format("%.2f", getTotalRevenue()));
        System.out.println("==================================\n");
    }
}