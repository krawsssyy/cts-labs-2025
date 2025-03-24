package main;

import calculators.TaxCalculator;
import interfaces.DiscountStrategy;
import models.Customer;
import models.Item;

import java.util.*;

public class ShoppingCart {
    private List<Item> items;
    private Customer customer;
    private List<DiscountStrategy> discounts;
    private TaxCalculator taxCalculator;

    public ShoppingCart(Customer customer, TaxCalculator taxCalculator) {
        this.customer = customer;
        this.taxCalculator = taxCalculator;
        this.items = new ArrayList<>();
        this.discounts = new ArrayList<>();
    }

    public void addItem(Item item) {
        for (Item existingItem : this.items) {
            if (existingItem.getName().equals(item.getName())) {
                existingItem.incrementQuantity(item.getQuantity());
                return;
            }
        }
        this.items.add(item);
    }

    public void removeItem(String itemName) {
        this.items.removeIf(item -> item.getName().equals(itemName));
    }

    public void addDiscount(DiscountStrategy discount) {
        this.discounts.add(discount);
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (Item item : this.items) {
            subtotal += item.getTotal();
        }
        return subtotal;
    }

    public double getDiscountedSubtotal() {
        double discountedSubtotal = getSubtotal();
        for (DiscountStrategy discount : this.discounts) {
            discountedSubtotal = discount.applyDiscount(discountedSubtotal);
        }
        return discountedSubtotal;
    }

    public double getTaxAmount() {
        return this.taxCalculator.calculateTax(getDiscountedSubtotal());
    }

    public double getTotal() {
        return this.getDiscountedSubtotal() + this.getTaxAmount();
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public List<Item> getItems() {
        return new ArrayList<>(this.items);
    }

    public List<DiscountStrategy> getDiscounts() {
        return new ArrayList<>(this.discounts);
    }

    public void changeItemPrice(String itemName, Double newPrice) {
        for (Item item : this.items) {
            if (item.getName().equals(itemName)) {
                item.setPrice(newPrice);
                return;
            }
        }
    }
}