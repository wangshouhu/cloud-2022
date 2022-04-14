package com.nr.springcloud.service.impl;

import com.nr.springcloud.dao.PaymentDao;
import com.nr.springcloud.entities.Payment;
import com.nr.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author：tiger
 * @date：2022/3/30
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment)
    {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id)
    {
        return paymentDao.getPaymentById(id);
    }
}
