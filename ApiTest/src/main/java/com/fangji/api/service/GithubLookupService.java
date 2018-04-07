package com.fangji.api.service;

import com.fangji.api.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

/**
 * Created by fangji on 2018/2/27.
 */
@Service
public class GithubLookupService {
    private final static Logger logger = LoggerFactory.getLogger(GithubLookupService.class);

    private RestTemplate restTemplate;

    public GithubLookupService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public CompletableFuture<User> getGithubUser(String userName) {
        logger.info("GithubLookupService getGithubUser function is invoked!!!");
        return CompletableFuture.supplyAsync(() -> {
            logger.info("supply async to get data.");
            String url = String.format("https://api.github.com/users/%s", userName);
            return restTemplate.getForObject(url, User.class);
        });
    }
}
