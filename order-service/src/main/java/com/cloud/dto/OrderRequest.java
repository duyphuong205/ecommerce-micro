package com.cloud.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest implements Serializable {
    private List<OrderLineItemsResponse> orderResponseList;
}
