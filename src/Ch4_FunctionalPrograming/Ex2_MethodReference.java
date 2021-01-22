package Ch4_FunctionalPrograming;

import Ch3_Migration7to8.Info.Department;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;

public class Ex2_MethodReference {
    public static void main(String[] args) {
        Function<String, Department> someConstructor = Department::new;

        Arrays.asList("Finansical", "Economical").stream().map(someConstructor).forEach(System.out::println);

        BiFunction<String, CharSequence, Boolean> contains = String::contains;

        System.out.println(contains.apply("Russia", "si"));

        final DoubleUnaryOperator doubleConsumer = Math::abs;

        System.out.println(doubleConsumer.applyAsDouble(-5));

        final Function<Department, String> getName = Department::getName;

        System.out.println(getName.apply(someConstructor.apply("Bla bla")));

        Function<List<Integer>, Integer> maxElemLambda = (numbers) -> Collections.max(numbers);

        List<Integer> collectionList = Arrays.asList(1, 234, 53, 234, 4234, 13);
        System.out.println(maxElemLambda.apply(collectionList));
    }
}
