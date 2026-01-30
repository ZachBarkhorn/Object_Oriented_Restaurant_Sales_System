

public class UserInterface {
    public static void main(String[] args) {
        SystemInterface.DisplayMenu();

        Aggregator agg = new Aggregator();
        System.out.println(agg.getName(3));
        System.out.println(agg.getPrice(3));

    }
}
