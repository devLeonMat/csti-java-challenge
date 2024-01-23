package com.ibk.ibkchallenge.application.mapper;

import com.ibk.ibkchallenge.application.dto.request.ProductRequestDto;
import com.ibk.ibkchallenge.application.dto.response.ProductResponseDto;
import com.ibk.ibkchallenge.provider.store.dto.request.StoreRequestApiDto;
import com.ibk.ibkchallenge.provider.store.dto.response.StoreResponseApiDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponseDto toDto(StoreResponseApiDto storeResponseApiDto) {
        return ProductResponseDto.builder()
                .id(storeResponseApiDto.id)
                .title(storeResponseApiDto.title)
                .price(storeResponseApiDto.price)
                .category(storeResponseApiDto.category)
                .description(storeResponseApiDto.description)
                .image(storeResponseApiDto.image)
                .build();
    }

    public StoreRequestApiDto toDto(ProductRequestDto productRequestDto) {
        return StoreRequestApiDto.builder()
                .id(productRequestDto.id)
                .title(productRequestDto.title)
                .price(productRequestDto.price)
                .category(productRequestDto.category)
                .description(productRequestDto.description)
                .image(productRequestDto.image)
                .build();
    }
}
