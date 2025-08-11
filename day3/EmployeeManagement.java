package day3;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class EmployeeManagement {

    private static final List<Employee> employees = new CopyOnWriteArrayList<>();
    public static void main(String[] args){

        //creating
        Employee e1 = new Employee.Builder()
                .setName("Jeevan")
                .setAge(22)
                .setDept("Development")
                .setSalary(25000)
                .setManager("Alice")
                .build();

        Employee e2 = new Employee.Builder()
                .setName("Ravi")
                .setAge(28)
                .setDept("Testing")
                .setSalary(30000)
                .setManager("Alice")
                .build();

        Manager manager = (Manager) new Manager.Builder()
                .setName("Alice")
                .setAge(35)
                .setDept("Development")
                .setSalary(50000)
                .build();

        manager.addEmployee(e1);
        manager.addEmployee(e2);

        employees.add(manager);
        employees.add(e1);
        employees.add(e2);

//reading
        System.out.println("All Employees:");
        employees.stream()
                .map(emp->emp.getName()+"-"+emp.getDept()+"-"+emp.getAge()+"-"+emp.getSalary()+"-"+emp.getManager())
                        .forEach(System.out::println);

        //delete
        employees.removeIf(emp->emp.getName().equalsIgnoreCase("jeevan"));
        System.out.println("Employees after deletion:");
        employees.stream()
                .map(emp->emp.getName()+"-"+emp.getDept())
                .forEach(System.out::println);


//updating
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable salaryUpdater = ()->employees.stream()
                .filter(e->e.getDept().equalsIgnoreCase("development"))
                        .forEach(e->{
                            double updatedSalary = e.getSalary()+2000;
                            System.out.println("Updated salary for"+e.getName()+":"+updatedSalary);
                        });
//this is because without the completion of update salary other things were getting executed
        Future<?> future =executorService.submit(salaryUpdater);
        executorService.shutdown();
        try{
            future.get();
        }catch (InterruptedException | ExecutionException exception){
            System.err.println("Error updating salaries:"+ exception.getMessage());
        }


//optionals and exception handling is demonstrated:
        System.out.println("\n manager details");
        employees.forEach(e->{
            try{
                String mgr = e.getManager().orElse("No Manager");
                System.out.println(e.getName()+"'s Manager:" +mgr);
            }catch (Exception exp){
                System.out.println("Error for employee:"+e.getName());
            }
                });



//grouping
        System.out.println("\n Grouped by Department:");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept))
                .forEach((dept,emp)->{
                    System.out.println(dept+":");
                    emp.forEach(emps->System.out.println(" "+emps.getName()));

                });
    }
}