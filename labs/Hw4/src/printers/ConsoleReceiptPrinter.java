package printers;
import interfaces.DiscountStrategy;
import interfaces.ReceiptPrinter;
import main.ShoppingCart;
import models.Customer;
import models.Item;

public class ConsoleReceiptPrinter implements ReceiptPrinter {
    @Override
    public void printReceipt(ShoppingCart cart) {
        Customer customer = cart.getCustomer();
        System.out.println("Receipt for " + customer.getName());
        System.out.println("Contact: " + customer.getEmail() + " | " + customer.getPhone());
        System.out.println("Address: " + customer.getAddress());
        System.out.println("----------------------------------------");

        for (Item item : cart.getItems()) {
            System.out.println(item.getName() + " x " + item.getQuantity() +
                    " @ $" + item.getPrice() + " = $" + item.getTotal());
        }

        System.out.println("----------------------------------------");
        System.out.println("Subtotal: $" + cart.getSubtotal());

        for (DiscountStrategy discount : cart.getDiscounts()) {
            System.out.println(discount.getDescription());
        }

        System.out.println("Tax: $" + cart.getTaxAmount());
        System.out.println("Total: $" + cart.getTotal());
    }
}