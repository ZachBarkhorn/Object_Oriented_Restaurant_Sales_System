public class Invoker {
    CommandInterface action;

    public Invoker(){}

    public void setCommand(CommandInterface command){
        action = command;
    }

    public void buttonPress(){
        action.execute();
    }
}
