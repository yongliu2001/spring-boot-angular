package com.marcus.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by yongl on 19/05/2017.
 */

@EnableJpaRepositories("com.marcus.repository")
@EnableTransactionManagement
public class DatabaseConfig {
}
