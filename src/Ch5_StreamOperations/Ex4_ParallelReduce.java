package Ch5_StreamOperations;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex4_ParallelReduce {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1, 10);
        int sum = 0;
//        sum = intStream.parallel().reduce(0, (partialSum, newNumber) -> {
//            System.out.println("Partial sum is " + partialSum + " new number is " + newNumber + " calculated in Thread " + Thread.currentThread().getName());
//            return partialSum + newNumber;
//        });
//        System.out.println(sum);

        Stream<String> stream = Stream.of("I", "the", "love", "and", "house", "wife", "dog", "cat", "hate", "eat", "build");
        BiFunction<String, String, String> partialJoin = (partialString, newString) -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("PS = " + partialString + " ELEM = " + newString + " BY " + Thread.currentThread().getName());
            return String.join(" ", partialString, newString);
        };

        BinaryOperator<String> threadJoin = (firstString, secondString) -> {

            System.out.println(firstString + " vs " + secondString + " BY " + Thread.currentThread().getName());

            if(firstString.length() == secondString.length())
                return String.join(" ", firstString, secondString);
            else if(firstString.length() > secondString.length())
                return firstString;
            return secondString;
        };
        String result = stream.parallel().reduce("#Wow# ", partialJoin, threadJoin);
        System.out.println(result);
    }
}
