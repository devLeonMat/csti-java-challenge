package com.ibk.ibkchallenge.application.mapper;

import com.ibk.ibkchallenge.application.dto.request.SalesRequestDto;
import com.ibk.ibkchallenge.application.dto.response.SalesResponseDto;
import com.ibk.ibkchallenge.persistence.Sales;
import com.ibk.ibkchallenge.provider.store.dto.response.StoreResponseApiDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SalesMapper {

    private final ProductMapper productMapper;

    public SalesResponseDto toDto(Sales salesEntity) {
        return SalesResponseDto.builder()
                .salesId(salesEntity.getId())
                .price(salesEntity.getAmount())
                .iva(salesEntity.getIva())
                .idClient(salesEntity.getClientId())
                .productId(salesEntity.getProductId())
                .build();
    }

    public SalesResponseDto toDto(Sales salesEntity, StoreResponseApiDto responseApiDto) {
        return SalesResponseDto.builder()
                .salesId(salesEntity.getId())
                .price(salesEntity.getAmount())
                .iva(salesEntity.getIva())
                .idClient(salesEntity.getClientId())
                .productId(salesEntity.getProductId())
                .productDetail(productMapper.toDto(responseApiDto))
                .build();
    }

    public Sales toEntity(SalesRequestDto salesRequestDto) {
        return Sales.builder()
                .id(salesRequestDto.getSalesId())
                .amount(salesRequestDto.getPrice())
                .iva(salesRequestDto.iva)
                .clientId(salesRequestDto.getIdClient())
                .productId(salesRequestDto.getProductId())
                .build();
    }
}
