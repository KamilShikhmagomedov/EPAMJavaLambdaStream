package Ch5_StreamOperations;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Ex2_FlatMapPower {
    public static void main(String[] args) {
        Map<String,Integer> backendSkillMatrix = new HashMap<>();
        backendSkillMatrix.put("Java", 3);
        backendSkillMatrix.put("Scala", 2);
        backendSkillMatrix.put("Kotlin", 2);
        Developer backendDev = new Developer("Teodor", backendSkillMatrix);


        Map<String,Integer> frontendSkillMatrix = new HashMap<>();
        frontendSkillMatrix.put("React", 80);
        frontendSkillMatrix.put("Angular 10", 1);
        frontendSkillMatrix.put("Kotlin", 4);
        Developer frontendDev = new Developer("Dinesh", frontendSkillMatrix);


        List<Developer> projectTeam = new ArrayList<>();
        projectTeam.add(backendDev);
        projectTeam.add(frontendDev);

        List<String> result = projectTeam.stream().map(e -> e.getSkillMatrix().entrySet())
                .flatMap(Collection::stream).filter(i -> i.getValue() > 1).map(Map.Entry::getKey).distinct().collect(Collectors.toList());
        System.out.println(result);

        String[][] arrayOfArrays = {{"1", "2"}, {"3", "4"}, {"1", "4", "1"}};

        LongStream longStream = Arrays.stream(arrayOfArrays).flatMapToLong(innerArray -> Arrays.stream(innerArray)
                        .mapToLong(Long::new)).distinct();
        System.out.println(longStream.sum());

        Stream.of("Scala", "Java",  "Kotlin")
                .flatMap(name ->  IntStream.range(0, name.length())
                        .mapToObj(name::charAt))
                .forEach(System.out::println);
    }
}
