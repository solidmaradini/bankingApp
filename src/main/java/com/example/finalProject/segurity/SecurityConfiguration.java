package com.example.finalProject.segurity;


import com.example.finalProject.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConf) throws  Exception{
        return authConf.getAuthenticationManager();
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.httpBasic();

        httpSecurity.authorizeRequests()
                .mvcMatchers(HttpMethod.GET,"/users").hasAnyRole("HOLDER")
                .mvcMatchers(HttpMethod.POST, "/account-holder/**").hasRole("HOLDER")
                .mvcMatchers(HttpMethod.PUT, "/change-status/**").hasRole("HOLDER")
                .mvcMatchers(HttpMethod.PATCH, "/transfer/**").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.DELETE, "/delete-account/**").hasRole("ADMIN")
//                .mvcMatchers(HttpMethod.POST,"/holder").hasAnyRole("ADMIN")
                .mvcMatchers(HttpMethod.GET,"/admin/**").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST,"/third-party/**").hasRole("THIRD")
                .anyRequest().permitAll();

        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }
}
