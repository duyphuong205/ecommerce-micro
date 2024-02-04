package com.cloud.service;

public interface InventoryService {
    boolean isInStock(String skuCode) throws Exception;
}
