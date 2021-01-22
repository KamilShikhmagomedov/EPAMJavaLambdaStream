package Ch2_SimpleStreams;

import java.util.stream.IntStream;

public class Ex3_InfiniteStream {
    public static void main(String[] args) {
        IntStream.iterate(0, i -> i + 5).forEach(e -> {
            try {
                Thread.sleep(1000);
                System.out.println(e);
            } catch (InterruptedException s){
                s.printStackTrace();
            }
        });
    }
}
