package employeepoc;

public class Builder extends Employee.Builder{
    @Override
    public Manager build() {
        return new Manager(this);
    }
}
