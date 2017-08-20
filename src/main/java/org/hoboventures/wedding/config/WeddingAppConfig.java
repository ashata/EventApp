package org.hoboventures.wedding.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ErrorPageRegistrar;
import org.springframework.boot.web.servlet.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * Created by Asha on 12/2/2016.
 */
@Configuration
public class WeddingAppConfig {

    private static final Logger logger = LoggerFactory.getLogger(WeddingAppConfig.class);

    @Bean
    public JavaMailSender mailSender(){
        return new JavaMailSenderImpl();
    }

    @Bean
    public ErrorPageRegistrar errorPageRegistrar(){
        return new EventErrorPageRegistrar();
    }

    private static class EventErrorPageRegistrar implements ErrorPageRegistrar {

        // Register your error pages and url paths.
        @Override
        public void registerErrorPages(ErrorPageRegistry registry) {
            registry.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/error"));
            registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error"));
        }

    }
}
