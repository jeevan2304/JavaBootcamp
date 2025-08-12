package employeepoc;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Manager extends Employee {
    private final List<Employee> team = new CopyOnWriteArrayList<>();

    public Manager(Builder builder) {
        super(builder);
    }

    public void addEmployee(Employee e) {
        team.add(e);
    }

    public void removeEmployee(String name) {
        team.removeIf(emp -> emp.getName().equalsIgnoreCase(name));
    }

    public List<Employee> getTeam() {
        return team;
    }


}
