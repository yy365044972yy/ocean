package com.hb.ocean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author QuCheng on 2019-09-16.
 * EnableConfigurationProperties 使 @ConfigurationProperties 注解的类（需要加@Component）生效。
 * EnableFeignClients 将自己的服务注册到服务中心被发现
 */
@EnableConfigurationProperties
@SpringBootApplication
@EnableScheduling
//@EnableFeignClients
public class OceanApplication {
    public static void main(String[] args) {
        SpringApplication.run(OceanApplication.class, args);
    }
}
