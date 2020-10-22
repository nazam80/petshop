package com.shop.mypetshop.config;

import javax.sql.DataSource;

import org.h2.Driver;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories(basePackages = {"com.shop.mypetshop.repo"})
public class DataSourceConfig
{
    /**
     * In memory database used for this demo purpose
     *
     * @return the constructed DataSource
     */
    @Bean
    public DataSource embeddedDataSource()
    {
        return DataSourceBuilder.create()
            .url("jdbc:h2:mem:petshop")
            .driverClassName(Driver.class.getCanonicalName())
            .build();
    }
}
