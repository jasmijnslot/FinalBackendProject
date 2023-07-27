package com.example.finalbackendproject.config;

import com.example.finalbackendproject.services.CustomUserDetailsService;
import com.example.finalbackendproject.filter.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/*  Deze security is niet de enige manier om het te doen.
    In de andere branch van deze github repo staat een ander voorbeeld
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    public final CustomUserDetailsService customUserDetailsService;

    private final JwtRequestFilter jwtRequestFilter;

    private final PasswordEncoder passwordEncoder;

    public SpringSecurityConfig(CustomUserDetailsService customUserDetailsService, JwtRequestFilter jwtRequestFilter, PasswordEncoder passwordEncoder) {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
        this.passwordEncoder = passwordEncoder;
    }




    // Authenticatie met customUserDetailsService en passwordEncoder
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }



    // Authorizatie met jwt
    @Bean
    protected SecurityFilterChain filter (HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .httpBasic().disable()
                .cors().and()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/users").permitAll()
                .requestMatchers(HttpMethod.GET,"/users").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST,"/users/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
                //-----------------------------dieren----------------------------------
                .requestMatchers(HttpMethod.POST, "/dieren").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/dieren").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/dieren/{id}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/dieren").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/dieren/{id}").hasRole("ADMIN")
                //---------------------------afspraken-------------------------------
                .requestMatchers(HttpMethod.POST, "/afspraken/{dier_id}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/afspraken").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/afspraken/{id}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/afspraken/{id}").hasRole("ADMIN")
                //-----------------------------klanten------------------------------------
                .requestMatchers(HttpMethod.POST, "/klanten").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET,"/klanten").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/klanten/{id}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/klanten/{id}").hasRole("ADMIN")
                //------------------------------medicaties-------------------------------
                .requestMatchers(HttpMethod.POST, "/medicaties").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/medicaties").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/medicaties/{id}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "medicaties/{id}").hasRole("ADMIN")
                //--------------------------------paspoorten-------------------------------
                .requestMatchers(HttpMethod.POST, "/paspoorten").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/paspoorten").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/paspoorten/{id}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/paspoorten/{id}").hasRole("ADMIN")
                //-------------------------------dierenartsen-----------------------------
                .requestMatchers(HttpMethod.POST, "/dierenartsen").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/dierenartsen").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/dierenartsen/{id}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/dierenartsen/{id}").hasRole("ADMIN")


                .requestMatchers("/authenticated").authenticated()
                .requestMatchers("/authenticate").permitAll()
                .anyRequest().denyAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}