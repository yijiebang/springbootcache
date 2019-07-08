package com.cache.springbootcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @EnableCache注解启动了Spring的缓存机制，它会使应用检测所有缓存相关的注解并开始工作，同时还会创建一个CacheManager的bean,可以被我们的应用注入使用。
 */
@EnableCaching  //开启缓存
@SpringBootApplication
public class SpringbootcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootcacheApplication.class, args);
    }

}
