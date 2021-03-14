package com.learn.facetest.redission.config;

import org.redisson.Redisson;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RedissionConfig {


    @Autowired
    private RedisConfigProperties redisConfigProperties;


    //添加redisson的bean/
    @Bean
    public Redisson redisson() {
        //redisson版本是3.5，集群的ip前面要加上“redis://”，不然会报错，3.2版本可不加
//        List<String> clusterNodes = new ArrayList<>();
//        clusterNodes.add("redis://" + redisConfigProperties.getHost()+":" + redisConfigProperties.getPort());

        Config config = new Config();

//        SingleServerConfig singleServerConfig =
                config.useSingleServer()
                .setAddress("redis://" + redisConfigProperties.getHost()+":" + redisConfigProperties.getPort())
                .setPassword(redisConfigProperties.getPassword())
                .setDatabase(Integer.valueOf(redisConfigProperties.getDatabase()))
                .setConnectTimeout(6000);

        return (Redisson) Redisson.create(config);
    }

}
