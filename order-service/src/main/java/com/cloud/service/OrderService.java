package com.cloud.service;

import com.cloud.dto.OrderRequest;

public interface OrderService {
    String create(OrderRequest orderRequest) throws Exception;
}
