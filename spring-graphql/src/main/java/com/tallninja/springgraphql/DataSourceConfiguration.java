package com.tallninja.springgraphql;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.File;

@Configuration
public class DataSourceConfiguration {

    @Value("classpath:data/users.json")
    public Resource usersFile;

    @Bean(name = "usersFile")
    public File usersFile() throws Exception {
        return usersFile.getFile();
    }

}
