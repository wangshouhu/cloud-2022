package com.nr.springcloud.controller;

import com.nr.springcloud.entities.CommonResult;
import com.nr.springcloud.entities.Payment;
import com.nr.springcloud.service.PaymentFeignService;
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
 * @date：2022/4/11
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    String getPaymentFeignTimeout(){
        //openfeign  ribbon，客户端一般默认等待1秒钟
        return paymentFeignService.getPaymentFeignTimeout();
    }
}
