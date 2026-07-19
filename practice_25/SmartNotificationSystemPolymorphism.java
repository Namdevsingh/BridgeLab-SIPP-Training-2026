public class SmartNotificationSystemPolymorphism {

    static class Notification {
        String recipientName;
        String message;

        Notification(String recipientName, String message) {
            this.recipientName = recipientName;
            this.message = message;
        }

        void sendNotification() {
            System.out.print("Notification to " + recipientName + ": " + message);
        }
    }

    static class EmailNotification extends Notification {
        EmailNotification(String recipientName, String message) {
            super(recipientName, message);
        }

        void sendNotification() {
            System.out.print("Email to " + recipientName + " | " + message);
        }
    }

    static class SMSNotification extends Notification {
        SMSNotification(String recipientName, String message) {
            super(recipientName, message);
        }

        void sendNotification() {
            System.out.print("SMS to " + recipientName + " | " + message);
        }
    }

    static class PushNotification extends Notification {
        PushNotification(String recipientName, String message) {
            super(recipientName, message);
        }

        void sendNotification() {
            System.out.print("Push to " + recipientName + " | " + message);
        }
    }

    public static void main(String[] args) {
        Notification[] notifications = new Notification[5];
        notifications[0] = new EmailNotification("Rahul", "Your package is delivered");
        notifications[1] = new SMSNotification("Anita", "OTP: 1234");
        notifications[2] = new PushNotification("Kiran", "New offer available");
        notifications[3] = new EmailNotification("Sara", "Weekly report ready");
        notifications[4] = new SMSNotification("Naveen", "Meeting at 3 PM");

        for (Notification n : notifications) {
            n.sendNotification();
            System.out.print("\n---\n");
        }
    }
}

