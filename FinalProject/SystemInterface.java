public class SystemInterface{

    public static void DisplayMenu(){
        Invoker remote = new Invoker();
        Menu menu = new Menu();
        DisplayMenuCommand dispMenu = new DisplayMenuCommand(menu);

        remote.setCommand(dispMenu);
        remote.buttonPress();
    }
}