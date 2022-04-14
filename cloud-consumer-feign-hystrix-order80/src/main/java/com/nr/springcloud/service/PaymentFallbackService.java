package com.nr.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author：tiger
 * @date：2022/4/12
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService fall back-paymentInfo_OK ,服务降级了";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o,服务降级了";
    }

    @Override
    public String paymentCircuitBreaker(Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: \" +id";
    }
}
