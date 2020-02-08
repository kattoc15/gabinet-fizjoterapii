package pl.coderslab.gabinet_fizjoterapii.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.gabinet_fizjoterapii.dto.PersonDTO;
import pl.coderslab.gabinet_fizjoterapii.entity.Patient;
import pl.coderslab.gabinet_fizjoterapii.repository.PersonRepository;
import pl.coderslab.gabinet_fizjoterapii.session.PersonSession;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    private final PersonSession personSession;

    public PersonController(PersonRepository personRepository, PasswordEncoder passwordEncoder, PersonSession personSession) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
        this.personSession = personSession;
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("patient", new Patient());
        return "form/registration";
    }

    @PostMapping("/register")
    public String postRegister(@Valid Patient patient, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            return "form/registration";
        }
        if (personRepository.existsPersonByEmail(patient.getEmail())) {
            result.addError(new FieldError("patient", "email", "E-mail is already taken"));
            return "form/registration";
        }

        String encodedPassword = passwordEncoder.encode(patient.getPassword());
        patient.setPassword(encodedPassword);
        personRepository.save(patient);
        personSession.setEmail(patient.getEmail());

        Cookie cookie = new Cookie("log", "Patient");
        cookie.setMaxAge(60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);

        if (!(personSession.getReserve() == null)) {
            return "redirect:../reserve";
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginGet(Model model) {
        model.addAttribute("personDTO", new PersonDTO());
        return "form/login";
    }

    @PostMapping("/login")
    public String loginPost(@Valid PersonDTO personDTO, BindingResult result, HttpServletResponse response) {

        if (result.hasErrors()) {
            return "form/login";
        }

        String codedPassword = personRepository.findPasswordByEmail(personDTO.getEmail());
        if (passwordEncoder.matches(personDTO.getPassword(), codedPassword)) {
            personSession.setEmail(personDTO.getEmail());

            Cookie cookie = new Cookie("log", personRepository.findPersonByEmail(personDTO.getEmail()).getClass().getSimpleName());
            cookie.setMaxAge(60 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);

            if (!(personSession.getReserve() == null)) {


                return "redirect:../reserve";
            }
            return "redirect:/";
        } else {
            result.addError(new ObjectError("personDTO", "Incorrect e-mail or password!"));
        }

        return "form/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        personSession.setEmail(null);
        personSession.setReserveAsk(null);
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            System.out.println(c.getName() + " " + c.getValue() + " " + c.getMaxAge());
        }
        String cookieName = "log";
        for (Cookie c : cookies) {
            if (cookieName.equals(c.getName())) {
                c.setPath("/");
                c.setValue("false");
                c.setMaxAge(0);
                response.addCookie(c);
            }
        }


        return "redirect:/";
    }
}
