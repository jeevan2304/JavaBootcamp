package day3;

import java.util.ArrayList;
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

    public void removeEmployee(Employee e) {
        team.remove(e);
    }

    public List<Employee> getTeam() {
        return team;
    }

    public static class Builder extends Employee.Builder {
        @Override
        public Manager build() {
            return new Manager(this);
        }
    }
}
