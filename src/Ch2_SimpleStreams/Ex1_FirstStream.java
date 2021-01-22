package Ch2_SimpleStreams;

import java.util.Arrays;
import java.util.List;

public class Ex1_FirstStream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("usa", " RUSSIA ", "gerMANY", "JaPaN");

//        for (int i = 0; i < list.size(); i++) {
//            list.get(i);
//        }
//
//        for(String l : list){
//            System.out.println(l);
//        }

        list.forEach(System.out::println);

        list.stream().map(e -> e.toLowerCase().trim()).filter(s -> !s.contains("j")).forEach(System.out::println);
    }
}
