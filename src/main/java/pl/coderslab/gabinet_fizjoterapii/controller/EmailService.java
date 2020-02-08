package pl.coderslab.gabinet_fizjoterapii.controller;

public class EmailService implements MessageService {

    @Override
    public void send(String message) {
        System.out.println("E-mail has been sent: " + message);
    }
}
