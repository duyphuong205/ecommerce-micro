package com.cloud.service.impl;

import com.cloud.dto.ProductRequest;
import com.cloud.dto.ProductResponse;
import com.cloud.entity.Product;
import com.cloud.repo.ProductRepo;
import com.cloud.service.ProductService;
import com.cloud.utils.ConvertObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Throwable.class)
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Override
    public void create(ProductRequest productRequest) throws Exception {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getName())
                .price(productRequest.getPrice())
                .build();
        productRepo.save(product);
    }

    @Override
    public List<ProductResponse> getAll() throws Exception {
        return productRepo.findAll().stream().map(item -> ConvertObjectUtils.mapToDTO(item, ProductResponse.class)).toList();
    }
}
