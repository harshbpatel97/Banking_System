/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

/**
 * This class deals with the CD account and its features
 * @author Harsh
 */
public class CD extends Account{
    
    private double fixedTerm;
    private double penalty;
    private double durationCompleted;
    private boolean penaltyMode = false;

    /**
     * Constructor initializes the different fields of the class
     * @param accNum account number of the account
     * @param routingNum routing number of the account
     * @param balance balance available in the account
     * @param interestRate interest rate offered to the account
     * @param fixedTerm term for which the account is on hold by the bank
     * @param penalty charges incurred by the bank if the account holder breaks the term
     * @param durationCompleted term completed by the account holder
     */
    public CD(long accNum, long routingNum, double balance, double interestRate, double fixedTerm, double penalty, double durationCompleted) {
        super(accNum, routingNum, balance, interestRate);
        this.durationCompleted = durationCompleted;
        this.fixedTerm = fixedTerm;
        this.penalty = penalty;
    }

    /**
     * Getter for fixedTerm 
     * @return the fixed term of the account
     */
    public double getFixedTerm() {
        return fixedTerm;
    }

    /**
     * Getter for penalty incurred to the holder
     * @return the penalty
     */
    public double getPenalty() {
        return penalty;
    }
    
    /**
     * Getter for duration completed by the holder
     * @return Duration completed by the account
     */
    public double getDurationCompleted() {
        return durationCompleted;
    }

    /**
     * This method is used to change the value of the duration completed
     * @param durationCompleted pass in the value of the duration completed to be change
     */
    public void setDurationCompleted(double durationCompleted) {
        this.durationCompleted = durationCompleted;
    }

    /**
     * The method allows to check whether the account is in penalty mode or not
     * @return boolean value of penalty mode
     */
    public boolean isPenaltyMode() {
        return penaltyMode;
    }

    /**
     * This method used to change the value of penalty mode
     * @param penaltyMode pass the value of the penalty mode to be changed
     */
    public void setPenaltyMode(boolean penaltyMode) {
        this.penaltyMode = penaltyMode;
    }
    
    /**
     * Overrides the super class withdrawal method
     * @param amt pass the amount to be withdrew
     */
    @Override
    public void withdrawal(double amt){
        if(durationCompleted >= fixedTerm){
            super.withdrawal(amt);
        }
        else{
            System.out.println("A penalty of $" + penalty + " would be charged");
            super.withdrawal(amt + penalty);
            penaltyMode = true;
        }
    }
    
    /**
     * Overrides the super class addDeposit method
     * @param depositAmt pass the amount to be deposited into the account
     */
    @Override
    public void addDeposit(double depositAmt) {
        super.addDeposit(depositAmt); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * This method allows to check what would be matured amount after the account 
     * completes the fixed term duration
     */
    public void maturedAmount(){
        if(penaltyMode == false){
            System.out.println("The matured amount after " + fixedTerm + " years will be: $" + (super.getBalance() * super.getInterestRate()));
        }
        else{
            System.out.println("Sorry!! You have broken the contract so you cannot earn mature amount");
        }
    }
    
    /**
     * Overrides the super class toString method
     * and the respective fields of this class
     * @return String containing all the details of the class
     */
    @Override
    public String toString() {
        return "\n CD: " + "Fixed Term = " + fixedTerm + ", penalty = " + penalty + ", duration completed = " + durationCompleted 
                + "\n penalty mode = " + penaltyMode + super.toString() ;
    }

    
}
