package geiffel.da4.issuetracker.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(HttpMethod.GET,"/users/").hasAuthority("SCOPE_read:users")
                        .requestMatchers(HttpMethod.GET,"/users/{id}").hasAuthority("SCOPE_read:specificUser")
                        .requestMatchers(HttpMethod.POST,"/users/").hasAuthority("SCOPE_create:users")
                        .requestMatchers(HttpMethod.PUT,"/users/{id}").hasAuthority("SCOPE_update:user")
                        .requestMatchers(HttpMethod.DELETE,"/users/{id}").hasAuthority("SCOPE_delete:user")

                        .anyRequest().authenticated()
                )
                .cors(withDefaults())
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(withDefaults())
                )
                .build();
    }
}