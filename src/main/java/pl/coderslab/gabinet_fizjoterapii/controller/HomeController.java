package pl.coderslab.gabinet_fizjoterapii.controller;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.gabinet_fizjoterapii.session.PersonSession;

@RestController
@RequestMapping("/")
public class HomeController {

    private final PersonSession personSession;

    public HomeController(PersonSession personSession) {
        this.personSession = personSession;
    }

    @GetMapping
    public String hello() {
        return "index";
    }

    @GetMapping("/")
    public String home(Model model) {

        if (personSession.getEmail() == null) {
            model.addAttribute("log", false);
        } else {
            model.addAttribute("log", true);
        }

        return "index";
    }


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("email.xml");

        EmailSender emailSenderBean = (EmailSender) context.getBean("emailSender");
        System.out.println(emailSenderBean.getMessage());

        EmailSender emailSenderAsClass = context.getBean(EmailSender.class);
        System.out.println(emailSenderAsClass.getMessage());
        System.out.println(emailSenderAsClass == emailSenderBean);

        emailSenderAsClass.sendMessage();
        context.close();
    }
}