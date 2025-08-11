package day3;

import java.util.Optional;

public class Employee{
    private final String name;
    private final int age;
    private final String dept;
    private final double salary;
    private final Optional<String> manager;

    protected Employee(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.dept = builder.dept;
        this.salary = builder.salary;
        this.manager = Optional.ofNullable(builder.manager);
    }
    public String getName(){
        return  name;
    }
    public int getAge(){ return age; }
    public String getDept(){return dept; }
    public double getSalary(){return salary;}
    public Optional<String> getManager(){ return manager;}

    public static class Builder{
        private String name;
        private int age;
        private String dept;
        private double salary;
        private String manager;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setDept(String dept) {
            this.dept = dept;
            return this;
        }

        public Builder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        public Builder setManager(String manager) {
            this.manager = manager;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }

    }
}


//builder pattern is being followed over here :
//see employee has too many fields which can have optionals fields also if u use constructors it would more to error prone
//it can have readable and flexible object creation

//nested builder:
//enables better encapsulation,,,setters methods are added inside the nested builder class where as the employee is immuatble like we have added final keyword
//builders handles all the setting during construction

//reason behind the static:
//object creation without instance like i dont need employee instance as i am using the private constructor i cant create the instance of employee class so its where the usage of builder comes into picture
//it also handles optional data easily,improves clarity of the code
//new Employee.Builder() just doing this is enough i dont want create the instance of the employee class