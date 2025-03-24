package Exercicio01;

public class Main {
    public static void main(String[] args) {
        Notification emailNotification = NotificationFactory.createNotification("email");
        emailNotification.send("Seu pedido foi confirmado!");

        Notification smsNotification = NotificationFactory.createNotification("sms");
        smsNotification.send("Seu código de verificação é 1234");
    }
}