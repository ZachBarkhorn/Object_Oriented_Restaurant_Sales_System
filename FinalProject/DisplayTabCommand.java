public class DisplayTabCommand implements CommandInterface {
    Table tab;
    
    public DisplayTabCommand(Table arg_tab){
        tab = arg_tab;
    }

    public void execute(){
        tab.display();
    }
}
