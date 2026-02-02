public class SubmitOrderCommand implements CommandInterface {
    Orders order;

    public SubmitOrderCommand(Orders arg_order){
        order = arg_order;
    }

    public void execute(){
        order.submit();
    }
}
