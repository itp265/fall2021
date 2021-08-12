import java.time.LocalDate;

/**
 * CreditCard
 *
 * @author Kendra Walther
 * ITP 265, Spring 2021
 * Assignment XX
 * Email: kwalther@usc.edu
 */
public class CreditCard {

    private String name; //or cardHolderName
    private String cardNumber; // number as a long previously.
    private Card_Issuer issuer;
    private int cvv;
    private int expMonth;
    private int expYear;
    private double creditLimit;
    private double balance;
    private double interestRate;
    
        private Transaction[] transactions; // keep track of transactions, up to 100 total
    private int numTransactions;

    public static final int MAX_SIZE = 100; // up to 100 transactions can be stored.
    
    // Constructor - full version (take in ALL instance variables)
    // Good for representing a card that is already owned by somebody
    public CreditCard(String cardNumber, String name, Card_Issuer issuer, int cvv, 
    double limit, double balance, int expMonth, int expDate, double currentInterestRate) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.issuer = issuer;
        this.cvv = cvv;
        this.creditLimit = limit;
        this.balance = balance;
        setExpMonth(expMonth);
        this.expYear = expYear;
        this.interestRate = currentInterestRate;
        this.transactions = new Transaction[MAX_SIZE];
        numTransactions = 0;
    }

    // Constructor - full version (take in ALL instance variables)
    // Good for representing a card that is already owned by somebody
    public CreditCard(String cardNumber, String name, Card_Issuer issuer, int cvv, 
    double limit, double balance, LocalDate expiration, double currInterestRate) {
        this(cardNumber, name, issuer, cvv, limit, balance, expiration.getMonthValue(), expiration.getYear(), currInterestRate);
    }
    
      public CreditCard(String cardNumber, String name, Card_Issuer issuer, int cvv, int expMonth, int expYear) {
        this(cardNumber, name, issuer, cvv, PretendCreditCardCompany.calculateLimit(), 0, expMonth, expYear, PretendCreditCardCompany.DEFAULT_INTEREST_RATE);
    }

    //constructor for a card that has all data, but no balance or current interest rate
    public CreditCard(String cardNumber, String name, Card_Issuer issuer, int cvv, 
    double limit, int expMonth, int expYear) {
        this(cardNumber, name, issuer, cvv, limit, 0, expMonth, expYear, PretendCreditCardCompany.DEFAULT_INTEREST_RATE);
    }

    /**
     * Constructor for a brand new card from a specific issuer.
     * @param name: person's name on the card
     * @param issuer: the type of card
     * @param limit: the credit limit
     */
    public CreditCard(String name, Card_Issuer issuer, double limit) {
        this(PretendCreditCardCompany.generateCardNumber(issuer), name, issuer, PretendCreditCardCompany.generateCVV(), 
            limit, 0, PretendCreditCardCompany.generateExpiration(), PretendCreditCardCompany.getInterestRate());
    }

       public CreditCard(String name, Card_Issuer issuer) {
        this(name, issuer, PretendCreditCardCompany.calculateLimit()); 
    }
    public boolean charge(double amount, String vendor){
        // make sure change doesn't push balance over credit limit
        double newBalance = balance + amount;
        boolean allowedCharge = false;
        if(newBalance < creditLimit){
            balance = newBalance; // add to the debt   
            allowedCharge = true;
            addTransaction(new Transaction(vendor, amount));
        }

        return allowedCharge;
    }

    private void addTransaction(Transaction t) {
        if(numTransactions < transactions.length) {
            transactions[numTransactions] = t;
            numTransactions++; 
        }
        else {
            System.err.println("Exceeded total transactions, re-writing old values");
            numTransactions = 0; //reset to spot 0 
            transactions[numTransactions] = t;
        }
    }
    
        public String getTransactionHistory() {
        String output = "*****  TRANSACTION HISTORY FOR " 
                    + name.toUpperCase() + "'s " + issuer + " Credit Card #" 
                    + this.cardNumber;
        for (int i = 0; i < numTransactions; i++) {
            output += "\n" + transactions[i];
        }
        
        return output;
    }
    public void payBill(double amount){
        balance -= amount;   
        addTransaction(new Transaction("Payment Received", amount));
    }

    public void chargeInterest(){
        double INTEREST_RATE = .15;
        balance += (INTEREST_RATE * balance);  
    }

    /**
     * @return the limit
     */
    public double getLimit() {
        return creditLimit;
    }

    /**
     * @param limit the limit to set
     */
    public void setLimit(double limit) {
        creditLimit = limit;
    }

    /**
     * @return the cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * @return the issuer
     */
    public Card_Issuer getIssuer() {
        return issuer;
    }

    /**
     * @return the cvv
     */
    public int getCvv() {
        return cvv;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the expiration
     */
    public String getExpiration() {
        return expMonth + "/" + expYear;
    }

    public int getExpMonth() {
        return expMonth ;
    }

    public int getExpYear() {
        return expYear;
    }

    public void setExpMonth(int number){
        if(number < 1 || number >= 13){ //number not 1-12
            expMonth = 2; // set to current month LocalDate.now().getMonthValue();
        }
        else {
            expMonth = number;    

        }
    }

    @Override
    public String toString() {
        return "CreditCard [cardNumber=" + cardNumber + ", issuer=" + issuer + ", cvv=" + cvv + ", name=" + name
        + ", expiration=" + getExpiration() + "]";
    }

    public boolean equals(CreditCard other){ 
        // sometimes even just the cardNum would be enough here to determine equality
        return (this.name.equalsIgnoreCase(other.name) 
            && this.issuer.equals(other.issuer)
            && (this.cardNumber.equals(other.cardNumber))
            && this.cvv == other.cvv
            && this.expMonth == (other.expMonth)
            && this.expYear == (other.expYear));
                
              
    }

}
