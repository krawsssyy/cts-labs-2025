// base classes
class LegacySystem {
    public void pay(Double amount) {
        System.out.println("Payed " + amount + " using legacy system!");
    }
}

interface ModernPayment {
    void makePay(PaymentDetails details);
}

class PaymentDetails {
    public String to, from;
    public Double amount;

    PaymentDetails(String to, String from, Double amount) {
        this.to = to;
        this.from = from;
        this.amount = amount;
    }
}

class ModernSystem implements ModernPayment {

    @Override
    public void makePay(PaymentDetails details) {
        System.out.println("Payed " + details.amount + " from " + details.from + " to "
                + details.to + " using modern system");
    }
}

class Store {
    private final ModernPayment method;

    public Store(ModernPayment method) {
        this.method = method;
    }

    public void makePay(PaymentDetails details) {
        this.method.makePay(details);
    }
}

// adapter, to make the legacy class work with the new interface
// the point of this design pattern is to showcase an easy and clean way of adapting older classes to other interfaces
// this can either be legacy systems (as in this case), or pure classes that were not initially designed to work with each other, but are required to now
class LegacyAdapter implements ModernPayment {
    private final LegacySystem legacy;
    // it is as simple as it sounds
    // we just create another class that uses the "modern" interface, and we adapt the interface methods to work with the legacy system
    public LegacyAdapter (LegacySystem system) {
        this.legacy = system;
    }

    @Override
    public void makePay(PaymentDetails details) {
        // adapt the makePay method to work with the legacy system
        this.legacy.pay(details.amount);
    }

}

public class Main {
    public static void main(String[] args) {
        PaymentDetails pd = new PaymentDetails("bank1", "bank2", 10.0);

        LegacySystem system = new LegacySystem();
        LegacyAdapter adapter = new LegacyAdapter(system);
        Store storeLegacy = new Store(adapter);
        storeLegacy.makePay(pd); // pay using the legacy system

        ModernSystem modern = new ModernSystem();
        Store storeModern = new Store(modern);
        storeModern.makePay(pd); // pay using the new modern system, still using the same interface
    }
}