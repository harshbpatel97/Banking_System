/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

/**
 * This class deals with the various accounts within a bank
 * @author Harsh
 */
public class Account {
    private long accNum;
    private long routingNum;
    private double balance;
    private double interestRate;

    /**
     * constructor dealing with initialization of different fields
     * @param accNum assigns the account number
     * @param routingNum enters the routing number of the bank
     * @param balance   fills the balance detail of the account
     * @param interestRate initializes the interest rate associated with the account
     */
    public Account(long accNum, long routingNum, double balance, double interestRate) {
        this.accNum = accNum;
        this.routingNum = routingNum;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    /**
     * Getter for the account number
     * @return the account number
     */
    public long getAccNum() {
        return accNum;
    }

    /**
     * Getter the routing number of the accounts 
     * @return the account's routing number
     */
    public long getRoutingNum() {
        return routingNum;
    }

    /**
     * Getter for the account balance
     * @return the balance associated with the bank
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Getter for the interest rate
     * @return the interest rate associated with the bank
     */
    public double getInterestRate() {
        return interestRate;
    }
    
    /**
     * this method aims at adding funds to the account
     * @param depositAmt input the amount to be added to the account
     */
    public void addDeposit(double depositAmt){
        balance += depositAmt;
        System.out.println("Now your current balance is $" + balance);
    }
    
    /**
     * this method aims at withdrawing the funds from the account
     * @param amt input the amount to be withdraw from the account
     */
    public void withdrawal(double amt){
        if(amt > balance)
            System.out.println("Sorry! You don't have enough balance in your account to withdraw");
        else {
            balance -= amt;
            System.out.println("Now your current balance is $" + balance);
        }
    }

    /**
     * this method prints all the details of the class
     * @return the details of the class in the string format
     */
    @Override
    public String toString() {
        return "\n Account Number = " + accNum + "\t Routing Number = " + routingNum + "\t Balance = $" + balance + "\n Interest Rate = " + interestRate;
    }   
}
