package investment;

public class MutualFunds {
    private String symbol;
    private String name;
    private int quantity;
    private double price;
    private double bookValue;
    
    public MutualFunds(String symbol, String name, int quantity, double price){
        this.symbol = symbol;
        this.name = name;
        this.quantity = quantity;
        this.price  = price;
        this.bookValue = quantity * price;
        
    }
    
    /**
     * @return The symbol of the mutualfund.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @return The quantity of the investment
     */
    public int getQuantity() {
        return quantity;
    }
    
    /**
     * @return The name of the mutualfund.
     */
    public String getName(){
        return name;
    }
    
    /**
     * @return The price of the mutualfunds.
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * @return The book value of the mutualfunds.
     */
    public double getBookValue() {
        return bookValue;
    }
    
    /**
     * @return The gain on mutualfunds.
     */
    public double getGain(){
        return (price*quantity-45.00)- bookValue;
    }
    
    /**
     * @param quantity
     * @param price
     * @return The selling amount.
     */
    public double sellMutualFunds(int qty, double price){
        double amt = qty * price - 45.00;
        this.quantity = this.quantity - qty;
        bookValue = this.bookValue * ((double)this.quantity/ ((double)this.quantity+(double)qty));
        
        return amt;       
    }
    
    /**
     * @param new price from the user.
     */
    public void updateMutualFundsPrice(double price){
        this.price = price;
    }
    
    
    @Override
    public boolean equals(Object o){
        if(!(o instanceof MutualFunds)) return false;
        else{
            MutualFunds m = (MutualFunds) o;
            if(!(this.getSymbol().equals(m.getSymbol()))) return false;
            return true;
        }
    
    }
    
    @Override
    public String toString(){
        return "("+this.symbol+", "+this.quantity+", "+this.name+", "+this.price+", "+this.bookValue+")"; 
    }
    
   
    
}
