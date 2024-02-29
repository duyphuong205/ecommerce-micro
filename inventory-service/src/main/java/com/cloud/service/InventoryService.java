package com.cloud.service;

import com.cloud.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {
    List<InventoryResponse> isInStock(List<String> skuCode) throws Exception;
}
