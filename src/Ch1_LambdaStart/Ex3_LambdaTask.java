package Ch1_LambdaStart;

import Ch1_LambdaStart.Info.BuisnessTaskUpdateCustomerAge;

public class Ex3_LambdaTask {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                new BuisnessTaskUpdateCustomerAge().updateStateInDB();
                Thread.sleep(1000);
                System.out.println("Massive updates");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        execute(task);
        execute(task);
    }

    public static void execute(Runnable runnable){
        new Thread(runnable).start();
    }
}