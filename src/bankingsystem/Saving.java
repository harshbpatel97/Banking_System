/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

/**
 * This class deals with the features of CD account
 *
 * @author Harsh
 */
public class Saving extends Account {

    private int transactionLimit;
    private boolean isFrozen = false;
    private int transactionsLeft;
    private double interestAmount = 0;

    /**
     * Constructor which aims at initializing fields of this class
     *
     * @param accNum account number
     * @param routingNum routing number
     * @param balance balance available on the account
     * @param interestRate interest rate
     * @param transactionLimit transaction limit allowed to the account
     */
    public Saving(long accNum, long routingNum, double balance, double interestRate, int transactionLimit) {
        super(accNum, routingNum, balance, interestRate);
        this.transactionLimit = transactionLimit;
        transactionsLeft = transactionLimit;
    }

    /**
     * Getter for transaction limit
     *
     * @return transaction limit
     */
    public int getTransactionLimit() {
        return transactionLimit;
    }

    /**
     * Getter for transaction left on the account
     *
     * @return transactions left
     */
    public int getTransactionsLeft() {
        return transactionsLeft;
    }

    /**
     * Getter for the interest amount a holder can earn at the end of the
     * contract
     *
     * @return interest amount
     */
    public double getInterestAmount() {
        return interestAmount;
    }

    /**
     * This methods checks whether the account is frozen or not
     *
     * @return boolean value regarding whether the account is freezed
     */
    public boolean isIsFrozen() {
        return isFrozen;
    }

    /**
     * This method allows to update the transaction limit on the account
     *
     * @param transactionLimit pass the transaction limit value to be updated
     */
    public void setTransactionLimit(int transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    /**
     * This method allows to update the transactions left on the account
     *
     * @param transactionsLeft pass the value of transactions left to be updated
     */
    public void setTransactionsLeft(int transactionsLeft) {
        this.transactionsLeft = transactionsLeft;
    }

    /**
     * This method allows to change the freezing condition of the account
     *
     * @param isFrozen pass the boolean value of account's freeze to be updated
     */
    public void setIsFrozen(boolean isFrozen) {
        this.isFrozen = isFrozen;
    }

    /**
     * This method allows to add funds to the account
     *
     * @param amt pass the amount to be deposited to the account
     */
    public void addFunds(double amt) {
        if (isFrozen != true) {
            super.addDeposit(amt);
        } else {
            System.out.println("Your account is FREEZED!!");
        }
    }

    /**
     * This method allows to remove funds from the account
     *
     * @param amt pass the amount to be withdrawn from the account
     */
    public void removeFunds(double amt) {
        if (isFrozen == false) {
            if (transactionsLeft == 0) {
                isFrozen = true;
                System.out.println("Sorry! You have reached the maximum limit of transactions allowed");
            } else {
                transactionsLeft--;
                super.withdrawal(amt);
            }
        } 

    }

    /**
     * This method calculated the interest earned at the end of the contract
     */
    public void interestEarned() {
        double balance = super.getBalance();
        if (balance >= 15000 && isFrozen != true) {
            double rate = super.getInterestRate();
            interestAmount = balance * rate / 100;
            System.out.println("The interest amount that will be earned at the end of the year: $" + interestAmount);
        } else {
            System.out.println("You dont have enough balance(i.e. over $15000) to earn interest over the balance!!! "
                    + "\n (OR) Your account is FREEZED!!");
        }
    }

    /**
     * This method overrides the super class toString() method
     *
     * @return String containing details of the class
     */
    @Override
    public String toString() {
        return "\n Saving{" + "transactionLimit=" + transactionLimit + ", isFrozen=" + isFrozen + ", transactionsLeft=" + transactionsLeft + ", interestAmount=" + interestAmount + '}' + super.toString();
    }

}
