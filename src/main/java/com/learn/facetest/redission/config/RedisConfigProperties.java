package com.learn.facetest.redission.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisConfigProperties {

     String password;
     String port;
     String database;
     String host;

}
