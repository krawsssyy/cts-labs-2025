package Factories;
// --------- FACTORY METHOD
// we use this pattern to abstract away the creation of objects, providing an interface for the user to use
// leaving aside other complex details
// using this method, users can create any object of the type of the factory with some simple steps
abstract class AbstractCurrencyFactory {
    abstract CurrencyInterface getCurrency(String type, Double rate, Double initialValue);
}

class EthereumFactory extends AbstractCurrencyFactory {

    @Override
    CurrencyInterface getCurrency(String type, Double rate, Double initialValue) {
        if (type.equals("Ethereum")) {
            return new Ethereum(rate, initialValue);
        }
        else {
            throw new UnsupportedOperationException("Type unrecognized");
        }
    }
}

class EuroFactory extends AbstractCurrencyFactory {

    @Override
    CurrencyInterface getCurrency(String type, Double rate, Double initialValue) {
        if (type.equals("Euro")) {
            return new Euro(rate, initialValue);
        }
        else {
            throw new UnsupportedOperationException("Type unrecognized");
        }
    }
}
// ----- SIMPLE FACTORY
// very similar approach as to the method one, but we have a more general way of creating objects here
// the keen eyes will notice that this violates OCP
// it is true

// this used a conditional check since it was the simplest
// in reality, this would have a form similar to the registries we discussed before
// where objects would register themselves such that we don't violate OCP
// HashMap<String, Supplier<? implemenets Interface>> s = new HashMap<>();
// .... SimpleFactory s = new SimpleFactory();
// s.register("ProductA", ProductA::new);
class SimpleFactory {
    public CurrencyInterface getCurrency(String type, Double rate, Double initialValue) {
        CurrencyInterface currency = null;

        if (type.equals("ethereum")) {
            currency = new Ethereum(rate, initialValue);
        }
        else if (type.equals("euro")) {
            currency = new Euro(rate, initialValue);
        }
        else {
            throw new UnsupportedOperationException("Type unrecognized");
        }
        return currency;
    }
}
// -----
interface CurrencyInterface {
    Double calculateValue(Double rate);
}

class Ethereum implements CurrencyInterface {
    Double value;
    public Ethereum(Double rate, Double initialValue) {
        this.value = initialValue;
        this.value = calculateValue(rate);
    }
    @Override
    public Double calculateValue(Double rate) {
        return this.value * rate;
    }
    // + other specific cryptocurrency functions
}

class Euro implements CurrencyInterface {
    Double value;
    public Euro(Double rate, Double initialValue) {
        this.value = initialValue;
        this.value = calculateValue(rate);
    }
    @Override
    public Double calculateValue(Double rate) {
        return this.value * rate;
    }
    // + other specific functions
}



public class Factory {
    // -- FACTORY METHOD

    // using this pattern, we abstracted away the object creation
    // any client using this application, would just have to do the following to create an object
    EuroFactory ef = new EuroFactory();
    CurrencyInterface e = ef.getCurrency("euro", 5.04, 10.7);
    // now do stuff with it

    // -- SIMPLE FACTORY
    SimpleFactory sf = new SimpleFactory();
    CurrencyInterface eth = sf.getCurrency("ethereum", 100.12, 0.012);
    // do stuff
}

// there is another factory design pattern, which is called abstract factory
// it is the most complex of them all
// you can think of it as a SimpleFactory for the Factory Method concrete implementations
// returning the correct factory based on what we want to create
// for more complex scenarios, the code gets really big really fast
// a user would just get the correct factory via the abstract factory method and then construct whatever he wants, so from his point of view, not much changed
