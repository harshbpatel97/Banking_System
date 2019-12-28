/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the test harness class to test the entire project
 * Major functions: 1) customerPortal (customer portal)
 *                  2) accessChecking (checking account portal)
 *                  3) accessSaving (saving account portal)
 *                  4) acessCD (CD account portal)
 *                  5) employeePortal (employee portal)
 * @author Harsh
 */
public class BankingSystem {

    /**
     * main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Person> person = new ArrayList<>(); // create an arraylist of person class objects
        ArrayList<Account> account = new ArrayList<>();     // create an arraylist of account class objects

        addPerson(person);      // call the addPerson method to add the person objects to the person arraylist
        // run loop to add accounts of customers to the account arraylist
        for (int i = 0; i < person.size(); i++) {
            if (person.get(i).getClass().toString().contains("Customer")) {
                for (int j = 0; j < ((Customer) (person.get(i))).getAccount().size(); j++) {
                    account.add(((Customer) (person.get(i))).getAccount(j));
                }
            }
        }

        // create object of bank arrayList
        Bank bofa = new Bank("Bank Of America", "University Boulevard", 052001633, person, account);

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to " + bofa.getBankName());

        // ask the user to select whether they want to access employee or customer portal
        try {
            System.out.println(" Press 1 to look for employee "
                    + "\n Press 2 to look for customer "
                    + "\n Press any other number to quit");
            int response = sc.nextInt();
            if (response == 1) {
                employeePortal(person);
            } else if (response == 2) {
                customerPortal(person);
            } else {
                System.out.println("BYE!!");
            }
        } catch (Exception e) {
            System.out.println("ERROR!!! You did not enter a number");
        }

    }

    /**
     * This method deals with the customer portal and its various features
     * 1st Major function dealing with features available to customers
     * @param person pass the person arrayList so as to access the customers
     * through polymorphism
     */
    public static void customerPortal(ArrayList<Person> person) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Customer Portal");
        System.out.println("Enter your name to pull off your profile: ");   // take input to match entry with the database
        String name = sc.nextLine();
        boolean isMatch = false; // to check whether the name inputted by user matches the database
        // iterating through the person arrayList
        for (int i = 0; i < person.size(); i++) {
            // proceed forward if the person is a customer and input matches or is a part of the name in the database
            if (person.get(i).getClass().toString().contains("Customer") && person.get(i).getName().contains(name)) {
                Customer cust = ((Customer) (person.get(i)));   // casting the person to customer object
                System.out.println(cust.toString());
                isMatch = true;
                boolean isQuit = false;
                do{
                try {
                    System.out.println(" Press 1 if you want to make any changes (or)"
                            + "\n Press 2 to view your accounts"
                            + "\n Press 3 to view the details of the customer"
                            + "\n Press anything else to quit");
                    int change = sc.nextInt();

                    // run the loop till the user does not desire to quit
                        if(change == 1) {
                            System.out.println("Enter 0 to change address "
                                    + "\nEnter 1 to change phone number"
                                    + "\nEnter 2 to change email address");

                            int index = sc.nextInt();
                            sc.nextLine();
                            switch (index) {
                                case 0:
                                    System.out.println("Enter the new address: ");
                                    cust.setAddress(sc.nextLine());
                                    System.out.println("Your info has been updated");
                                    break;
                                case 1:
                                    System.out.println("Enter the new phone number: ");
                                    cust.setPhoneNumber(sc.nextLong());
                                    System.out.println("Your info has been updated");
                                    break;
                                case 2:
                                    System.out.println("Enter the new email address: ");
                                    cust.setEmail(sc.nextLine());
                                    System.out.println("Your info has been updated");
                                    break;
                                default:
                                    System.out.println("Sorry entered the wrong input");
                            }
                        } else if (change == 2) {
                            System.out.println("Accounts: ");
                            int counter = 0;
                            for (Account acc : cust.getAccount()) {
                                System.out.println("" + counter + " : " + acc.toString());
                                counter++;
                            }
                            System.out.println("Press appropriate index of the account to access that: ");
                            int index = sc.nextInt();
                            accessAccount(cust, index);
                            isQuit = true;
                        } else if(change == 3){
                                System.out.println("" + cust.toString());
                        }else {
                            System.out.println("Thank you for visiting!!");
                            isQuit = true;
                        }
                    } 

                 catch (Exception e) {
                    System.out.println("Error!!! " + e);
                }
                }while (!isQuit);
            }
        }
        // display if the user input name doesnot matches the database
        if(isMatch == false){
            System.out.println("Sorry there is no such customer in the bank");
        }
    }

    /**
     * This method determines the account that a user wants to access
     * @param cust pass the customer object so as to access his/her accounts
     * @param index pass the index number of the account of customer (as
     * customer might have multiple accounts)
     */
    public static void accessAccount(Customer cust, int index) {
        Account myAccount = cust.getAccount(index);
        System.out.println("Summary of this account: \n" + myAccount.toString());

        if (myAccount instanceof Checking) {
            accessChecking(myAccount);                  // direct the user to checking portal if the account is checking
        } else if (myAccount instanceof Saving) {
            accessSaving(myAccount);                    // direct the user to saving portal if the account is saving
        } else {
            accessCD(myAccount);                        // direct the user to CD account if the account type is CD
        }
    }

    /**
     * This method deals with the checking account portal and its feature
     * 2nd major function which deals with features available to checking account
     * @param acc pass the account which is of type checking (i.e. through
     * polymorphism)
     */
    public static void accessChecking(Account acc) {
        Checking myChecking = (Checking) acc;       // cast the account to checking account type
        System.out.println("Welcome to Checking Account Portal");
        System.out.println("Enter the appropiate number in order to access the desired feature: ");
        boolean isQuit = false;

        // run the loop till the user doesnot desire to quit
        do {
            System.out.println(" Press 1: To make a bill pay or withdraw funds"
                    + "\n Press 2: To deposit funds"
                    + "\n Press 3: To check whether there is direct deposit in this account"
                    + "\n Press 4: To turn on or off direct deposit on this account"
                    + "\n Press 5: To access current balance"
                    + "\n Press any other number to quit from the portal"
            );
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the amount to be payed from the account: ");
                    myChecking.billPay(sc.nextDouble());
                    break;

                case 2:
                    System.out.println("Enter the amount to be deposited: ");
                    myChecking.addDeposit(sc.nextDouble());
                    break;

                case 3:
                    System.out.println("Direct deposit is turned on: " + myChecking.isIsDirectDeposit());
                    break;

                case 4:
                    System.out.println("Enter true if you want to turn on direct deposit or enter false: ");
                    myChecking.setIsDirectDeposit(sc.nextBoolean());
                    break;

                case 5:
                    System.out.println("Your current balance: $" + myChecking.getBalance());
                    break;

                default:
                    System.out.println("BYE!!!");
                    isQuit = true;
                    break;
            }
        } while (!isQuit);
    }

    /**
     * This method deals with the saving account portal and its features
     * 3rd major method dealing with features of Saving account
     * @param acc pass the account which is of type saving (i.e. polymorphism)
     */
    public static void accessSaving(Account acc) {
        Saving mySaving = (Saving) acc;     // cast the account to saving type
        System.out.println("Welcome to the Saving Account Portal: ");
        System.out.println("Enter the appropiate number in order to access the desired feature: ");
        boolean isQuit = false;

        // run the loop till the user doesnot desire to quit
        do {
            System.out.println(" Press 1: To withdraw funds"
                    + "\n Press 2: To deposit funds"
                    + "\n Press 3: To check whether there the account is frozen or not"
                    + "\n Press 4: To change the status of freeze on the account"
                    + "\n Press 5: To access current balance"
                    + "\n Press 6: To check how much interest you will earn"
                    + "\n Press 7: To know how much transaction limit you get and how many left"
                    + "\n Press 8: To reset the transaction left on your account"
                    + "\n Press any other number to quit from the portal"
            );
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the amount to be withdraw from the account: ");
                    mySaving.removeFunds(sc.nextDouble());
                    break;

                case 2:
                    System.out.println("Enter the amount to be deposited: ");
                    mySaving.addFunds(sc.nextDouble());
                    break;

                case 3:
                    System.out.println("Your account is freezed:  " + mySaving.isIsFrozen());
                    break;

                case 4:
                    System.out.println("Enter true if you want to freeze the account else enter false: ");
                    mySaving.setIsFrozen(sc.nextBoolean());
                    break;

                case 5:
                    System.out.println("Your current balance: $" + mySaving.getBalance());
                    break;

                case 6:
                    mySaving.interestEarned();
                    break;

                case 7:
                    System.out.println("Transaction Limit: " + mySaving.getTransactionLimit()
                            + "\t Transactions left: " + mySaving.getTransactionsLeft());
                    break;

                case 8:
                    mySaving.setTransactionsLeft(mySaving.getTransactionLimit());
                    System.out.println("Your transactions left has been resetted on this account!!!");
                    break;

                default:
                    System.out.println("BYE!!!");
                    isQuit = true;
            }
        } while (!isQuit);
    }

    /**
     * This method deals with the CD account portal and its features
     * 4th major method dealing with the feature of the CD account
     * @param acc pass the account object which will be of type CD (i.e. through
     * polymorphism)
     */
    public static void accessCD(Account acc) {
        CD myCd = (CD) acc;     // cast the account to CD type
        System.out.println("Welcome to the CD Account Portal: ");
        System.out.println("Enter the appropiate number in order to access the desired feature: ");
        boolean isQuit = false;

        // run the loop till the user doesnot desire to quit
        do {
            System.out.println(" Press 1: To withdraw funds"
                    + "\n Press 2: To deposit funds"
                    + "\n Press 3: To check the status of the penalty mode on the account"
                    + "\n Press 4: To change the status of penalty mode on the account"
                    + "\n Press 5: To access current balance"
                    + "\n Press 6: To check how much mature amount you will earn"
                    + "\n Press 7: To know fixed term and duration completed in order for the funds to become mature"
                    + "\n Press 8: To change the duration completed on your account"
                    + "\n Press any other number to quit from the portal"
            );
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the amount to be withdraw from the account: ");
                    myCd.withdrawal(sc.nextDouble());
                    break;

                case 2:
                    System.out.println("Enter the amount to be deposited: ");
                    myCd.addDeposit(sc.nextDouble());
                    break;

                case 3:
                    System.out.println("Penalty mode: " + myCd.isPenaltyMode());
                    break;

                case 4:
                    System.out.println("Enter true if you want the penalty mode on the account else enter false: ");
                    myCd.setPenaltyMode(sc.nextBoolean());
                    break;

                case 5:
                    System.out.println("Your current balance: $" + myCd.getBalance());
                    break;

                case 6:
                    myCd.maturedAmount();
                    break;

                case 7:
                    System.out.println("Fixed term duration: " + myCd.getFixedTerm()
                            + "\t Duration completed: " + myCd.getDurationCompleted());
                    break;

                case 8:
                    System.out.println("Enter the duration that the funds have completed so far: ");
                    myCd.setDurationCompleted(sc.nextInt());
                    break;

                default:
                    System.out.println("BYE!!!");
                    isQuit = true;
                    break;
            }
        } while (!isQuit);
    }

    /**
     * This method deals with the employee portal and its features
     * 5th Major function dealing with the features available to employee of a bank
     * @param person pass the person arrayList so as to check whether it is
     * employee and act accordingly
     */
    public static void employeePortal(ArrayList<Person> person) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Employee Portal");
        // take input from user to look for the name of the employee
        System.out.println("Enter your name to look for your account: ");
        String name = sc.nextLine();
        boolean isMatch = false; // to check whether the name inputted by user matches the database
        // iterating through the members of person arrayList
        for (int i = 0; i < person.size(); i++) {
            // check whether the member of person arrayList is an employee and input by user is contained in the name of the person
            if (person.get(i).getClass().toString().contains("Employee") && person.get(i).getName().contains(name)) {
                // cast the person object to employee object
                Employee emp = ((Employee) (person.get(i)));
                System.out.println(emp.toString());
                int change;
                isMatch = true;
                boolean isQuit = false;
                while (!isQuit) {
                    System.out.println("Press 1 if you want to make any changes "
                            + "\n Press 2 to view details of the employee"
                            + "\n Press any other number to quit: ");
                    change = sc.nextInt();
                    if (change == 1) {
                        System.out.println(" Enter 0 to change address "
                                + "\n Enter 1 to change phone number"
                                + "\n Enter 2 to change email address");
                        int input = sc.nextInt();
                        sc.nextLine();
                        switch (input) {
                            case 0:
                                System.out.println("Enter the new address: ");
                                emp.setAddress(sc.nextLine());
                                System.out.println("Thank You! The address has been updated.");
                                break;
                            case 1:
                                System.out.println("Enter the new phone number: ");
                                emp.setPhoneNumber(sc.nextLong());
                                System.out.println("Thank You! The phone number has been updated.");
                                break;
                            case 2:
                                System.out.println("Enter the new email address: ");
                                emp.setEmail(sc.nextLine());
                                System.out.println("Thank You! The email address has been updated.");
                                break;
                            default:
                                System.out.println("Sorry entered the wrong input");
                        }
                    } else if (change == 2) {
                        System.out.println("" + emp.toString());
                    } else {
                        System.out.println("Thank you for visiting!!");
                        isQuit = true;
                    }

                }

            }
        }
        // To display if the user input doesnot match the database
        if(isMatch == false){
            System.out.println("Sorry! No customer with such name exists in the bank");
        }
    }

    /**
     * This method deals with initializing person objects through the use of
     * polymorphism and then add different types of accounts to one or more
     * persons
     *
     * @param person pass the person arrayList so as to add the persons to this
     * arrayList
     */
    public static void addPerson(ArrayList<Person> person) {
        // creating various objects of persons 
        Person c1 = new Customer("John Smith", "05/23/1998", "100 Gateway Boulevard, Boone, NC.", 8445996545l, 3669984562l, "johnsmith98@gmail.com", 5987451);
        Person c2 = new Customer("Harry Kirk", "12/02/1987", "220 Jason Dr, Statesville, NC.", 94459565254l, 3765924464l, "harry_kirk@gmail.com", 4977126);
        Person e1 = new Employee("Debbie Ginger", "08/15/1990", "1407 Westward St, Winston, NC.", 548749625l, 704859625l, "debbieginger@outlook.com", 748549, "Full-time", "Loan approval", 35000);

        // adding the persons to the arrayList
        person.add(c1);
        person.add(c2);
        person.add(e1);

        // adding accounts to the person of type customer //
        ((Customer) (c1)).addAccount(new Checking(745621894l, 8945021795l, 15000, 0.05, true));
        ((Customer) (c2)).addAccount(new Checking(845217954l, 8514726l, 5000.74, 0.06, true));
        ((Customer) (c2)).addAccount(new Saving(845156521, 833254796, 16000, 1.25, 1));
        ((Customer) (c2)).addAccount(new CD(45896127l, 841274985l, 1200.76, 2.25, 3, 50, 2));
        
    }

}
