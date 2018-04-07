package com.fangji.api.web;

import com.fangji.api.domain.User;
import com.fangji.api.service.GithubLookupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.ExecutionException;

/**
 * Created by fangji on 2018/2/27.
 */
@Controller
public class AsyncThreadController {
    private final static Logger log = LoggerFactory.getLogger(AsyncThreadController.class);

    @Autowired
    private GithubLookupService githubLookupService;

    @GetMapping("/getGithubUser")
    public String getGithubUser(Model userName) {
        userName.addAttribute("user", new User());
        return "getGithubUser";
    }

    @PostMapping("/displayGithubUser")
    public String displayGithubUser(@ModelAttribute User user, Model userModel) {
        User user2 = null;
        try {
            user2 = githubLookupService.getGithubUser(user.getName()).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "greeting";
        } catch (ExecutionException e) {
            e.printStackTrace();
            return "greeting";
        }
        if(user2 == null || user2.getName() == null || user2.getName().equals("")) {
            user2 = new User();
            user2.setName("test");
            user2.setBlog("hahahaha ");
        }
        userModel.addAttribute("user", user2);
        return "displayGithubUser";
    }
}
