package com.example.springSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MyAppConfig extends WebSecurityConfigurerAdapter{
 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 auth.inMemoryAuthentication().withUser("tech").password("$2y$10$Y2yTbBquKy7CmGhM.q4NH.1iX8R19rEEQHrxmWXZ8Hjzf7R77KbF6").roles("Student")
	 .and().withUser("hunt").password("$2y$10$IDPUEvFrD7krzKNHl3rgc.4eJBH56wZSZ9UhKmC7XXLNmM3weHLs.").roles("Manager")
	 .and().withUser("train").password("$2y$10$xIpiJJPLjLhamqNqADpNge2Czpo6EPgpOztcsFWPs/8MbAQzuRpWy").roles("trainer");
	 
 }
 @Bean 
   PasswordEncoder Pass() {
	 return new BCryptPasswordEncoder(12);
 }
 protected void Configure(HttpSecurity http) throws Exception {
	 http.authorizeRequests().antMatchers("/manager").hasRole("Manager");
	 http.authorizeRequests().antMatchers("/trainer").hasAnyRole("Manager","Trainer","Student");
	 http.authorizeRequests().antMatchers("/student").permitAll().and().formLogin();
 }
}
