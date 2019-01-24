package com.learn.oauth;

import com.learn.oauth.appuser.User;
import com.learn.oauth.appuser.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learn.oauth.fallback.MyFallback;
import java.util.List;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class OauthApplication {
    public static void main(String[] args) {
            SpringApplication.run(OauthApplication.class, args);
    }

    @Bean
    public FallbackProvider fallbackProvider(){
        return new MyFallback();
    }
}

