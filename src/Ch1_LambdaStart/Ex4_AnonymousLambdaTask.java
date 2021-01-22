package Ch1_LambdaStart;

import Ch1_LambdaStart.Info.BuisnessTaskUpdateCustomerAge;

public class Ex4_AnonymousLambdaTask {
    public static void main(String[] args) {
        executeTwoTasks(() -> {
            try {
                new BuisnessTaskUpdateCustomerAge().updateStateInDB();
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
