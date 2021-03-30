package com.global.gcmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GcmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GcmanagerApplication.class, args);
    }

}
