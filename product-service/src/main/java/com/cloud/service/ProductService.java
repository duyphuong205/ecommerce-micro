package com.cloud.service;

import com.cloud.dto.ProductRequest;
import com.cloud.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    void create(ProductRequest productRequest) throws Exception;
    List<ProductResponse> getAll() throws Exception;
}
