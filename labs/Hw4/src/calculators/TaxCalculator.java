package calculators;

public class TaxCalculator {
    private Double taxRate;

    public TaxCalculator(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Double calculateTax(Double amount) {
        return amount * this.taxRate;
    }

    public Double getRate() {
        return this.taxRate;
    }
}