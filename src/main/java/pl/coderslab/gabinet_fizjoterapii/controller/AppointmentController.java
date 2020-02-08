package pl.coderslab.gabinet_fizjoterapii.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.gabinet_fizjoterapii.entity.Appointment;
import pl.coderslab.gabinet_fizjoterapii.entity.Patient;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.MonthDay;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

    @GetMapping
    public String getAppointment(Model model) {
        model.addAttribute("appointment", new Appointment(new String[]{"Monday"}, new String[]{"10:00"}, 1));
        return "appointment";
    }
}

