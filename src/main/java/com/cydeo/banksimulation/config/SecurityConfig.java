package com.cydeo.banksimulation.config;

import com.cydeo.banksimulation.service.SecurityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    private final AuthSuccessHandler authSuccessHandler;
    private final SecurityService securityService;

    public SecurityConfig(AuthSuccessHandler authSuccessHandler, SecurityService securityService) {
        this.authSuccessHandler = authSuccessHandler;
        this.securityService = securityService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests()
                .antMatchers("/account/**").hasAuthority("Admin")
                .antMatchers("/transaction/**").hasAnyAuthority("Admin","Cashier")
                .antMatchers(
                        "/",
                        "/login"
                ).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(authSuccessHandler)
                .failureUrl(("/login?error=true"))
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .and()
                .rememberMe()
                .tokenValiditySeconds(150)
                .key("bankapp")
                .userDetailsService(securityService)
                .and().build();
    }
}
