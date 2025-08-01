package com.security.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity

public class SecurityConfig {

   @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http

               .authorizeHttpRequests(auth->auth
                       .requestMatchers("/login").permitAll()
                       .requestMatchers("/Admin/**").hasRole("ADMIN")
                       .requestMatchers("/User/**").hasRole("USER")

                       .anyRequest().authenticated())
               .formLogin(form -> form
                       .loginPage("/login")
                       .loginProcessingUrl("/login")
                       .defaultSuccessUrl("/after-login", true)  // ← أو أي صفحة انتِ عاوزاها بعد اللوجين
                       .permitAll()
               )
       ;
       return http.build();
   }
   @Bean
    public UserDetailsService userDetailsService() {
      return new InMemoryUserDetailsManager(
              User.builder()
                      .username("hanaz")
                      .password("{noop}hanaz123")
                      .roles("USER")
                      .build(),
              User.withUsername("Ali")
                      .password("{noop}Ali123")
                      .roles("ADMIN")
                      .build()

      );
   }
}

