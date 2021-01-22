package Ch2_SimpleStreams;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ex2_LazyStream {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 5, 4).stream().filter(e -> e > 4).map(s -> 1);
        stream.forEach(System.out::println);
    }
}
