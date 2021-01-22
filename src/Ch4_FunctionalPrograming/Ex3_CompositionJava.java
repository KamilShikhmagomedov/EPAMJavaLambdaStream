package Ch4_FunctionalPrograming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Ex3_CompositionJava {
    public static void main(String[] args) {
        List<Integer> fibonacciNumbers = Arrays.asList(1,1,2,3,5,8,13,21);
        fibonacciNumbers.stream().map(e -> e + 1).forEach(System.out::println);

        Function<Integer, Integer> addOne = e -> e + 1;
        fibonacciNumbers.stream().map(addOne).forEach(System.out::println);

        Function<Integer, Integer> multiplyTen = e -> e * 10;
        fibonacciNumbers.stream().map(addOne.andThen(multiplyTen)).forEach(System.out::println);

        fibonacciNumbers.stream().map(addOne.compose(e-> e*10)).forEach(System.out::println);
        fibonacciNumbers.stream().map(compose(addOne, multiplyTen)).forEach(System.out::println);

    }

    public static Function<Integer, Integer> compose(Function<Integer, Integer> f, Function<Integer, Integer> g){
        return x -> f.apply(g.apply(x));
    }

}
