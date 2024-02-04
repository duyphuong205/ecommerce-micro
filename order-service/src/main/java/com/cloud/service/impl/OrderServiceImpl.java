package com.cloud.service.impl;

import com.cloud.dto.OrderRequest;
import com.cloud.entity.Order;
import com.cloud.entity.OrderLineItems;
import com.cloud.repo.OrderRepo;
import com.cloud.service.OrderService;
import com.cloud.utils.ConvertObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    private final WebClient webClient;

    @Override
    public String create(OrderRequest orderRequest) throws Exception {
        List<OrderLineItems> orderLineItems = orderRequest.getOrderResponseList()
                .stream().map(item -> ConvertObjectUtils.mapToEntity(item, OrderLineItems.class)).toList();

        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .orderLineItems(orderLineItems)
                .build();

        // call inventory-service, and place order if product is in stock
        Boolean isInStock = webClient.get()
                .uri("http://localhost:8082/api/inventories")
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();

        if (isInStock) {
            orderRepo.save(order);
            return "Order Placed Successfully!";
        } else {
            return "Product is not in stock, please try agian later!";
        }
    }
}
