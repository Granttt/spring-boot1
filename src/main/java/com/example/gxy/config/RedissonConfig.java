package com.example.gxy.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author GXY
 * @Package com.example.gxy.config
 * @date 2020/11/12 17:59
 * @Copyright © 2020-2021 新流通
 * @Description:Redissonp配置类
 * https://www.jianshu.com/p/ac5ee0b3d561
 */
@Configuration
public class RedissonConfig {

    @Value("${redisson.host.config}")
    private String address;

    @Value("${redisson.database}")
    private int database;

    @Bean
    public RedissonClient config(){
        //创建配置实例
        Config config = new Config();

        // 传输模式既可以设置为EPOLL，也可以设置为NIO等
        config.setTransportMode(TransportMode.NIO);

        // 设置服务节点部署模式: 集群、单一节点/主从模式/哨兵模式
        // config.useClusterServers().addNodeAddress(env.getProperty("redisson.host.config"), env.getProperty("redisson.host.config"));
        config.useSingleServer().setAddress(address).setDatabase(database).setKeepAlive(true);

        return Redisson.create(config);

    }
}
