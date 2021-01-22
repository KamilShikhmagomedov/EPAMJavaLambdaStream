package Ch5_StreamOperations;

import java.util.stream.Stream;

import static java.util.stream.Collectors.summingInt;

public class Ex3_HardPathToSumReducePower {
    public static void main(String[] args) {
        Stream<Integer> ints = Stream.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17);
        int [] sumResult = {0};
//        ints.forEach(e -> sumResult[0] += e);
//        System.out.println(sumResult[0]);

//        ints.parallel().forEach(e -> sumResult[0] += e);
//        System.out.println(sumResult[0]);

        System.out.println(ints.reduce(0, Integer::sum));

        System.out.println(ints.mapToInt(i -> i).sum());

        System.out.println((Integer) ints.mapToInt(Integer::intValue).sum());
        System.out.println(ints.reduce(0, Integer::sum));
        System.out.println((Integer) ints.mapToInt(Integer::intValue).sum());
    }



}
