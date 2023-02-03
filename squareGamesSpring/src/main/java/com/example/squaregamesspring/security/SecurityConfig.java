package com.example.squaregamesspring.security;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {
    @Autowired
    private final MyUserDetailsService userDetailsService;
    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;
    @Autowired
    private JwtTokenAuthenticationFilter tokenAuthentification;
    @Autowired
    private AuthenticationConfiguration authenticationManager;
//
    public SecurityConfig(final MyUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        final AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService);
        final var authenticationManager = authenticationManagerBuilder.build();
        http.authenticationManager(authenticationManager);

        // Activer CORS et désactiver CSRF
        http = http.cors().and().csrf().disable();

        // Modifier le manager de session pour utiliser le mode STATELESS
        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        // Renvoyer un code d’erreur en cas d’accès non autorisé
        http = http
                .exceptionHandling()
                .authenticationEntryPoint((request, response, ex) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage()))
                .and();
        // Définir les autorisations d’accès aux ressources
        http.authorizeHttpRequests()
        // Les accès sans autorisation
                .requestMatchers("/api/public/new/user").permitAll()
                .requestMatchers("/api/public/login").permitAll()
        // Les autres accès
                .anyRequest().authenticated();
        http.addFilterBefore(tokenAuthentification, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
//
//package com.example.squaregamesspring.security;
//
//
//        import jakarta.servlet.http.HttpServletResponse;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.context.annotation.Bean;
//        import org.springframework.context.annotation.Configuration;
//        import org.springframework.security.authentication.AuthenticationManager;
//        import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//        import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//        import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//        import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//        import org.springframework.security.config.http.SessionCreationPolicy;
//        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//        import org.springframework.security.crypto.password.PasswordEncoder;
//        import org.springframework.security.web.SecurityFilterChain;
//        import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfiguration {
//    @Autowired
//    private final MyUserDetailsService userDetailsService;
//
//    //    @Autowired
////    private AuthenticationConfiguration authenticationConfiguration;
////    @Autowired
////    private JwtTokenAuthenticationFilter tokenAuthentification;
////
//    public SecurityConfig(final MyUserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests()
////        // Les accès sans autorisation
//                .requestMatchers("/api/public/new/user").permitAll()
//                .requestMatchers("/api/public/login").permitAll()
//                .anyRequest().authenticated();
//    }
//
//    @Bean
//    public static PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//        @Bean
//    public AuthenticationManager authenticationManager() throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
////    }
//
//}
