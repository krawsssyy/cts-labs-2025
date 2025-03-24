package interfaces;

public interface DiscountStrategy {
    Double applyDiscount(Double amount);
    String getDescription();
}
