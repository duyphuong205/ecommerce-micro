package com.cloud.service.impl;

import com.cloud.dto.InventoryResponse;
import com.cloud.repo.InventoryRepo;
import com.cloud.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Throwable.class)
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepo inventoryRepo;

    @Override
    public List<InventoryResponse> isInStock(List<String> skuCode) throws Exception {
        return inventoryRepo.findBySkuCodeIn(skuCode).stream()
                .map(item -> InventoryResponse.builder()
                                              .skuCode(item.getSkuCode())
                                              .isInStock(item.getQuantity() > 0)
                                              .build()).toList();
    }
}
