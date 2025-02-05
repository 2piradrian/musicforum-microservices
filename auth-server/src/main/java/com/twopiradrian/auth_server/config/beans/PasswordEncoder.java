package com.twopiradrian.auth_server.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncoder {

    @Bean
    BCryptPasswordEncoder passEncoder() {
        return new BCryptPasswordEncoder();
    }

}
