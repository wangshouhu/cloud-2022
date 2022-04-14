package com.nr.springcloud.controller;

import cn.hutool.core.lang.Console;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.nr.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author：tiger
 * @date：2022/4/12
 */
@RestController
@Slf4j
//没有特别指明服务降级方式时，统一跳到统一处理结果页面，通用的和独享的各自分开，避免了代码膨胀，合理减少了代码量。
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Resource
    PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id)
    {
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    //@HystrixCommand
    /*@HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000")
    })*/
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        //int a = 10/0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        //String result ="123";
        Console.log("result:"+result);
        return result;
    }

    public String paymentTimeOutFallbackMethod(Integer id){
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }

    public String payment_Global_FallbackMethod(){
        return "Global处理信息，请稍后再试，o(╥﹏╥)o";
    }

    //熔断器
    @GetMapping("/consumer/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentCircuitBreaker(id);
        return result;
    }
}
