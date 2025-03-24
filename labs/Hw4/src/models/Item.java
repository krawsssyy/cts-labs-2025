package models;

public class Item {
    private final String name;
    private Double price;
    private Integer quantity;

    public Item(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity(Integer amount) {
        this.quantity += amount;
    }

    public Double getTotal() {
        return this.price * this.quantity;
    }
}