package com.ibk.ibkchallenge.application.facade;

import com.ibk.ibkchallenge.application.dto.request.SalesRequestDto;
import com.ibk.ibkchallenge.application.dto.response.SalesResponseDto;
import com.ibk.ibkchallenge.application.mapper.SalesMapper;
import com.ibk.ibkchallenge.service.SalesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SalesFacade {

    private final SalesService salesService;
    private final SalesMapper salesMapper;


    public List<SalesResponseDto> getSales() {
        return salesService.getSales();
    }


    public SalesResponseDto getSaleById(Long salesId) {
        return salesService.getSale(salesId);
    }

    public SalesResponseDto createSales(SalesRequestDto salesRequestDto) {
        return salesService.createNewSales(salesMapper.toEntity(salesRequestDto));
    }


}
