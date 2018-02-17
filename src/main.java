/*
 * Packages and import classes
 */
package investment;
import java.util.Scanner;
import java.util.ArrayList;

public class Investment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int choice = 0;
        String investment = "";
        String name = "";
        String symbol = "";
        int quantity = 0;
        double price = 0.0;
        String temp = " ";
        
       Portfolio take = new Portfolio();

        while(choice != 6){
            System.out.println("Enter your choice:");
            if(keyboard.hasNextInt()){
                
                choice = keyboard.nextInt();
                keyboard.nextLine(); 
            }
            else{
                System.out.println("Invalid input. Enter the correct choice");
                keyboard.next();
            }
            if(choice == 1){
               System.out.println("What kind of investment you want to buy(Stock or Mutualfunds):");
                investment = keyboard.nextLine();

                while(investment.compareToIgnoreCase("stock") != 0 && investment.compareToIgnoreCase("mutualfunds") != 0){
                   System.out.println("Please type the correct name of the investment(stock or mutualfunds)");
                   investment = keyboard.nextLine();
                }
                    if(investment.compareToIgnoreCase("stock") == 0 ){
                   
                       System.out.println("Enter the symbol:");
                       symbol = keyboard.nextLine();
                       System.out.println("Enter the name of the investment:");
                       name = keyboard.nextLine();
                       System.out.println("Enter the quantity of stocks you want to buy:");
                       quantity = keyboard.nextInt();
                       keyboard.nextLine();
                       System.out.println("Enter the price ($/stock):");
                       price =  keyboard.nextDouble();
                       keyboard.nextLine();
                       
                       take.addStock(symbol, name, quantity, price);
                       
              
                      
               
                    }
                    if(investment.compareToIgnoreCase("mutualfunds") == 0 ){
                       System.out.println("Enter the symbol:");
                       symbol = keyboard.nextLine();
                       System.out.println("Enter the name of the investment:");
                       name = keyboard.nextLine();
                       System.out.println("Enter the quantity of mutualfunds you want to buy:");
                       quantity = keyboard.nextInt();
                       keyboard.nextLine();
                       System.out.println("Enter the price ($/mutualfund):");
                       price =  keyboard.nextDouble();
                       keyboard.nextLine();
                      
                       take.addMutualFunds(symbol, name, quantity, price);
                      
               
                    }
               
                    
            }
            if(choice == 2){
               System.out.println("Enter the symbol of the investment you want to sell:");
               symbol = keyboard.nextLine();
               System.out.println("Enter the quantity of investment that you want to sell:");
               quantity = keyboard.nextInt();
               keyboard.nextLine();
               System.out.println("Enter the price you want to sell for:");
               price = keyboard.nextDouble();
               keyboard.nextLine();
               
               take.sellInvestment(symbol, quantity, price);
              
                  
            }
           
            if(choice == 3){
             
                take.updatePrice();
                

            }
            
            if(choice == 4){  
                double totalGain = take.totGain();
                System.out.printf("Total gain is:$%.2f\n",totalGain);
            }
            
            if(choice == 5){
                 System.out.println("Enter the the symbol to search:");
                 symbol = keyboard.nextLine();
                 System.out.println("Enter the the keyword to search:");
                 String keywords = keyboard.nextLine();
                 take.serach(symbol, keywords);
                 
            }
           
        }
    }
}
               
