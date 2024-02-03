package com.cloud.controller;

import com.cloud.dto.ProductRequest;
import com.cloud.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> doGetAll() {
        try {
            log.info("----------GET ALL PRODUCT------------");
            return ResponseEntity.ok(productService.getAll());
        } catch (Exception ex) {
            log.error("----------ERROR GET ALL PRODUCT------------", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> doCreate(@RequestBody ProductRequest productRequest) {
        try {
            log.info("----------CREATE PRODUCT------------");
            productService.create(productRequest);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            log.error("----------ERROR CREATE PRODUCT------------", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
