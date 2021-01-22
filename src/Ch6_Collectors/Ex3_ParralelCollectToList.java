package Ch6_Collectors;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex3_ParralelCollectToList {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(0, 10001);

        BiConsumer<ArrayList<Integer>, ArrayList<Integer>> parallelCombiner = (integers, integers2) -> {
            integers.addAll(integers2.stream().filter(i -> i % 20 == 0).collect(Collectors.toList()));
            System.out.println("Parallel merge by " + Thread.currentThread().getName());
        };

        ArrayList<Integer> result = intStream
                .parallel()
                .map(i -> i * 10)
                .peek(e -> {
                    System.out.println(e + " handled by " + Thread.currentThread().getName());
                })
                .collect(ArrayList::new, ArrayList::add, parallelCombiner);


        System.out.println(result);
        System.out.println(result.size());
    }
}
