package com.cloud.service.impl;

import com.cloud.repo.InventoryRepo;
import com.cloud.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Throwable.class)
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepo inventoryRepo;

    @Override
    public boolean isInStock(String skuCode) throws Exception {
        return inventoryRepo.findBySkuCode(skuCode).isPresent();
    }
}
