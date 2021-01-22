package Ch1_LambdaStart;

import Ch1_LambdaStart.Info.BuisnessTask;
import Ch1_LambdaStart.Info.BuisnessTaskUpdateCustomerAge;

public class Ex5_AnonymousLambdaWithDefaultMethodTask {
    public static void main(String[] args) {
     executeTwoTasks(() -> {
         try {
             ((BuisnessTask) () -> {
                 System.out.println("Bla bla");
             }).updateStateInDB();
             new BuisnessTaskUpdateCustomerAge().updateStateInDBByDefault();
             Thread.sleep(1000);
             System.out.println("Massive updates");
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

     });
    }

    private static void executeTwoTasks(Runnable threadLogic) {
        new Thread(threadLogic).start();
        new Thread(threadLogic).start();
    }
}
