/*
// refactor this class to adhere to the Open/Closed Principle

class Visa {
    String ibanFrom, ibanTo;
    double value;
    public Visa(String ibanFrom, String ibanTo, double value) {
        this.ibanFrom = ibanFrom;
        this.ibanTo = ibanTo;
        this.value = value;
    }
}

class Mastercard {
    String ibanFrom, ibanTo;
    double value;
    public Mastercard(String ibanFrom, String ibanTo, double value) {
        this.ibanFrom = ibanFrom;
        this.ibanTo = ibanTo;
        this.value = value;
    }
}

class Bitcoin {
    String addressFrom, addressTo;
    double rate, value;
    public Bitcoin(String addressFrom, String addressTo, double rate, double value) {
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.rate = rate;
        this.value = value;
    }
}

class Ethereum{
    String addressFrom, addressTo;
    double rate, value;
    public Ethereum(String addressFrom, String addressTo, double rate, double value) {
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.rate = rate;
        this.value = value;
    }
}
public class OCP {
    // its supposed to be a payment processor
    public void processPayment (Object payment) {
        if (payment instanceof Visa)
            System.out.println("Visa payment processed");
        else if (payment instanceof Mastercard)
            System.out.println("Mastercard payment processed");
        else if (payment instanceof Bitcoin)
            System.out.println("Bitcoin payment processed");
        else if (payment instanceof Ethereum)
            System.out.println("Ethereum payment processed");
    }
}
*/

// use an interface, as in the class example
// this is done to ensure that if we add a new payment method, we don't need to modify our existing code (hence closed for modifications)
// we will only have to add a new class (open for extension) and nothing else

interface Payment {
    void processPayment();
}

class Visa implements Payment {
    String ibanFrom, ibanTo;
    Double value;

    public Visa(String ibanFrom, String ibanTo, Double value) {
        this.ibanFrom = ibanFrom;
        this.ibanTo = ibanTo;
        this.value = value;
    }

    @Override
    public void processPayment() {
        System.out.println("Visa payment processed");
    }
}

class Mastercard implements Payment {
    String ibanFrom, ibanTo;
    Double value;

    public Mastercard(String ibanFrom, String ibanTo, Double value) {
        this.ibanFrom = ibanFrom;
        this.ibanTo = ibanTo;
        this.value = value;
    }

    @Override
    public void processPayment() {
        System.out.println("Mastercard payment processed");
    }
}

class Bitcoin implements Payment {
    String addressFrom, addressTo;
    Double rate, value;

    public Bitcoin(String addressFrom, String addressTo, Double rate, Double value) {
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.rate = rate;
        this.value = value;
    }

    @Override
    public void processPayment() {
        System.out.println("Bitcoin payment processed");
    }
}

class Ethereum implements Payment {
    String addressFrom, addressTo;
    Double rate, value;

    public Ethereum(String addressFrom, String addressTo, Double rate, Double value) {
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.rate = rate;
        this.value = value;
    }

    @Override
    public void processPayment() {
        System.out.println("Ethereum payment processed");
    }
}

public class OCP {

    public void processPayment(Payment payment) {
        payment.processPayment();
    }
}