package app;

import java.io.PrintStream;
import java.security.SecureRandom;
import java.util.Scanner;

// Ο μοναδικός κωδικός του δανείου θα δωθεί από τη γεννήτρια τυχαίων αριθμών (0-99)

public class Loan {
    
    private int reqLoanAmount;
    private int monthlyInstallments;
    private int monthlyInstallmentAmount;
    private int livingArea; //Εμβαδόν κατοικίας
    private int afm;
    private String fullname;
    private int loanUniqueCode;
    private boolean homeInsuranceLoan;
    
    Scanner input = new Scanner(System.in);
    SecureRandom randomNumbers = new SecureRandom();
    
    // Constructor για να φτιάξουμε τα ήδη δημιουργημένα δάνεια
    public Loan(int reqLoanAmount,int monthlyInstallments,int monthlyInstallmentAmount,int livingArea,int afm, String fullname){
    
        this.reqLoanAmount = reqLoanAmount;
        this.monthlyInstallments = monthlyInstallments;
        this.monthlyInstallmentAmount = monthlyInstallmentAmount;
        this.livingArea = livingArea;
        this.afm = afm;
        this.fullname = fullname;
        this.homeInsuranceLoan = false;
        
    }
    
    // Constructor όταν δίνει ο χρήστης είσοδο
    public Loan(){
        
        System.out.println("Requested loan amount:");
        this.reqLoanAmount = input.nextInt();
        
        System.out.println("Number of monthly installments:");
        monthlyInstallments = input.nextInt();
        if (monthlyInstallments < 12 || monthlyInstallments > 240) {
            throw new IllegalArgumentException("Monthly Installments must be > 12 and < 240");
        }
        this.monthlyInstallments = monthlyInstallments;  
        
        System.out.println("Μonthly installment amount");
        this.monthlyInstallmentAmount = input.nextInt();
        
        System.out.println("Living area");
        this.livingArea = input.nextInt();
        
        System.out.println("Please give your afm");
        this.afm = input.nextInt();
        
        System.out.println("Please give your full name");
        String var = input.nextLine();
        this.fullname = input.nextLine();
        
        this.loanUniqueCode = randomNumbers.nextInt(100);
        
    }
    
    // Setters και getters
    public void setLoanUniqueCode(int loanUniqueCode ){
        this.loanUniqueCode= loanUniqueCode;
    }
    
    public int getLoanUniqueCode(){
        return this.loanUniqueCode;
    }
    
    public int getReqLoanAmount(){
        return this.reqLoanAmount;
    }
    
    public int getAfm(){
        return this.afm;
    }
    
    public int getMonthlyInstallmentAmount(){
        return this.monthlyInstallmentAmount;
    }  
    
    // Μέθοδος που εκτυπώνει τα κατάλληλα πεδία
    public void Print(){
        System.out.println("Unique code:" + getLoanUniqueCode() + "\nAFM:" + getAfm() + "\nMonthly installment amount:" + getMonthlyInstallmentAmount());
    }
    
}
