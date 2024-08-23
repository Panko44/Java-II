package app;

import java.security.SecureRandom;
import java.util.Scanner;

// Εφαρμογή κληρονομικότητας και δημιουργία θυγατρικής κλάσης 
public class HomeInsuranceLoan extends Loan{
    
    private String insuranceCategory;
    private int duration;
    private int monthlyCost;
    private int loanUniqueCode;
    private boolean homeInsuranceLoan;
    
    Scanner input = new Scanner(System.in);
    SecureRandom randomNumbers = new SecureRandom();
    
    // Constructor για να φτιάξουμε τα ήδη δημιουργημένα δάνεια
    public HomeInsuranceLoan(int reqLoanAmount,int monthlyInstallments,int monthlyInstallmentAmount,int livingArea,int afm, String fullname,String insuranceCategory,int duration,int monthlyCost){
    
        super(reqLoanAmount,monthlyInstallments,monthlyInstallmentAmount,livingArea,afm,fullname);
        
        this.insuranceCategory = insuranceCategory;
        this.duration = duration;
        this.monthlyCost = monthlyCost;
        this.homeInsuranceLoan = true;
        
    }
    
    // Constructor όταν δίνει ο χρήστης είσοδο
    public HomeInsuranceLoan(){
    
        super();
    
        System.out.println("Category of insurance:");
        this.insuranceCategory = input.nextLine();
        
        System.out.println("Duration in months:");
        this.duration = input.nextInt();
        
        System.out.println("Monthly cost:");
        this.monthlyCost = input.nextInt();
        
    }
    
    // Setters και getters
    public void setLoanUniqueCode(int loanUniqueCode ){
        this.loanUniqueCode= loanUniqueCode;
    }
    
    public String getInsuranceCategory(){
        return this.insuranceCategory;
    }
    
    @Override
    public int getLoanUniqueCode(){
        return super.getLoanUniqueCode();
    }
    
    @Override
    public int getReqLoanAmount(){
        return super.getReqLoanAmount();
    }
    
  
    public int getMonthlyCost(){
        return monthlyCost;
    }
    
    // Μέθοδος που εκτυπώνει τα κατάλληλα πεδία
    @Override
    public void Print(){
        super.Print();
        System.out.println("Monthly cost:" + getMonthlyCost());
    }
    
}
