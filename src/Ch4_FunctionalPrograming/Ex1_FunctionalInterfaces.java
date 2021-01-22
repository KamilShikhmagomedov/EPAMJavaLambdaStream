package Ch4_FunctionalPrograming;

import Ch3_Migration7to8.Info.Department;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex1_FunctionalInterfaces {
    public static void main(String[] args) {
        Predicate<Integer> isPrime = Ex1_FunctionalInterfaces::isEven;

        Consumer<Integer> messageConsumer = m -> System.out.println("Вывожу числа " + m);

        Function<String, Department> someConstructor = Department::new;

        Function<Integer, Integer> addtwo = a -> a + 2;

        System.out.println(addtwo.apply(3));

        Supplier<Boolean> randomBoolean = () -> ThreadLocalRandom.current().nextBoolean();

        System.out.println(randomBoolean.get());

        Arrays.asList(1, 5, 32, 523, 52).stream().map(addtwo).filter(isPrime).forEach(messageConsumer);
    }

    private static boolean isEven(Integer number) {
        if(number % 2 == 0) {
            return  true;
        }
        return false;
    }
}
