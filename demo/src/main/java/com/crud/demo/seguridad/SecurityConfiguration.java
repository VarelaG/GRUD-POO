package com.crud.demo.seguridad;
import com.crud.demo.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@Order(2)
public class SecurityConfiguration {

    private final UsuarioServicio usuarioServicio;

    @Autowired
    public SecurityConfiguration(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .userDetailsService(usuarioServicio)
                .authorizeRequests((requests) -> requests
                        .requestMatchers(
                                new AntPathRequestMatcher("/"),
                                new AntPathRequestMatcher("/webjars/"),
                                new AntPathRequestMatcher("/resources/"),
                                new AntPathRequestMatcher("/css/**")
                        ).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                        .anyRequest().hasAuthority("ROLE_USER")
                )
                .formLogin((form) -> form.loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }
}