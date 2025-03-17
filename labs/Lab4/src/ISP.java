 /*
1. Interface Segregation Principle
Fix the following code to make it adhere to ISP (remove over generalized interface and change it to multiple very specialized ones)

interface DeviceOperations {
    void powerOn();
    void powerOff();
    void print(String document);
    void scan(String content);
    void fax(String content, String destination);
    void connectToWifi(String network, String password);
}

class Printer implements DeviceOperations {
    @Override
    public void powerOn() {
        System.out.println("Printer powered on");
    }

    @Override
    public void powerOff() {
        System.out.println("Printer powered off");
    }

    @Override
    public void print(String document) {
        System.out.println("Printing: " + document);
    }

    @Override
    public void scan(String content) {
        throw new UnsupportedOperationException("This printer cannot scan");
    }

    @Override
    public void fax(String content, String destination) {
        throw new UnsupportedOperationException("This printer cannot fax");
    }

    @Override
    public void connectToWifi(String network, String password) {
        System.out.println("Connecting printer to WiFi: " + network);
    }
}

class Scanner implements DeviceOperations {
    @Override
    public void powerOn() {
        System.out.println("Scanner powered on");
    }

    @Override
    public void powerOff() {
        System.out.println("Scanner powered off");
    }

    @Override
    public void print(String document) {
        throw new UnsupportedOperationException("This scanner cannot print");
    }

    @Override
    public void scan(String content) {
        System.out.println("Scanning: " + content);
    }

    @Override
    public void fax(String content, String destination) {
        throw new UnsupportedOperationException("This scanner cannot fax");
    }

    @Override
    public void connectToWifi(String network, String password) {
        System.out.println("Connecting scanner to WiFi: " + network);
    }
}

class AllInOnePrinter implements DeviceOperations {
    @Override
    public void powerOn() {
        System.out.println("All-in-one device powered on");
    }

    @Override
    public void powerOff() {
        System.out.println("All-in-one device powered off");
    }

    @Override
    public void print(String document) {
        System.out.println("All-in-one printing: " + document);
    }

    @Override
    public void scan(String content) {
        System.out.println("All-in-one scanning: " + content);
    }

    @Override
    public void fax(String content, String destination) {
        System.out.println("All-in-one faxing: " + content + " to " + destination);
    }

    @Override
    public void connectToWifi(String network, String password) {
        System.out.println("Connecting all-in-one device to WiFi: " + network);
    }
}*/

public class ISP {
    ;
}

// create an interface for each appropriate type of action, thus specializing each interface as much as possible
interface PowerOperations {
    void powerOn();
    void powerOff();
}

interface PrintOperations {
    void print(String document);
}

interface ScanOperations {
    void scan(String content);
}

interface FaxOperations {
    void fax(String content, String destination);
}

interface NetworkOperations {
    void connectToWifi(String network, String password);
}

// each class will then implement only the required interfaces, thus removing unnecessary generalizations made
class Printer implements PowerOperations, PrintOperations, NetworkOperations {
    @Override
    public void powerOn() {
        System.out.println("Printer powered on");
    }

    @Override
    public void powerOff() {
        System.out.println("Printer powered off");
    }

    @Override
    public void print(String document) {
        System.out.println("Printing: " + document);
    }

    @Override
    public void connectToWifi(String network, String password) {
        System.out.println("Connecting printer to WiFi: " + network);
    }
}

class Scanner implements PowerOperations, ScanOperations, NetworkOperations {
    @Override
    public void powerOn() {
        System.out.println("Scanner powered on");
    }

    @Override
    public void powerOff() {
        System.out.println("Scanner powered off");
    }

    @Override
    public void scan(String content) {
        System.out.println("Scanning: " + content);
    }

    @Override
    public void connectToWifi(String network, String password) {
        System.out.println("Connecting scanner to WiFi: " + network);
    }
}

class AllInOnePrinter implements PowerOperations, PrintOperations, ScanOperations,
        FaxOperations, NetworkOperations {
    @Override
    public void powerOn() {
        System.out.println("All-in-one device powered on");
    }

    @Override
    public void powerOff() {
        System.out.println("All-in-one device powered off");
    }

    @Override
    public void print(String document) {
        System.out.println("All-in-one printing: " + document);
    }

    @Override
    public void scan(String content) {
        System.out.println("All-in-one scanning: " + content);
    }

    @Override
    public void fax(String content, String destination) {
        System.out.println("All-in-one faxing: " + content + " to " + destination);
    }

    @Override
    public void connectToWifi(String network, String password) {
        System.out.println("Connecting all-in-one device to WiFi: " + network);
    }
}
