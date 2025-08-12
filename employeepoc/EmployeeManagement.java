package employeepoc;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class EmployeeManagement {

    private static final List<Employee> employees = new CopyOnWriteArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Employee Management System!\n");

        // Sample Data
        seedInitialData();

        boolean running = true;
        while (running) {
            printMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1 -> createEmployeeOrManager();
                case 2 -> displayAllEmployees();
                case 3 -> updateSalariesByDepartment();
                case 4 -> deleteEmployee();
                case 5 -> groupByDepartment();
                case 6 -> {
                    System.out.println("Exiting. Thank you!");
                    running = false;
                }
                default -> System.out.println(" Invalid option. Try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n MENU");
        System.out.println("1. Create Employee / Manager");
        System.out.println("2. View All Employees");
        System.out.println("3. Update Salary by Department");
        System.out.println("4. Delete Employee");
        System.out.println("5. Group Employees by Department");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void seedInitialData() {
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
    }

    private static void createEmployeeOrManager() {
        System.out.print("Is this a Manager? (yes/no): ");
        String isManager = scanner.nextLine().trim().toLowerCase();

        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Department: ");
        String dept = scanner.nextLine();
        System.out.print("Salary: ");
        double salary = Double.parseDouble(scanner.nextLine());

        if (isManager.equals("yes")) {
            Manager manager = (Manager) new Manager.Builder()
                    .setName(name)
                    .setAge(age)
                    .setDept(dept)
                    .setSalary(salary)
                    .build();
            employees.add(manager);
        } else {
            System.out.print("Manager Name (optional): ");
            String managerName = scanner.nextLine();
            Employee emp = new Employee.Builder()
                    .setName(name)
                    .setAge(age)
                    .setDept(dept)
                    .setSalary(salary)
                    .setManager(managerName.isEmpty() ? null : managerName)
                    .build();
            employees.add(emp);
        }

        System.out.println("Employee created successfully.");
    }

    private static void displayAllEmployees() {
        System.out.println("\nAll Employees:");
        employees.forEach(e -> {
            String managerName = e.getManager().orElse("No Manager");
            System.out.println(e.getName() + " - " + e.getDept() + " - " + e.getAge() + " - ₹" + e.getSalary() + " - Manager: " + managerName);
        });
    }

    private static void deleteEmployee() {
        System.out.print("Enter the name of the Employee to remove: ");
        String nameToDelete = scanner.nextLine();

        // Also remove from manager's internal list
        employees.stream()
                .filter(e -> e instanceof Manager)
                .map(e -> (Manager) e)
                .forEach(mgr -> mgr.removeEmployee(nameToDelete));

        boolean removed = employees.removeIf(emp -> emp.getName().equalsIgnoreCase(nameToDelete));
        if (removed) {
            System.out.println("Employee '" + nameToDelete + "' removed.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void updateSalariesByDepartment() {
        System.out.print("Enter department to update salaries: ");
        String dept = scanner.nextLine();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable updater = () -> employees.stream()
                .filter(e -> e.getDept().equalsIgnoreCase(dept))
                .forEach(e -> {
                    double newSalary = e.getSalary() + 2000;
                    System.out.println("Updated salary for " + e.getName() + ": ₹" + newSalary);
                });

        Future<?> future = executor.submit(updater);
        executor.shutdown();
        try {
            future.get(); // Wait for salary update to complete
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error during salary update: " + e.getMessage());
        }
    }

    private static void groupByDepartment() {
        System.out.println("\n Grouped by Department:");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept))
                .forEach((dept, empList) -> {
                    System.out.println(dept + ":");
                    empList.forEach(e -> System.out.println(" - " + e.getName()));
                });
    }
}
