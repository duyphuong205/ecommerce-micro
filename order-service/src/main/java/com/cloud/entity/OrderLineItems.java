package com.cloud.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "Order_Line_Items")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItems implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    @JsonIgnoreProperties(value = { "applications", "hibernateLazyInitializer" })
    private Order order;
}
