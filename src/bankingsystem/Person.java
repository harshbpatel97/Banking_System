/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

/**
 * This class discusses about various attributes of a person
 * @author Harsh
 */
public class Person {
    private String name;
    private String dob;
    private String address;
    private long ssn;
    private long phoneNumber;
    private String email;

    /**
     * Constructor initializing fields of this class
     * @param name name of the person
     * @param dob date of birth
     * @param address current address
     * @param ssn social security number
     * @param phoneNumber contact number
     * @param email email address
     */
    public Person(String name, String dob, String address, long ssn, long phoneNumber, String email) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.ssn = ssn;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * Getter for the name of the person
     * @return person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the date of birth 
     * @return date of birth
     */
    public String getDob() {
        return dob;
    }

    /**
     * Getter for the address
     * @return current address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Getter for social security number
     * @return social security number
     */
    public long getSsn() {
        return ssn;
    }

    /**
     * Getter for phone number
     * @return phone number
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Getter for the email address
     * @return email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method allows to update the address
     * @param address pass the address to be updated
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method allows to update the phone number of the person
     * @param phoneNumber pass the phone number to be updated
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * This method allows to update the email address
     * @param email enter the email address to be updated
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method overrides the super class toString method
     * @return String containing details of this class
     */
    @Override
    public String toString() {
        return "\n Name = " + name + "\t DOB = " + dob + "\t Address = " + address + "\n Phone number = " + phoneNumber + "\t Email = " + email;
    }
    
    
}
