package Ch6_Collectors;

import Ch3_Migration7to8.Info.Department;
import Ch3_Migration7to8.Info.Employee;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static Ch3_Migration7to8.NewEnterpriseCode.hireFourEmployees;

public class Ex1_CollectToList {
    public static void main(String[] args) {
        List<Employee> employees = hireFourEmployees();

        List<Object> list = employees.stream().filter(e -> e.getLevel() > 2).map(Employee::getDepartment)
                .sorted(Comparator.comparing(Department::getName)).distinct().collect(Collectors.toList());

        System.out.println(list.getClass());
        list.forEach(System.out::println);

        List departmentNames2 = employees.stream()
                .filter(e -> e.getLevel() > 2)
                .map(Employee::getDepartment)
                .distinct()
                .sorted(Comparator.comparing(Department::getName))
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println(departmentNames2.getClass());
        departmentNames2.forEach(System.out::println);


    }
}
