package interfaces;
import main.ShoppingCart;

public interface ReceiptPrinter {
    // generalized for any type of item we would want to print a receipt for
    void printReceipt(ShoppingCart cart);
}
