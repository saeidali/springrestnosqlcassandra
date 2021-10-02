package com.example.springrestnosqlcassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
public class SpringrestnosqlcassandraApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringrestnosqlcassandraApplication.class, args);
    }

}
