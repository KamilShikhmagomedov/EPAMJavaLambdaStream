package Ch1_LambdaStart.Info;

public class BuisnessTaskUpdateCustomerAge implements BuisnessTask {
    @Override
    public void updateStateInDB() {
        System.out.println("We are read StateFromDB" );
    }
    @Override
    public void updateStateInDBByDefault(){
        System.out.println("Yes, I've overridden that");
    }
}
