package models;

public class Customer {
    // not making these attributes final leaves the class open for extension (in case we will implement something that will require updating of customer info)
    // at this point, the shopping cart's attribution isn't to update customer info
    private String name;
    private String email;
    private String phone;
    private String address;

    public Customer(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getAddress() {
        return this.address;
    }
}