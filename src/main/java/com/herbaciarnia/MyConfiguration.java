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

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class MyConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

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
        auth.jdbcAuthentication().dataSource(dataSource);
        //auth.inMemoryAuthentication().withUser("bill").password("abc123").authorities("ADMIN");// roles("ADMIN");
        //auth.inMemoryAuthentication().withUser("tom").password("abc123").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/Login").hasAnyAuthority("PRACOWNIK","KLIENT")
                .antMatchers(HttpMethod.GET,"/Herbaty/Dostepne").permitAll()
                .antMatchers(HttpMethod.POST,"/Herbaty/Dostepne").permitAll()

                .antMatchers(HttpMethod.GET,"/Herbaty/Wszystkie").hasAuthority("PRACOWNIK")// hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/Herbaty/Wszystkie").hasAuthority("PRACOWNIK")


                .antMatchers(HttpMethod.GET,"/GatunkiHerbaty").permitAll()
                .antMatchers(HttpMethod.POST,"/GatunkiHerbaty").hasAuthority("PRACOWNIK")
                .antMatchers(HttpMethod.DELETE,"/GatunkiHerbaty").hasAuthority("PRACOWNIK")
                .antMatchers(HttpMethod.PUT,"/GatunkiHerbaty").hasAuthority("PRACOWNIK")

                .antMatchers(HttpMethod.GET,"/KrajePochodzenia").permitAll()
                .antMatchers(HttpMethod.POST,"/KrajePochodzenia").hasAuthority("PRACOWNIK")
                .antMatchers(HttpMethod.DELETE,"/KrajePochodzenia").hasAuthority("PRACOWNIK")
                .antMatchers(HttpMethod.PUT,"/KrajePochodzenia").hasAuthority("PRACOWNIK")


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