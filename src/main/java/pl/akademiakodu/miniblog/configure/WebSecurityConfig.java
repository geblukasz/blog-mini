package pl.akademiakodu.miniblog.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/addPost").hasAnyRole("ADMIN")
                .anyRequest().permitAll()
            .and()
                .csrf().disable()
                .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error=true")
                    .defaultSuccessUrl("/posts")
                    .loginProcessingUrl("/login-process")
                    .usernameParameter("userName")
                    .passwordParameter("password")
            .and()
                .exceptionHandling().accessDeniedPage("/access-denied")
                ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("test").password("{noop}test2").roles("USER")
                .and()
                .withUser("admin").password("{noop}nimda2").roles("USER", "ADMIN");
    }
}
