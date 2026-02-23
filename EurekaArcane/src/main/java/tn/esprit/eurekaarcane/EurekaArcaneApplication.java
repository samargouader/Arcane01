package tn.esprit.eurekaarcane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaArcaneApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaArcaneApplication.class, args);
    }

}
