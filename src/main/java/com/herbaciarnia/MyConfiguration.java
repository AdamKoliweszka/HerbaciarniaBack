/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class MyConfiguration extends WebSecurityConfigurerAdapter {

    private static String REALM="MY_TEST_REALM";

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
            }
        };
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("tom").password("abc123").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/Herbaty/Dostepne").permitAll()
                .antMatchers(HttpMethod.POST,"/Herbaty/Dostepne").permitAll()

                .antMatchers(HttpMethod.GET,"/Herbaty/Wszystkie").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/Herbaty/Wszystkie").hasRole("ADMIN")


                .antMatchers(HttpMethod.GET,"/GatunkiHerbaty").permitAll()
                .antMatchers(HttpMethod.POST,"/GatunkiHerbaty").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/GatunkiHerbaty").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/GatunkiHerbaty").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET,"/KrajePochodzenia").permitAll()
                .antMatchers(HttpMethod.POST,"/KrajePochodzenia").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/KrajePochodzenia").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/KrajePochodzenia").hasRole("ADMIN")


                .and().httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint())
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//We don't need sessions to be created.
    }

    @Bean
    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
        return new CustomBasicAuthenticationEntryPoint();
    }

    /* To allow Pre-flight [OPTIONS] request from browser */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
}