package in.hms;


import java.util.*;

class Schedule {
    private String schedule;

    public Schedule(String schedule) {
        this.schedule = schedule;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}

public class Employee {
    private String name;
    private int id;
    private Schedule schedule;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
        this.schedule=null;
    }

    public void setName(String newName) {
        this.name=newName;

    }

    public void setId(int newId) {
        this.id=newId;

    }

//    public Schedule getSchedule() {
//        return schedule;
//    }

    public void setSchedule(String newSchedule) {
        this.schedule = new Schedule(newSchedule); // Create a new Schedule object with the new schedule
        System.out.println("Schedule updated successfully.");
    }
}
class Doctor extends Employee{
    public Doctor(String name, int id) {
        super(name, id);
    }

}

class Nurse extends Employee{
    public Nurse(String name, int id) {
        super(name, id);
    }
}

class AdminStaff extends Employee{
    public AdminStaff(String name,int id){
        super(name,id);
    }
}



class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

}
