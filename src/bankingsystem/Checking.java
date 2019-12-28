/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

/**
 * This class provides the details of the checking account and its features
 * @author Harsh
 */
public class Checking extends Account {
    
    private boolean isDirectDeposit;
    
    /**
     * Constructor aims at initializing the fields of the class
     * @param accNum Account number of the account
     * @param routingNum Routing number of the account
     * @param balance Balance available to the account
     * @param interestRate Interest rate offered to the account
     * @param isDirectDeposit Checks whether there is direct deposit on the account
     */
    public Checking(long accNum, long routingNum, double balance, double interestRate, boolean isDirectDeposit) {
        super(accNum, routingNum, balance, interestRate);
        this.isDirectDeposit = isDirectDeposit;
    }
    
    /**
     * This method pays bills as well as withdraw funds from the account
     * @param billAmt pass the amount to be paid
     */
    public void billPay(double billAmt){
        super.withdrawal(billAmt);
    }
     /**
      * Overrides the super class addDeposit method
      * @param amt  pass the amount to be deposited in the account
      */
    @Override
    public void addDeposit(double amt) {
        super.addDeposit(amt); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Checks whether the direct deposit is enabled or not on the account
     * @return boolean value of the direct deposit
     */
    public boolean isIsDirectDeposit() {
        return isDirectDeposit;
    }

    /**
     * Changes the boolean value of the direct deposit on the account
     * @param isDirectDeposit pass the value of the direct deposit to be changed
     */
    public void setIsDirectDeposit(boolean isDirectDeposit) {
        this.isDirectDeposit = isDirectDeposit;
    }
    
    /**
     * Overrides the super class toString() method
     * @return String value containing all the details of the class
     */
    @Override
    public String toString() {
        return "\n Checking:  isDirectDeposit = " + isDirectDeposit + super.toString();
    }
    
    
}
