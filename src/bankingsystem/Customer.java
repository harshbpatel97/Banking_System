/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

import java.util.ArrayList;

/**
 * The customer class involves the different features and details available to the class
 * @author Harsh
 */

public class Customer extends Person{
    
    private int customerID;
    private ArrayList<Account> account = new ArrayList<>();
    
    /**
     * Constructor aiming at initializing fields of the class
     * @param name name of the person
     * @param dob date of birth 
     * @param address address where the person lives
     * @param ssn social security of the person
     * @param phoneNumber contact number
     * @param email email address of the person
     * @param customerID unique identification number provided by the bank
     */
    public Customer(String name, String dob, String address, long ssn, long phoneNumber, String email, int customerID) {
        super(name, dob, address, ssn, phoneNumber, email);
        this.customerID = customerID;
    }
    
    /**
     * Getter for the account situated at a particular index in the account arrayList
     * @param index pass the index at which you want to locate the account in the arrayList
     * @return the account at the particular index
     */
    public Account getAccount(int index){
        return account.get(index);
    }
    
    /**
     * Getter for the account arrayList
     * @return the entire account arrayList
     */
    public ArrayList<Account> getAccount(){
        return account;
    }
    
    /**
     * Getter for the customer ID
     * @return the customer ID
     */
    public int getCustomerID(){
        return customerID;
    }

    /**
     * This method allows to add account into the arrayList
     * @param ac pass the account object to be added to the arrayList
     */
    public void addAccount(Account ac){
        account.add(ac);
    }

    /**
     * This method allows to override the super class method as well as
     *  provides the details of this class in string format
     * @return String containing details of this class
     */
    @Override
    public String toString() {
        return  "\n Customer ID = " + customerID + super.toString();
    }
    
    
}
