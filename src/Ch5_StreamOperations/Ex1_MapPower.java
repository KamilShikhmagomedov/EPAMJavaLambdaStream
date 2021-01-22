package Ch5_StreamOperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex1_MapPower {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 13, 36, -3, 4, -9);

        list.stream().map(Math::abs).forEach(System.out::println);

        System.out.println(list.stream().mapToInt(Math::abs).max().getAsInt());

        System.out.println(list.stream().mapToDouble(Math::cos).summaryStatistics());
    }
}
