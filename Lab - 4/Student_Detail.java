/*Create array of object of class Student_Detail with attributes Enrollment_No, 
Name, Semester, CPI for 5 students, scan their information and print it.*/

import java.util.Scanner;

public class Student_Detail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Total number of Students : ");
        int n = scanner.nextInt();

        StudentDetail[] students = new StudentDetail[n];

        for (int i = 0; i < n; i++) {
            students[i] = new StudentDetail();

            System.out.println("Enter details for Student " + (i + 1) + ":");

            System.out.print("Enrollment No: ");
            int enrollmentNo = scanner.nextInt();
            students[i].setEnrollmentNo(enrollmentNo);

            System.out.print("Name: ");
            String name = scanner.next();
            students[i].setName(name);

            System.out.print("Semester: ");
            int semester = scanner.nextInt();
            students[i].setSemester(semester);

            System.out.print("CPI: ");
            double cpi = scanner.nextDouble();
            students[i].setCPI(cpi);

            System.out.println();
        }

        System.out.println("\nStudent Details...");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Enrollment No: " + students[i].getEnrollmentNo());
            System.out.println("Name: " + students[i].getName());
            System.out.println("Semester: " + students[i].getSemester());
            System.out.println("CPI: " + students[i].getCPI());
            System.out.println();
        }

    }
}
class StudentDetail {
    private int enrollmentNo;
    private String name;
    private int semester;
    private double cpi;

    public void setEnrollmentNo(int enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
    }

    public int getEnrollmentNo() {
        return enrollmentNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getSemester() {
        return semester;
    }

    public void setCPI(double cpi) {
        this.cpi = cpi;
    }

    public double getCPI() {
        return cpi;
    }
}
