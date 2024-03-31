package com.stock.manager.paymentmanagerapi.presentation.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource


@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { authorizeRequests ->
                authorizeRequests
//                    .requestMatchers("/login").permitAll()
//                    .requestMatchers("/admin/**").hasAuthority(RoleType.ADMIN.toString())
                    .anyRequest().permitAll()
            }
            .csrf { csrf ->
                csrf.disable()
            }
//            .formLogin { login ->
//                login.loginProcessingUrl("/login").permitAll()
//                    .usernameParameter("email")
//                    .passwordParameter("pass")
//                    .successHandler(BookManagerAuthenticationSuccessHandler())
//                    .failureHandler(BookManagerAuthenticationFailureHandler())
//            }
//            .exceptionHandling { ex ->
//                ex.authenticationEntryPoint(BookManagerAuthenticationEntryPoint())
//                    .accessDeniedHandler(BookManagerAccessDeniedHandler())
//            }
            .cors { cors ->
                cors.configurationSource(corsConfigurationSource())
            }

        return http.build()
    }

    private fun corsConfigurationSource(): CorsConfigurationSource {
        val corsConfiguration = CorsConfiguration()
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL)
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL)
        corsConfiguration.addAllowedOrigin("http://localhost:3000")
        corsConfiguration.allowCredentials = true

        val corsConfigurationSource = UrlBasedCorsConfigurationSource()
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration)
        return corsConfigurationSource
    }
}