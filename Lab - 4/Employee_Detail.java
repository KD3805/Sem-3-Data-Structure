/*Create class Employee_Detail with attributes Employee_ID, Name, Designation, 
and Salary. Write a program to read the detail from user and print it.*/

import java.util.Scanner;

public class Employee_Detail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EmployeeDetail employee = new EmployeeDetail();

        System.out.print("Enter Employee ID: ");
        int employeeID = scanner.nextInt();
        employee.setEmployeeID(employeeID);

        System.out.print("Enter Name: ");
        String name = scanner.next();
        employee.setName(name);

        System.out.print("Enter Designation: ");
        String designation = scanner.next();
        employee.setDesignation(designation);

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        employee.setSalary(salary);

        System.out.println("\nEmployee Details:");
        System.out.println("Employee ID: " + employee.getEmployeeID());
        System.out.println("Name: " + employee.getName());
        System.out.println("Designation: " + employee.getDesignation());
        System.out.println("Salary: $" + employee.getSalary());

        scanner.close();
    }
}
class EmployeeDetail {
    private int employeeID;
    private String name;
    private String designation;
    private double salary;

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

