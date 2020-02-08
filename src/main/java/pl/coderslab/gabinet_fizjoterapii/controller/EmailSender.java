package pl.coderslab.gabinet_fizjoterapii.controller;

public class EmailSender {

    private String message;
    private MessageService messageService;

    public EmailSender(String message, MessageService messageService) {
        this.message = message;
        this.messageService = messageService;
    }

    public void sendMessage() {
        messageService.send(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
