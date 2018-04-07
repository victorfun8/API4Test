package com.fangji.api.web;

import com.fangji.api.domain.Greeting;
import com.fangji.api.form.PersonForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Created by fangji on 2018/2/26.
 */
@Controller
public class ValidatingFormController extends WebMvcConfigurerAdapter{

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/validateForm")
    public String showForm(PersonForm personForm) {
        return "form";
    }

    @PostMapping("/validateForm")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        return "redirect:/results";
    }

    @GetMapping("/testForm")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/testForm")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        return "greetingResult";
    }
}
