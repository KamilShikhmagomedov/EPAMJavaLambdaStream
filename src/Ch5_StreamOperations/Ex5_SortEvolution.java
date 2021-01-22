package Ch5_StreamOperations;

import Ch3_Migration7to8.Info.Employee;
import Ch3_Migration7to8.NewEnterpriseCode;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex5_SortEvolution {
    public static void main(String[] args) {
        List<Employee> employees = NewEnterpriseCode.hireFourEmployees();
        employees.forEach(System.out::println);

        System.out.println("Sorting by skill level");
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getLevel() - o1.getLevel();
            }
        };
        Collections.sort(employees, comparator);
        employees.forEach(System.out::println);

        System.out.println("Sorting by age");
        Comparator<Employee> comp = ((o1, o2) -> o2.getAge()-o1.getAge());
        Collections.sort(employees, comp);
        employees.forEach(System.out::println);

        System.out.println("Sorting by skill in reverse order");
        Comparator<Employee> bySkillReversed = Comparator.comparing(Employee::getSkill).reversed();
        Collections.sort(employees, bySkillReversed);
        employees.forEach(System.out::println);

        System.out.println("Complex sorting: by level and by name");
        employees.sort(Comparator.comparing(Employee::getLevel).thenComparing(Employee::getName));
        employees.forEach(System.out::println);
    }
}
