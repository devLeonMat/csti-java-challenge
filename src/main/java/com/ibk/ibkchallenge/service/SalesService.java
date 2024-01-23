package com.ibk.ibkchallenge.service;

import com.ibk.ibkchallenge.application.dto.response.SalesResponseDto;
import com.ibk.ibkchallenge.persistence.Sales;

import java.util.List;

public interface SalesService {

    List<SalesResponseDto> getSales();

    SalesResponseDto getSale(Long idSale);

    SalesResponseDto createNewSales(Sales sales);


}
