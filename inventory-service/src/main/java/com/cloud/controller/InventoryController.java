package com.cloud.controller;

import com.cloud.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/inventories")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("isInStock/{sku-code}")
    public ResponseEntity<?> checkIsInStock(@PathVariable("sku-code") String skuCode) {
        try {
            log.info("----------CHECK IS IN-STOCK------------");
            return ResponseEntity.ok(inventoryService.isInStock(skuCode));
        } catch (Exception ex) {
            log.error("----------CHECK IS IN-STOCK ERROR------------", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
