package com.ibk.ibkchallenge.service.impl;

import com.ibk.ibkchallenge.application.dto.response.ProductResponseDto;
import com.ibk.ibkchallenge.application.mapper.ProductMapper;
import com.ibk.ibkchallenge.infrastructure.exception.custom.NotFoundException;
import com.ibk.ibkchallenge.provider.store.StoreClientApi;
import com.ibk.ibkchallenge.provider.store.dto.request.StoreRequestApiDto;
import com.ibk.ibkchallenge.provider.store.dto.response.StoreResponseApiDto;
import com.ibk.ibkchallenge.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductServiceImpl implements ProductService {

    private final StoreClientApi storeClientApi;

    private final ProductMapper productMapper;

    @Override
    public List<ProductResponseDto> getProducts(Long limit) {
        if (isNull(limit)) {
            return storeClientApi.getProducts()
                    .stream()
                    .map(productMapper::toDto)
                    .collect(Collectors.toList());
        } else {
            return storeClientApi.getProducts(limit)
                    .stream()
                    .map(productMapper::toDto)
                    .collect(Collectors.toList());
        }

    }

    @Override
    public ProductResponseDto getProductById(Long productId) {
        StoreResponseApiDto responseApiDto = storeClientApi.getProductById(productId);
        if (isNull(responseApiDto)) {
            throw new NotFoundException();
        }
        return productMapper.toDto(responseApiDto);
    }

    @Override
    public ProductResponseDto createProduct(StoreRequestApiDto storeRequestApiDto) {
        return productMapper.toDto(storeClientApi.createNewProduct(storeRequestApiDto));
    }
}
