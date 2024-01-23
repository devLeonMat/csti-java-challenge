package com.ibk.ibkchallenge.application.controller;


import com.ibk.ibkchallenge.application.dto.request.ProductRequestDto;
import com.ibk.ibkchallenge.application.dto.response.ProductResponseDto;
import com.ibk.ibkchallenge.application.facade.ProductFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {

    private final ProductFacade productFacade;

    @GetMapping()
    public ResponseEntity<List<ProductResponseDto>> getProducts(@RequestParam(value = "limit", required = false) Long limit) {
        log.info("[ProductController:getProducts]");
        return ResponseEntity.ok().body(productFacade.getProducts(limit));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable(value = "productId") Long productId) {
        log.info("[ProductController:getProductById]");
        return ResponseEntity.ok().body(productFacade.getProductById(productId));
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto) {
        log.info("[ProductController:createProduct]");
        return ResponseEntity.ok().body(productFacade.createProduct(productRequestDto));
    }


}
