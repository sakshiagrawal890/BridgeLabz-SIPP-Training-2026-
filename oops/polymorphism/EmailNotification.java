// EmailNotification subclass

public class EmailNotification extends Notification {
    
    public EmailNotification(String recipientName, String message) {
        super(recipientName, message);
    }
    
    @Override
    public void sendNotification() {
        System.out.print("📧 EMAIL SENT - ");
        displayDetails("EMAIL");
        System.out.println("   └─ Delivered to inbox with standard priority");
    }
}
