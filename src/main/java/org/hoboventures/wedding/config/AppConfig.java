package org.hoboventures.wedding.config;

import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Asha on 12/2/2016.
 */
@SpringBootApplication
@EnableAutoConfiguration
@PropertySource("classpath:weddingApp.properties")
//@PropertySource("classpath:weddingApp-local.properties")
@EnableTransactionManagement
@EnableMongoRepositories("org.hoboventures.wedding.dao")
@ComponentScan({"org.hoboventures.wedding", "org.hoboventures.wedding.config",
                "org.hoboventures.wedding.web","org.hoboventures.wedding.dao",
                "org.hoboventures.wedding.service",
                "org.hoboventures.wedding.service.impl", "org.hoboventures.wedding.util"}
                )
@EnableMetrics
@EnableSwagger2
@EnableMongoAuditing
@EnableWebMvc
@EnableCaching
public class AppConfig extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(AppConfig.class, args);
    }

    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        return builder.sources(AppConfig.class, WeddingAppConfig.class).bannerMode(Banner.Mode.OFF);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        setRegisterErrorPageFilter(false);
        return configureApplication(builder);
    }
}
