package com.example.lesson.config;


import com.example.lesson.Enums.ERole;
import com.example.lesson.jwt.JwtRequestFilter;
import com.example.lesson.repository.UserRepository;
import com.example.lesson.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl myUserServiceImpl;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private UserRepository userRepository;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .cors()
                .and()
                .authorizeRequests()
                .antMatchers("/admin/login").permitAll()
                .antMatchers("/admin/menu/*").permitAll()
                .antMatchers("/admin/*").hasRole(String.valueOf(ERole.ROLE_ADMIN.name))
                .antMatchers("/user/*", "/client/*","/send-notification").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
