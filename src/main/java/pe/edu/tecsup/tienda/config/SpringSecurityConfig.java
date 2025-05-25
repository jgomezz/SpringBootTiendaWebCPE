package pe.edu.tecsup.tienda.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();    // Algoritmo BCrypt
    }

    /*
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {

        List<UserDetails> users = new ArrayList<UserDetails>();

        users.add(User.withUsername("user")
                .password(passwordEncoder().encode("123456"))
                .roles("USER").build());
        users.add(User.withUsername("admin")
                .password(passwordEncoder().encode("abcdef"))
                .roles("USER","ADMIN").build());

        return new InMemoryUserDetailsManager(users);
    }
    */

    @Autowired
    private UserDetailsService userDetailsService;


    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth)
            throws Exception{
        auth.userDetailsService(userDetailsService);
    }


}
