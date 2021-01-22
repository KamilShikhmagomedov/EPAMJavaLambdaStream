package Ch1_LambdaStart;
import Ch1_LambdaStart.Info.BusinessTaskUpdateCustomerAgeOnThread;

public class Ex1_ThreadTask {
    public static void main(String[] args) {
        BusinessTaskUpdateCustomerAgeOnThread businessTask1 = new BusinessTaskUpdateCustomerAgeOnThread();
        BusinessTaskUpdateCustomerAgeOnThread businessTask2 = new BusinessTaskUpdateCustomerAgeOnThread();

        businessTask1.start();
        businessTask2.start();
        businessTask2.updateStateInDB();
        businessTask2.run();
    }
}