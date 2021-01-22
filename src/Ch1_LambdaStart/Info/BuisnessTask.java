package Ch1_LambdaStart.Info;

@FunctionalInterface
public interface BuisnessTask {
    void updateStateInDB();

    default void updateStateInDBByDefault() {
        System.out.println("I'm non-abstract method in interface!!!");
    }
}
