package app;

import java.util.ArrayList;
import java.util.Scanner;

// Υποθέτουμε για τη λειρουργία 2 πως αν το δάνειο δεν έχει ασφάλεια κατοικίας (είναι απλό) δεν εκτυπώνεται κάτι στο τερματικό.

public class App {

    
    public static void main(String[] args) {
        
        // επιλογή χρήστη από το μενού
        int option = 0;
        // Μεταβλητή που δηλώνει αν το συμβόλαιο περιλαμβάνει και ασφάλεια κατοικίας
        boolean homeInsuranceLoan;
        //Μεταβλητή που δηλώνει αν βρέθηκε κάποιο δάνειο
        boolean found = false;
        
        // Δημιουργία αντικειμένου για να δίνει είσοδο ο χρήστης
        Scanner input = new Scanner(System.in);
        
        // Δημιουργία 2 arrayList ανάλογα με το είδος του δανείου
        ArrayList<Loan> loanList = new ArrayList<>();
        ArrayList<HomeInsuranceLoan> homeInsuranceLoanList = new ArrayList<>();
        
        // Δημιουργία 4 δανείων
        Loan loan1 = new Loan(1000,12,10,100,1,"Panagiotis Kolliopoulos");
        loan1.setLoanUniqueCode(11);
        loanList.add(loan1);
        
        Loan loan2 = new Loan(2000,100,20,200,2,"Jessica Josephine Wendel");
        loan2.setLoanUniqueCode(22);
        loanList.add(loan2);
        
        HomeInsuranceLoan loan3 = new HomeInsuranceLoan(3000,200,30,300,3,"Peter Anastasopoulos","fire",3,30);;
        loan3.setLoanUniqueCode(33);
        homeInsuranceLoanList.add(loan3);
        
        HomeInsuranceLoan loan4 = new HomeInsuranceLoan(4000,240,40,400,4,"Dimitris Giannoulis","fire, theft",4,40);
        loan4.setLoanUniqueCode(44);
        homeInsuranceLoanList.add(loan4); 
        
        do {
            
            // Μενού χρήστη
            System.out.println("\nHello user! Please select an option.");
            System.out.println("1. Entry loan");
            System.out.println("2. Print loan details");
            System.out.println("3. Exit");
            
            option = input.nextInt();
            
            switch( option ){
                case 1:
                    // Καταχώριση δανείου με βάση αν αυτό θα έχει και ασφάλεια κατοικίας
                    System.out.println("Do you want home insurance too?");
                    input.nextLine();
                    String y = input.nextLine();
                    if (y.equals("Yes") || y.equals("yes")) {
                        homeInsuranceLoan = true;
                        HomeInsuranceLoan loan = new HomeInsuranceLoan();
                        homeInsuranceLoanList.add(loan);
                        loan.Print();                       
                    } else {
                        homeInsuranceLoan = false;
                        Loan loan = new Loan();
                        loanList.add(loan);
                        loan.Print();
                    }
                    break;
                case 2:
                    // Εμφάνιση δανείου με βάση τον κωδικό του και αν αυτό έχει ασφάλεια κατοικίας (έτσι ώστε να ψάξουμε και στην κατάλληλη λίστα)
                    System.out.println("Has loan home insurance too?");
                    input.nextLine();
                    y = input.nextLine();
                    if (y.equals("Yes") || y.equals("yes")) {
                        homeInsuranceLoan = true;
                    }else{
                        homeInsuranceLoan = false;
                    }
                    System.out.println("Please give loan's unique code");
                    int uniqueCode = input.nextInt();
                    if (homeInsuranceLoan == true){
                        for( int i = 0; i < homeInsuranceLoanList.size(); i++){
                            if ( uniqueCode == homeInsuranceLoanList.get(i).getLoanUniqueCode()){
                                System.out.println("Loan's unique code:" + homeInsuranceLoanList.get(i).getLoanUniqueCode());
                                System.out.println("Loan's requested amount:" + homeInsuranceLoanList.get(i).getReqLoanAmount());
                                System.out.println("Insurance category:" + homeInsuranceLoanList.get(i).getInsuranceCategory());
                                found = true;
                            } 
                        }
                        if ( found == false ){
                            System.out.println("Loan's unique code can not be found");
                        }
                    } else {
                        for( int i = 0; i < loanList.size(); i++){
                            if ( uniqueCode == loanList.get(i).getLoanUniqueCode()){
                                System.out.println("Loan's unique code:" + loanList.get(i).getLoanUniqueCode());
                                System.out.println("Loan's requested amount:" + loanList.get(i).getReqLoanAmount());
                                found = true;
                            } 
                        }
                        if ( found == false ){
                            System.out.println("Loan's unique code can not be found");
                        }
                    }
                    break;
                case 3:
                    // Έξοδος 
                    System.out.println("Thank you for your time!");
                    break;
                default:
                    //Η είσοδος του χρήστη δεν αντιστοιχεί σε κάποιον από τους αριθμούς του μενού
                    System.out.println("Not matching with any option. Please try again.\n");
                    break;
            }
        } while( option != 3 );
    }
    
}
