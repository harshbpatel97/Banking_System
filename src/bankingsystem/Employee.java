/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

/**
 * This class deals with the features and details of the employees at the bank
 * @author Harsh
 */
public class Employee extends Person {
    
    private int employeeID;
    private String jobStatus;
    private String department;
    private double salary; 
    
    /**
     * Constructor initializing the fields of this class
     * @param name name of the employee
     * @param dob date of birth of the person
     * @param address current address of the person
     * @param ssn social security number 
     * @param phoneNumber contact number
     * @param email email address
     * @param employeeID employee unique identification number
     * @param jobStatus job status of the employee at the bank
     * @param department department in which the person is working
     * @param salary salary of the employee
     */
    public Employee(String name, String dob, String address, long ssn, long phoneNumber, String email, 
            int employeeID, String jobStatus, String department, double salary) {
        super(name, dob, address, ssn, phoneNumber, email);
        this.department = department;
        this.employeeID = employeeID;
        this.jobStatus = jobStatus;
        this.salary = salary;
    }

    /**
     * Getter for the employee id number
     * @return the employee number 
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * Getter for the job status of the employee
     * @return the job status of the employee
     */
    public String getJobStatus() {
        return jobStatus;
    }

    /**
     * Getter for the department in which the employee is working
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Getter for the salary of the employee
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Overrides the toString method of the super class
     * @return the details of this class in string format
     */
    @Override
    public String toString() {
        return "\n EmployeeID = " + employeeID + "\t Job Status = " + jobStatus + "\t Department = " + department + "\n Salary = " + salary + super.toString();
    }
}
