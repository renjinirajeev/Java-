package in.hms;

import java.util.ArrayList;
import java.util.List;

public class HMS {
    private List<Employee> employees;
    private List<Department> departments;

    public HMS() {
        this.employees = new ArrayList<>();
        this.departments = new ArrayList<>();
    }

    // Employee Management
    public void addEmployee(Employee employee, Department department) {
        employees.add(employee);
        department.addEmployee(employee);
    }

    public void addEmployeeByHR(String name, int id, String type) {
        Employee employee = null;
        switch (type.toLowerCase()) {
            case "doctor":
                employee = new Doctor(name, id);
                break;
            case "nurse":
                employee = new Nurse(name, id);
                break;
            case "admin":
                employee = new AdminStaff(name, id);
                break;
            default:
                System.out.println("Invalid employee type.");
                return;
        }

        Department department = findDepartment(type);
        if (department == null) {
            System.out.println("Department not found for " + type + ".");
            return;
        }

        addEmployee(employee, department);
        System.out.println("New " + type + " added successfully.");
    }

    // Update Employee Details
    public void updateEmployeeDetails(Employee employee, String newName, int newId) {
        employee.setName(newName);
        employee.setId(newId);
        System.out.println("Employee details updated successfully.");
    }

    // Employee Schedule Management
    public void manageEmployeeSchedule(Employee employee, String newSchedule) {
        employee.setSchedule(newSchedule);
        System.out.println("Employee schedule updated successfully.");
    }

    // Helper method to find department by name
    private Department findDepartment(String name) {
        for (Department department : departments) {
            if (department.getName().equalsIgnoreCase(name)) {
                return department;
            }
        }
        return null;
    }

    // Main method
    public static void main(String[] args) {
        HMS hospital = new HMS();

        // HR staff adds a new doctor
        hospital.addEmployeeByHR("John Doe", 123, "doctor");

        // HR staff adds a new nurse
        hospital.addEmployeeByHR("Jane Smith", 456, "nurse");

        // HR staff adds a new admin staff
        hospital.addEmployeeByHR("Admin User", 789, "admin");

        // Example: Doctor updates their details
        Employee doctor = hospital.employees.get(0); // Assuming the first employee added is a doctor
        hospital.updateEmployeeDetails(doctor, "Dr. John Doe", 124);

        // Example: Nurse manages her schedule
        Employee nurse = hospital.employees.get(1); // Assuming the second employee added is a nurse
        hospital.manageEmployeeSchedule(nurse, "Monday to Friday, 8:00 AM - 4:00 PM");
    }
}


