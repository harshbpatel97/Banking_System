/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

import java.util.ArrayList;

/**
 * This class deals with the entire bank which contains information
 * of persons (employees and customers) and their accounts
 * @author Harsh
 */
public class Bank {
    private String bankName;
    private String bankLoc;
    private long bankRouting;
    private ArrayList<Person> person = new ArrayList<>();
    private ArrayList<Account> account = new ArrayList<>();

    /**
     * The constructor of the bank which deals with initializing different fields
     * @param bankName input the name of the bank
     * @param bankLoc input the location of the bank
     * @param bankRouting input the routing number of the bank
     * @param person pass the person arrayList so as to enter information of all the persons
     * @param account pass the account arrayList so as to keep the details of all the accounts at the bank
     */
    public Bank(String bankName, String bankLoc, long bankRouting, ArrayList<Person> person, ArrayList<Account> account) {
        this.bankName = bankName;
        this.bankLoc = bankLoc;
        this.bankRouting = bankRouting;
        this.person = person;
        this.account = account;
    }

    /**
     * Getter for the bank name
     * @return the name of the bank
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Getter for the bank location
     * @return the location of the bank
     */
    public String getBankLoc() {
        return bankLoc;
    }

    /**
     * Getter for the routing number of the bank
     * @return the routing number of the bank
     */
    public long getBankRouting() {
        return bankRouting;
    }

    /**
     * Getter for person arrayList
     * @return the arrayList of the Person
     */
    public ArrayList<Person> getPerson() {
        return person;
    }

    /**
     * Getter for the account arrayList
     * @return the arrayList of the account
     */
    public ArrayList<Account> getAccount() {
        return account;
    }
    
    /**
     * adds the person to the particular person arrayList
     * @param p pass the person object to be passed to the person arrayList
     */
    public void addPerson(Person p){
        person.add(p);
    }
    
    /**
     * adds the account to the account arrayList
     * @param acc pass the account object so as to add to the account arrayList
     */
    public void addAccount(Account acc){
        account.add(acc);
    }

    /**
     * Prints the details of this class
     * @return the details in string
     */
    @Override
    public String toString() {
        return "Bank Name=" + bankName + "\t Bank Location = " + bankLoc + "\t Bank Routing = " + bankRouting;
    }
   
}
