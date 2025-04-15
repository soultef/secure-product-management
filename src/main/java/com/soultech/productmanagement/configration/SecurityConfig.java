package com.soultech.productmanagement.configration;

import com.soultech.productmanagement.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SecurityConfig is the main security configuration class for the application.
 * It defines authentication and authorization rules using Spring Security.
 *
 * <p>This configuration includes:</p>
 * <ul>
 *     <li>Custom login and registration endpoint security</li>
 *     <li>Role-based access to product-related endpoints</li>
 *     <li>Form-based login and HTTP Basic support</li>
 *     <li>Custom user details service and password encoder setup</li>
 * </ul>
 * @Author: Solomon Demisse
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final CustomUserDetailsService customUserDetailsService;

    /**
     * Constructs the SecurityConfig with a custom user details service.
     *
     * @param customUserDetailsService the user details service implementation used for authentication
     */
    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    /**
     * Defines the main security filter chain for the application.
     * Configures authorization rules, login endpoints, and security filters.
     *
     * @param http the HttpSecurity object to configure
     * @return the configured SecurityFilterChain
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/login", "/api/register", "/api/registration", "/CSS/**", "/js/**").permitAll()
                        .requestMatchers("/products/add/{id}").hasRole("ADMIN")
                        .requestMatchers("/products/edit/**").hasRole("ADMIN")
                        .requestMatchers("/products/delete/{id}").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/api/login")
                        .loginProcessingUrl("/api/login")
                        .defaultSuccessUrl("/home", true)
                        .failureUrl("/login?error=true")
                )

                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/api/login")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    /**
     * Configures the DAO-based authentication provider using the custom user details service and password encoder.
     *
     * @return the configured DaoAuthenticationProvider
     */
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    /**
     * Provides the password encoder bean using BCrypt.
     *
     * @return the password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
