package com.example.adminpage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration //설정파일
@EnableJpaAuditing //JPA 감시 설정
public class JpaConfig {
}
