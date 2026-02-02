public class DisplayMenuCommand implements CommandInterface {
    Menu menu;
    
    public DisplayMenuCommand(Menu arg_menu){
        menu = arg_menu;
    }

    @Override
    public void execute(){
        menu.display();
    }
}
