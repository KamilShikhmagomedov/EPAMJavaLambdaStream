package Ch6_Collectors;

import Ch3_Migration7to8.Info.Department;
import Ch3_Migration7to8.Info.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static Ch3_Migration7to8.NewEnterpriseCode.hireFourEmployees;

public class Ex2_CollectToMap {
    public static void main(String[] args) {
        List<Employee> employees = hireFourEmployees();
        Map<String, Department> map = employees.stream().filter(e -> e.getLevel() > 2).
                sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toMap((Employee::getName),(Employee::getDepartment)));

        System.out.println(map.getClass());
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
