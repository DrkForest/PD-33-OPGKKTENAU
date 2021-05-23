package com.example.NotesTest.config;

import com.example.NotesTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /*@Autowired
    private DataSource dataSource;*/
    @Autowired
    private UserService userService;

    @Override
    //object
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/registration").permitAll()
                    //.antMatchers("/", "/home").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            //auth.jdbcAuthentication()
            auth.userDetailsService(userService)
            //go to db
            //.dataSource(dataSource)
            //encode password
            .passwordEncoder(NoOpPasswordEncoder.getInstance())
            //my sql
            //.usersByUsernameQuery("select `username`, `password`, `active` from `USER` where `username` = ?")
            //.authoritiesByUsernameQuery("SELECT `user`.username , `user_roles`.roles FROM `user` inner join `user_roles` on `user`.id = `user_roles`.user_id where `user`.`username` = ?")


            ;
    }

    //manual user
    /*@Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }*/
}
