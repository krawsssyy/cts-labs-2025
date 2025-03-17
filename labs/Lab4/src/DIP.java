 import java.util.*;
/*
2. Dependency Inversion Principle
Fix the following code to adhere to DIP (remove implementation specific usages of low level functionalities and make them general)

// specific implementation of low-level modules
class EmailSender {
    public void sendEmail(String recipient, String subject, String message) {
        System.out.println("Sending email to " + recipient + " with subject: " + subject);
        System.out.println("Message: " + message);
    }
}

class SmsSender {
    public void sendSms(String phoneNumber, String message) {
        System.out.println("Sending SMS to " + phoneNumber);
        System.out.println("Message: " + message);
    }
}

// high-level module that directly uses specific implementations of low-level ones
class NotificationService {
    private EmailSender emailSender;
    private SmsSender smsSender;

    public NotificationService() {
        this.emailSender = new EmailSender();
        this.smsSender = new SmsSender();
        // tight coupling due to direct usage of specific modules
    }

    public void sendNotification(String to, String body, String message, String channel) {
        if ("email".equals(channel)) {
            emailSender.sendEmail(to, subject, message);
        } else if ("sms".equals(channel)) {
            // also violates OCP
            smsSender.sendSms(to, message);
        } else {
            throw new IllegalArgumentException("Unsupported notification channel: " + channel);
        }
    }
}
*/

public class DIP {
    ;
}

// make notifications an interface
interface NotificationChannel {
    void sendNotification(String recipient, String subject, String message);
    String getChannelType();
}

// now the low-level modules depend on interfaces, rather than being their own implementations
class EmailNotificationChannel implements NotificationChannel {
    @Override
    public void sendNotification(String recipient, String subject, String message) {
        System.out.println("Sending email to " + recipient + " with subject: " + subject);
        System.out.println("Message: " + message);
    }

    @Override
    public String getChannelType() {
        return "email";
    }
}

class SmsNotificationChannel implements NotificationChannel {
    @Override
    public void sendNotification(String recipient, String subject, String message) {
        System.out.println("Sending SMS to " + recipient);
        System.out.println("Message: " + message);
    }

    @Override
    public String getChannelType() {
        return "sms";
    }
}

// high-level module that depends on abstractions
class NotificationService {
    private final Map<String, NotificationChannel> channels;

    public NotificationService() {
        this.channels = new HashMap<>();
    }

    public void registerChannel(NotificationChannel channel) {
        // dependency injection of the abstractions, instead of specific implementations
        channels.put(channel.getChannelType(), channel);
    }

    public void sendNotification(String recipient, String subject, String message, String channelType) {
        NotificationChannel channel = channels.get(channelType);

        if (channel == null) {
            throw new IllegalArgumentException("Unsupported notification channel: " + channelType);
        }

        channel.sendNotification(recipient, subject, message);
    }
}
