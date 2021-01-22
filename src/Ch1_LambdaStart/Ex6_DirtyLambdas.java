package Ch1_LambdaStart;

public class Ex6_DirtyLambdas {
    public static void main(String[] args) throws InterruptedException {
        double pi = 3.14;
//        Runnable task = () -> {
//          double rectification = 0.0015;
//            System.out.println("Result = " + (pi + rectification));
//        };
//        new Thread(task).start();

        // Here we have a problem
//        Runnable abnormalTask = () -> {
//            pi+= 0.0015;
//            System.out.println("Result " + pi);
//        };

        // Here we have a problem too
//        Runnable problemTask = () -> {
//            double rectification = 0.0015;
//            System.out.println("Result " + (pi + rectification));
//        };
//        Thread t = new Thread(problemTask);
//        t.start();
//        t.join();
//        pi+=0.000092;
//        System.out.println(pi);

        double fPi = pi;
        Runnable coolTask = () -> {
            double rectification = 0.0015;
            System.out.println("Result " + (fPi + rectification));
        };
        Thread t = new Thread(coolTask);
        t.start();
        t.join();
        pi+=0.000092;
        System.out.println(pi);
    }
}
