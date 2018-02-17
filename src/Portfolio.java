/*
 * Packages and import classes
 */
package assignment1;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sumit
 */
public class Portfolio {
    private ArrayList<Stock> stockList = new ArrayList();
    private ArrayList<MutualFunds> mutualFundsList = new ArrayList();
    
    /**
     * @param symbol symbol of the investment
     * @param name name of the investment 
     * @param quantity quantity of the investment
     * @param price price of the investment
     * result - add stock info to stockList
     */
    public void addStock(String symbol, String name, int quantity, double price){
        Stock stockInfo = new Stock(symbol, name, quantity, price);
        stockList.add(stockInfo);
    
    }
    
    /**
     * @param symbol symbol of the investment
     * @param name name of the investment 
     * @param quantity quantity of the investment
     * @param price price of the investment
     * result - add mutualfunds info to mutualfundsList
     */
    public void addMutualFunds(String symbol, String name, int quantity, double price){
        MutualFunds mutualFundsInfo = new MutualFunds(symbol, name, quantity, price);
        mutualFundsList.add(mutualFundsInfo);
    
    }
    
    /**
     * @return the net gain of the investment
     */
   public double totGain(){
       double gain = 0.0;
       for(int i = 0; i < stockList.size(); i++){
           gain += stockList.get(i).getGain();
       }
       for(int i = 0; i < mutualFundsList.size(); i++){
           gain += mutualFundsList.get(i).getGain();
       }
       return gain;
   }
   
   
   /**
    * @param symbol which investment you want to sell
    * @param quantity how many of them you want to sell
    * @param price at what price you want to sell them
    */
   public void sellInvestment(String symbol, int quantity, double price){
       Stock stockInfo = new Stock(symbol, null, 0, 0.00);
       MutualFunds mutualFundsInfo = new MutualFunds(symbol, null, 0, 0.00);
       
       if(stockList.contains(stockInfo)){
           System.out.println("this quantity i am sending out" + quantity);
          int index = stockList.indexOf(stockInfo);
          stockList.get(index).sellStock(quantity, price);
       }
       else if(mutualFundsList.contains(mutualFundsInfo)){
           int index = mutualFundsList.indexOf(mutualFundsInfo);
           mutualFundsList.get(index).sellMutualFunds(quantity, price);
       }
       else {
           System.out.println("Symbol doesn't exists");
          
       }
   }
   
   /**
    * @param stockPrice list the one you want to update the price for
    * @param mutualFundsPrice list the one you want to update the price for
    * result - call updateStockPrice and updatemutualFundsPrice 
    */
   public void updatePrice(){
       Scanner keyboard = new Scanner(System.in);
       for(int i = 0; i < stockList.size(); i++){
             System.out.println("Enter new price for symbol: " +stockList.get(i).getSymbol());
             double price = keyboard.nextDouble();
             keyboard.nextLine();
            Stock obj = stockList.get(i);
            obj.updateStockPrice(price);
       }    
       for(int i = 0; i < mutualFundsList.size(); i++){
           System.out.println("Enter new price for symbol: " +mutualFundsList.get(i).getSymbol());
           double price = keyboard.nextDouble();
            keyboard.nextLine();
           MutualFunds obj = mutualFundsList.get(i);
           obj.updateMutualFundsPrice(price);
       }
       
       
   }
   
   public void serach(String symbol, String keyWords){
       
       if(symbol.length() !=0 && keyWords.length() == 0){
           int num = stockList.indexOf(new Stock(symbol," ", 0,0.0));
           if(num!= -1){
                System.out.println("Result");
                System.out.println(stockList.get(num));
           
           }
           num = mutualFundsList.indexOf(new MutualFunds(symbol, " ", 0, 0.0));
           if(num!= -1){
               System.out.println("Result");
               System.out.println(mutualFundsList.get(num));
           
           }
       
        }
       if(keyWords.length() !=0 && symbol.length() == 0){
           for(int i=0; i<stockList.size(); i++){
               if(stockList.get(i).getName().contains(keyWords.toLowerCase())){
                   System.out.println("Result");
                   System.out.println(stockList.get(i));

               
                }
                if(mutualFundsList.get(i).getName().contains(keyWords.toLowerCase())){
                    System.out.println(mutualFundsList.get(i));
                    System.out.println("Result");
                    System.out.println(stockList.get(i));
                }
           
           }

        }
        if(symbol.length() !=0 && keyWords.length() != 0){
           int num = stockList.indexOf(new Stock(symbol," ", 0,0.0));
           if(num!= -1){
                System.out.println("Result");
                System.out.println(stockList.get(num));
           
           }
           num = mutualFundsList.indexOf(new MutualFunds(symbol, " ", 0, 0.0));
           if(num!= -1){
               System.out.println("Result");
               System.out.println(mutualFundsList.get(num));
           
           }
       
        }
       
       
   }
   
}
