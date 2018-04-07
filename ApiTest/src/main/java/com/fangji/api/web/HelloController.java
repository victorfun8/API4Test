package com.fangji.api.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fangji on 2018/2/22.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String login() {
        return "Greetings from Spring boot!";
    }
}
