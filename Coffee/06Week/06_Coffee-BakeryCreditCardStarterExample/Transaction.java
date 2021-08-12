import java.time.LocalDate;

public class Transaction {
    private String vendor;
    private double amountCharged;
    private LocalDate date;
    /**
     * @param vendor
     * @param amountCharged
     * @param date
     */
    public Transaction(String vendor, double amountCharged, LocalDate date) {
        this.vendor = vendor;
        this.amountCharged = amountCharged;
        this.date = date;
    }
    
    /**
     * Creates a transaction item with given today and today's date
     * @param vendor
     * @param amountCharged
     */
    public Transaction(String vendor, double amountCharged) {
        this(vendor, amountCharged, LocalDate.now());
    }

    
    @Override
    public String toString() {
        return "Transaction [vendor=" + vendor + ", amountCharged=" + amountCharged + ", date=" + date + "]";
    }
    
    public boolean equals(Transaction other) {
        return this.vendor.equalsIgnoreCase(other.vendor)
                && Math.abs(this.amountCharged-other.amountCharged) < .001
                && this.date.equals(other.date);
    }

    /**
     * @return the vendor
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * @return the amountCharged
     */
    public double getAmountCharged() {
        return amountCharged;
    }

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }
    
    
}
