/*
Refactor the following code to adhere to all clean coding principles (DRY, KISS, YAGNI, SOLID)
Also, organize your project in separate directories for each required type of class


class main.ShoppingCart {
    private String[] it = new String[100];
    private double[] pr = new double[100];
    private int[] quants = new int[100];
    private int cbItms = 0;
    private double ttlPr = 0;
    private double tax = 0.1;
    private boolean discUser = false;
    private double discR = 0.0;
    private boolean specCust = false;
    private double lltPts = 0;
    private int specCustD = 0;
    private String na;
    private String em;
    private String noTlf;
    private String addr;
    public main.ShoppingCart(String na, String em, String noTlf, String addr) {
        this.na = na;
        this.em = em;
        this.noTlf = noTlf;
        this.addr = addr;
    }
    public void additem(String item, double price, int quantity) {
        for (int i = 0; i < this.cbItms; i++)
            if (it[i].equals(item)) {
                quants[i] += quantity;
                calcTtl();
                return;
            }
        this.it[cbItms] = item;
        this.pr[this.cbItms] = price;
        this.quants[cbItms] = quantity;
        cbItms++;
        calcTtl();
    }
    public void remitem(String item) {
        for (int i = 0; i < this.cbItms; i++)
            if (this.it[i].equals(item)) {
                for (int j = i; j < this.cbItms - 1; j++) {
                    this.it[j] = this.it[j + 1];
                    this.pr[j] = this.pr[j + 1];
                    quants[j] = quants[j + 1];
                }
                cbItms--;
                this.calcTtl();
                return;
            }
    }
    public void apldisc(double discountRate) {
        this.discR = discountRate;
        discUser = true;
        calcTtl();
    }
    public void makecustspec() {
        this.specCust = true;
        calcTtl();
    }
    public void calcTtl() {
        this.ttlPr = 0;
        for (int i = 0; i < this.cbItms; i++)
            ttlPr += this.pr[i] * this.quants[i];
        if (this.discUser)
            ttlPr = this.ttlPr * (1 - discR);
        if (this.specCust)
            this.ttlPr = this.ttlPr * 0.85;
        ttlPr = this.ttlPr * (1 + tax);
    }
    public void printrec() {
        System.out.println("Receipt for " + this.na);
        System.out.println("Contact: " + this.em + " | " + noTlf);
        System.out.println("Address: " + addr);
        System.out.println("----------------------------------------");
        for (int i = 0; i < this.cbItms; i++) {
            double itemTotal = this.pr[i] * this.quants[i];
            System.out.println(this.it[i] + " x " + this.quants[i] + " @ $" + this.pr[i] + " = $" + itemTotal);
        }
        System.out.println("----------------------------------------");
        System.out.println("Subtotal: $" + (this.ttlPr / (1 + this.tax)));
        if (discUser)
            System.out.println("Discount: " + (this.discR * 100) + "%");
        if (specCust)
            System.out.println("Special Customer Discount: 15%");
        System.out.println("Tax: $" + (ttlPr - (ttlPr / (1 + this.tax))));
        System.out.println("Total: $" + this.ttlPr);
    }
    public void printdetreport() {
        this.printrec();
        System.out.println("----------------------------------------");
        System.out.println("Detailed Analysis:");
        System.out.println("Number of items: " + cbItms);
        System.out.println("Average price per item: $" + (ttlPr / cbItms));
        System.out.println("Most expensive item: " + this.mostExpItm());
    }
    private String mostExpItm() {
        if (this.cbItms == 0) return "No items";
        double maxPrice = this.pr[0];
        int maxIndex = 0;
        for (int i = 1; i < this.cbItms; i++)
            if (pr[i] > maxPrice) {
                maxPrice = pr[i];
                maxIndex = i;
            }
        return this.it[maxIndex] + " ($" + maxPrice + ")";
    }
    public void updcust(String customerName, String customerEmail, String customerPhone, String customerAddress) {
        this.na = customerName;
        this.em = customerEmail;
        this.noTlf = customerPhone;
        this.addr = customerAddress;
    }
    public void changepric(String item, double newPrice) {
        for (int i = 0; i < this.cbItms; i++)
            if (this.it[i].equals(item)) {
                this.pr[i] = newPrice;
                calcTtl();
                return;
            }
    }
    public double calcship() {
        return ttlPr * 0.05;
    }
    public void calclyty() {
        if (specCust)
            this.lltPts += specCustD * 0.05;
    }
}*/


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}