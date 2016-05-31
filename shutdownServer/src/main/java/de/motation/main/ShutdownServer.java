package de.motation.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by motation on 31.05.16.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("de.motation")
public class ShutdownServer {
    public static void main(String[] args) {
        SpringApplication.run(ShutdownServer.class, args);
    }
}
