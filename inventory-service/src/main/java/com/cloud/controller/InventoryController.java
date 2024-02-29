package com.cloud.controller;

import com.cloud.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/inventories")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("isInStock")
    public ResponseEntity<?> checkIsInStock(@RequestParam("{sku-code}") List<String> skuCode) {
        try {
            log.info("----------CHECK IS IN-STOCK------------");
            return ResponseEntity.ok(inventoryService.isInStock(skuCode));
        } catch (Exception ex) {
            log.error("----------CHECK IS IN-STOCK ERROR------------", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
