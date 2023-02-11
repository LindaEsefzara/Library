package com.linda.Library.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppPasswordConfig {
    @Bean
    public static PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(14); // Strength: 4-30 // Standard: 10
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
