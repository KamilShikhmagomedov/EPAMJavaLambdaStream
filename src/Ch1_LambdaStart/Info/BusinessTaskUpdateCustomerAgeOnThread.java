package Ch1_LambdaStart.Info;

public class BusinessTaskUpdateCustomerAgeOnThread extends Thread implements BuisnessTask {
    @Override
    public void run(){
        try {
            updateStateInDB();
            Thread.sleep(1000);
            System.out.println("Massive updates");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateStateInDB() {
        System.out.println("We are read StateFromDB" );
    }
}
