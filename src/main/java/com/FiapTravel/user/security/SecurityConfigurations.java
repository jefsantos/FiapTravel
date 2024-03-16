//package com.FiapTravel.user.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfigurations {
//
//    @Autowired
//    SecurityFilter securityFilter;
//    
//
// 
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/public/**");
//    }
//    
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .csrf(csrf -> csrf.disable())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(authorize -> authorize
//
//                        .requestMatchers(HttpMethod.GET, "/cliente/listarClientes").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/cliente/buscarClientePorId/*").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/empreendimentos/*").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/empreendimentos/").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/listarItensCadastrados").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/users").permitAll()
//                        
//                        
//                        .requestMatchers(HttpMethod.POST, "/email").permitAll()
//                        .requestMatchers(HttpMethod.POST, "/cadastroLocalidade").permitAll()
//                        .requestMatchers(HttpMethod.POST, "/cliente/cadastroCliente").permitAll()
//                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
//                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
//                        .requestMatchers(HttpMethod.POST, "/cadastrarNovoItem").permitAll()
//                        
//                        .requestMatchers(HttpMethod.POST, "/empreendimentos/").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.POST, "/cadastro").hasRole("USER")
//
//
//                        .anyRequest().authenticated())
//                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
//        
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
//            throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}