package com.ibk.ibkchallenge.service.impl;

import com.ibk.ibkchallenge.application.dto.response.SalesResponseDto;
import com.ibk.ibkchallenge.application.mapper.SalesMapper;
import com.ibk.ibkchallenge.infrastructure.exception.custom.NotFoundException;
import com.ibk.ibkchallenge.persistence.Sales;
import com.ibk.ibkchallenge.persistence.SalesRepository;
import com.ibk.ibkchallenge.provider.store.StoreClientApi;
import com.ibk.ibkchallenge.provider.store.dto.response.StoreResponseApiDto;
import com.ibk.ibkchallenge.service.SalesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SalesServiceImpl implements SalesService {

    private SalesRepository salesRepository;
    private final StoreClientApi storeClientApi;
    private final SalesMapper salesMapper;


    @Override
    public List<SalesResponseDto> getSales() {
        return salesRepository.findAll()
                .stream()
                .map(salesMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SalesResponseDto getSale(Long idSale) {
        Sales sales = salesRepository.findById(idSale).orElseThrow(NotFoundException::new);
        StoreResponseApiDto storeResponseApiDto = storeClientApi.getProductById(sales.getProductId());
        return salesMapper.toDto(sales, storeResponseApiDto);
    }

    @Override
    public SalesResponseDto createNewSales(Sales sales) {
        return salesMapper.toDto(salesRepository.save(sales));
    }
}
