package com.cloud.service;

import com.cloud.dto.OrderRequest;

public interface OrderService {
    void create(OrderRequest orderRequest) throws Exception;
}
