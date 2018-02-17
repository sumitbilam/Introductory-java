/*
 * package .
 */
package assignment1;

/**
 *
 * @author sumit
 */
public class Stock {
    private String symbol;
    private String name;
    private int quantity;
    private double price;
    private double bookValue;
    
    public Stock(String symbol, String name, int quantity, double price){
        this.symbol = symbol;
        this.name = name;
        this.quantity = quantity;
        this.price  = price;
        this.bookValue = bookValue+(quantity * price) + 9.99;
        
    }
    
     /**
     * @return The symbol of the stock.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @return The quantity of the stock.
     */
    public int getQuantity() {
        return quantity;
    }
     
    /**
     * @return The name of the stock.
     */
    public String getName(){
        return name;
    }
    
    
    /**
     * @return The price of the stock.
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * @return The book value of the stock.
     */
    public double getBookValue() {
        return bookValue;
    }
    
    /**
     * @return The gain on stock.
     */
    public double getGain(){
        return (price*quantity -9.99) - bookValue;
    }
    
    /**
     * @param quantity
     * @param price
     * @return The selling amount.
     */
    public double sellStock(int qty, double price){
        double amt = qty * price - 9.99;
        this.quantity = this.quantity - qty; 
        bookValue = this.bookValue * ((double)this.quantity/ ((double)this.quantity+(double)qty));

        return amt;       
    }
    
    /**
     * @param new price from the user.
     */
    public void updateStockPrice(double price){
        this.price = price;
    }
    
    
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Stock)) return false;
        else{
            Stock s = (Stock) o;
            if(!(this.getSymbol().equals(s.getSymbol()))) return false;
            return true;
        }
    
    }
    
    @Override
    public String toString(){
        return "("+this.symbol+", "+this.quantity+", "+this.name+", "+this.price+", "+this.bookValue+")"; 
    }
    
   
    
    
}
