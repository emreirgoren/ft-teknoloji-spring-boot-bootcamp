package com.patika.bloghubservicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BloghubServiceDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BloghubServiceDiscoveryApplication.class, args);
    }

}
