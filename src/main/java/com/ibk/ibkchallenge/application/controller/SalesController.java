package com.ibk.ibkchallenge.application.controller;

import com.ibk.ibkchallenge.application.dto.request.SalesRequestDto;
import com.ibk.ibkchallenge.application.dto.response.SalesResponseDto;
import com.ibk.ibkchallenge.application.facade.SalesFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/sales")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SalesController {

    private final SalesFacade salesFacade;

    @GetMapping()
    public ResponseEntity<List<SalesResponseDto>> getSales() {
        log.info("[SalesController:getSales]");
        return ResponseEntity.ok().body(salesFacade.getSales());
    }

    @GetMapping("/{saleId}")
    public ResponseEntity<SalesResponseDto> getSaleById(@PathVariable(value = "saleId") Long saleId) {
        log.info("[SalesController:getSaleById]");
        return ResponseEntity.ok().body(salesFacade.getSaleById(saleId));
    }

    @PostMapping()
    public ResponseEntity<SalesResponseDto> createSales(@RequestBody SalesRequestDto salesRequestDto) {
        log.info("[SalesController:createSales]");
        return ResponseEntity.ok().body(salesFacade.createSales(salesRequestDto));
    }


}
