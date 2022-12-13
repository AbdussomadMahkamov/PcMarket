package com.example.pcmarket.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class SecuritySettings extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
//pcmarket.uz saytining security qismini yozish vazifa. bunda inMemory da 3 ta user qo'shiladi.
//ADMIN, SUPERUSER va OPERATOR lavozimlari bo’lsin.
//ADMIN har qanday ishni qila oladi;
//SUPERUSER mahsulot qo’sha oladi va tahrirlay oladi ,ammo o’chira olmaydi;
//OPERATOR buyurtmalar bilan ishlaydi, mahsulotni o'chira olmaydi va tahrirlay olmaydi.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("Admin").password(passwordEncoder().encode("1234")).roles("ADMIN").authorities("ADD", "READ", "DELETE", "PUT","IDREAD")
                .and()
                .withUser("SuperUser").password(passwordEncoder().encode("1111")).roles("SUPERUSER").authorities("ADD", "PUT")
                .and()
                .withUser("Operator").password(passwordEncoder().encode("2222")).roles("OPERATOR").authorities("IDREAD","READ");
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
