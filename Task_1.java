// A Fully Functional ATM Interface Using Java

import java.util.Scanner;

class ATM{
    Scanner in= new Scanner(System.in);
    float balance=0;   //Initial Balance
    int self_pin=1234; //User's Pin

    // Function For Login By Entering Pin
    public void checkpin(){
        
        System.out.print("Enter Your Pin :-");
        int pin= in.nextInt();
        if(pin==self_pin){
            menu();
        }else{
            System.out.println("Enter a valid Pin");
            
        }
    }
    // Choices Available
    public void menu(){
    System.out.println("1. Deposit Money");
    System.out.println("2. Withdraw Money");
    System.out.println("3. Check Account Balance");
    System.out.println("4. Change Pin");
    System.out.println("5. Exit");
    System.out.print("Enter Your Choice :-");

    int choice= in.nextInt();
    if(choice==1){dptMoney();}
    else if(choice==2){wtdMoney();}
    else if(choice==3){checkBal();}
    else if(choice==4){changepin();}
    else if(choice==5){return;}
    else{System.out.println("Enter a valid choice");}
    }
    
    // Function For Money Deposition
    public void dptMoney(){
        System.out.print("Enter Amount :");
        float  amount=in.nextFloat();
        balance=balance+amount;
        System.out.println("Money Deposited Successfully");
        menu();
    }

    // Function For Money Withdrawl
    public void  wtdMoney(){
        System.out.print("Enter Amount :");
        float amount= in.nextFloat();
        if(amount>balance){System.out.println("Insufficient Funds");}
        else{
            balance=balance-amount;
            System.out.println("Money Withdrawal Successful");
        }menu();
    }

    // Function For Checking Balance
    public void checkBal(){
        System.out.println("Balance = "+balance);
        menu();
    }

    // Function For Changing Pin
    public void changepin(){
        System.out.print("Enter Your Pin :-");
        int pin=in.nextInt();
        if(pin==self_pin){
            System.out.print("Enter New Pin :-");
            int newpin=in.nextInt();
            System.out.print("Enter Confirm Pin :-");
            int cnfpin=in.nextInt();
            if(newpin==cnfpin){
                self_pin=newpin;
                System.out.println("Pin Changed Successfully");
                checkpin();
            }else{
                System.out.println("Pin Do Not Match");
                checkpin();
            }
        }else{
            System.out.println("Invalid Pin");
            checkpin();           
        }

    }
}

public class ATMMachine {
    public static void main(String[] args) {
        ATM obj= new ATM();
        obj.checkpin(); 
}
}
