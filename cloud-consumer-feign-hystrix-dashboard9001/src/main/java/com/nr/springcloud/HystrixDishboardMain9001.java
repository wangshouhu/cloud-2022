package com.nr.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * <p>
 *
 * </p>
 *
 * @author：tiger
 * @date：2022/4/13
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableHystrixDashboard
public class HystrixDishboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDishboardMain9001.class,args);
    }
}
