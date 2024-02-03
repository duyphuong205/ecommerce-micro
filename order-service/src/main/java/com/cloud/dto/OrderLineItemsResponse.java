package com.cloud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemsResponse implements Serializable {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
