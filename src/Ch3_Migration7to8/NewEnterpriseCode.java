package Ch3_Migration7to8;

import Ch3_Migration7to8.Info.Department;
import Ch3_Migration7to8.Info.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NewEnterpriseCode {
    public static void main(String[] args) {
        List<Employee> list = hireFourEmployees();

        list.stream().filter(e -> e.getLevel() > 2).map(Employee::getDepartment).distinct().sorted(Comparator.comparing(Department::getName)).forEach(System.out::println);
        System.out.println("Average age is - " + list.stream().mapToInt(Employee::getAge).average().getAsDouble());
    }

    public static List<Employee> hireFourEmployees() {

        Department financialDepartment = new Department("Financial");
        Department mobileDepartment = new Department("Mobile");

        return Arrays.asList(
                new Employee(18, "Petr", "Java", 1, financialDepartment),
                new Employee(25, "Olga", ".NET", 3, financialDepartment),
                new Employee(38, "John", "Delphi", 4, mobileDepartment),
                new Employee(43, "Sergey", "Java", 4, mobileDepartment));
    }
}