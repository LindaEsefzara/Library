package com.linda.Library.Security;

import com.linda.Library.Service.UserModelService;
import com.linda.Library.configurations.AppPasswordConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity                   // Enables @PreAuthorize
public class SecurityConfiguration {

    private final AppPasswordConfig bcrypt;
    private final UserModelService userModelService;

    public SecurityConfiguration(AppPasswordConfig bcrypt, UserModelService userModelService) {
        this.bcrypt = bcrypt;
        this.userModelService = userModelService;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/", "/login", "/error", "/rest/**", "/register").permitAll()
                .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .authenticationProvider(authenticationOverride());

        return http.build();
    }

    // Tell Spring Security to use OUR implementation
    public DaoAuthenticationProvider authenticationOverride() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userModelService);            // Query
        provider.setPasswordEncoder(bcrypt.bCryptPasswordEncoder()); // Encoder BCRYPT

        return provider;
    }

}
