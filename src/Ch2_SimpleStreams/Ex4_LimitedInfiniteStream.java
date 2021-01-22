package Ch2_SimpleStreams;

import java.util.stream.IntStream;

public class Ex4_LimitedInfiniteStream {
    public static void main(String[] args) {
        IntStream.iterate(0, i -> i+1).limit(8).forEach(s -> {
            try {
                Thread.sleep(1000);
                System.out.println(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
