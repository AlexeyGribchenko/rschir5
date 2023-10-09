package ru.mirea.marketplace.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"ru.mirea.marketplace.repository"})
public class DBConfig {
}
