package Ch2_SimpleStreams;

import java.util.Arrays;

public class Ex5_SolutionSortedStream {
    public static void main(String[] args) {
        Arrays.asList(new Double(2), new Double(3) , 4.2, new Double(13), new Double(-1), new Double(3), 8.8).stream()
                .sorted().forEach(System.out::println);
    }
}
