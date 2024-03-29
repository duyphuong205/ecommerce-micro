package com.cloud.controller;

import com.cloud.constants.CommonConstant;
import com.cloud.dto.OrderRequest;
import com.cloud.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> doCreate(@RequestBody OrderRequest orderRequest) {
        try {
            log.info("----------CREATE ORDER------------");
            String createdOrder = orderService.create(orderRequest);
            if (CommonConstant.SUCCESS.equals(createdOrder)) {
                return new ResponseEntity<>("Order Placed Successfully!", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Product is not in stock, please try again later!", HttpStatus.OK);
            }
        } catch (Exception ex) {
            log.error("----------ERROR CREATE ORDER------------", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
