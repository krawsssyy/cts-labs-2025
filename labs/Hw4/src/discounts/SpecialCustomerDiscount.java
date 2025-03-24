package discounts;
import interfaces.DiscountStrategy;

public class SpecialCustomerDiscount implements DiscountStrategy {
    private static final double SPECIAL_DISCOUNT = 0.15;

    @Override
    public Double applyDiscount(Double amount) {
        return amount * (1 - SPECIAL_DISCOUNT);
    }

    @Override
    public String getDescription() {
        return "Special Customer Discount: 15%";
    }
}