package com.ibk.ibkchallenge.service;


import com.ibk.ibkchallenge.application.dto.response.ProductResponseDto;
import com.ibk.ibkchallenge.provider.store.dto.request.StoreRequestApiDto;

import java.util.List;

public interface ProductService {

    List<ProductResponseDto> getProducts(Long limit);

    ProductResponseDto getProductById(Long productId);

    ProductResponseDto createProduct(StoreRequestApiDto storeRequestApiDto);




}
