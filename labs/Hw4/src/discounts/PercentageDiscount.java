package discounts;
import interfaces.DiscountStrategy;

public class PercentageDiscount implements DiscountStrategy {
    private Double percentage;

    public PercentageDiscount(Double percentage) {
        this.percentage = percentage;
    }

    @Override
    public Double applyDiscount(Double amount) {
        return amount * (1 - this.percentage);
    }

    @Override
    public String getDescription() {
        return "Percentage Discount: " + (this.percentage * 100) + "%";
    }
}