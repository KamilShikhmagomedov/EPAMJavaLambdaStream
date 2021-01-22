package Ch6_Collectors;

import Ch3_Migration7to8.Info.Employee;

import java.util.List;
import java.util.stream.Collectors;
import static Ch3_Migration7to8.NewEnterpriseCode.hireFourEmployees;

public class Ex5_Joining {
    public static void main(String[] args) {

        final List<Employee> employees = hireFourEmployees();
        String names = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining());

        String  delimitedNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining("# "));

        String  prefixedNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(" $ ", "Our interns: ",  ". Pay them!"));

        System.out.println("Joined names:  "  + names);
        System.out.println("Joined,  delimited names:  "  + delimitedNames);
        System.out.println(prefixedNames);
    }
}
