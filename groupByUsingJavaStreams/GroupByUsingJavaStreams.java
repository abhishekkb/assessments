import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByUsingJavaStreams {

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("dept1", "name1"),
                new Employee("dept2", "name2"),
                new Employee("dept2", "name3"),
                new Employee("dept1", "name4"),
                new Employee("dept1", "name5"),
                new Employee("dept3", "name6"),
                new Employee("dept3", "name7"),
                new Employee("dept3", "name8")
        );

        Map<String, List<Employee>> m = new HashMap<>();

        employees.forEach(e -> {
            List<Employee> o = m.get(e.dept);

            if(o != null){
              o.add(e);
            } else {
              o = new ArrayList<>();
              o.add(e);
              m.put(e.dept, o);
            }
        });

        Map<String, List<Employee>> m2 = employees.stream().collect(Collectors.groupingBy(Employee::getDept));

//        System.out.println(m);
//        System.out.println(m2);

//        m.forEach((key, value) -> System.out.printf("dept: %s, employees :%s \n ", key, value.stream().collect(Collectors.joining(",", "[", "]"))));

        System.out.println(m.entrySet().stream().map(entry -> entry.getKey() + "::" + entry.getValue().toString()).collect(Collectors.joining("\n", "", "")));

        System.out.println("====================");

        System.out.println(m2.entrySet().stream().map(entry -> entry.getKey() + "::" + entry.getValue().toString()).collect(Collectors.joining("\n", "", "")));
//        m2.forEach((key, value) -> System.out.printf("dept: %s, employees :%s \n ", key, value.stream().collect(Collectors.joining(",", "[", "]"))));

    }

//    {
//        dept1: [emp1, emp2]
//        dept2: [emp4, emp3]
//    }

/**
output
**
{dept1=[Employee{dept='dept1', name='name1'}, Employee{dept='dept1', name='name4'}, Employee{dept='dept1', name='name5'}], dept2=[Employee{dept='dept2', name='name2'}, Employee{dept='dept2', name='name3'}], dept3=[Employee{dept='dept3', name='name6'}, Employee{dept='dept3', name='name7'}, Employee{dept='dept3', name='name8'}]}
{dept1=[Employee{dept='dept1', name='name1'}, Employee{dept='dept1', name='name4'}, Employee{dept='dept1', name='name5'}], dept2=[Employee{dept='dept2', name='name2'}, Employee{dept='dept2', name='name3'}], dept3=[Employee{dept='dept3', name='name6'}, Employee{dept='dept3', name='name7'}, Employee{dept='dept3', name='name8'}]}
dept1::[Employee{dept='dept1', name='name1'}, Employee{dept='dept1', name='name4'}, Employee{dept='dept1', name='name5'}]
dept2::[Employee{dept='dept2', name='name2'}, Employee{dept='dept2', name='name3'}]
dept3::[Employee{dept='dept3', name='name6'}, Employee{dept='dept3', name='name7'}, Employee{dept='dept3', name='name8'}]
====================
dept1::[Employee{dept='dept1', name='name1'}, Employee{dept='dept1', name='name4'}, Employee{dept='dept1', name='name5'}]
dept2::[Employee{dept='dept2', name='name2'}, Employee{dept='dept2', name='name3'}]
dept3::[Employee{dept='dept3', name='name6'}, Employee{dept='dept3', name='name7'}, Employee{dept='dept3', name='name8'}]


  */

  
    public static class Employee{

        private String dept;
        private String name;

        public Employee(String dept, String name) {
            this.dept = dept;
            this.name = name;
        }

        public String getDept() {
            return dept;
        }

        public void setDept(String dept) {
            this.dept = dept;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "dept='" + dept + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
