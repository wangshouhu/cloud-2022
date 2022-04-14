package com.nr.springcloud.service;

import com.nr.springcloud.entities.Payment;

/**
 * <p>
 *
 * </p>
 *
 * @author：tiger
 * @date：2022/3/30
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
