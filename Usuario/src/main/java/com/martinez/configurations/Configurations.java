package com.martinez.configurations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
//@EnableWebSecurity
public class Configurations {

	@Autowired
    JwtFilter jwtFilter;
	
	@Autowired
	JwtEntryPoint jwtEntryPoint;
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and()
        	.csrf().disable()
            .authorizeRequests(authz -> authz.requestMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated())
            .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
    http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
            /*.oauth2Login()
            .and()
            .logout()
            .logoutSuccessUrl("/")
            .permitAll();*/
        return http.build();
    }
}
