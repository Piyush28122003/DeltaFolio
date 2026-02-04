package com.delta.Deltafolio.controller;

import com.delta.Deltafolio.dto.MarketIndexDTO;
import com.delta.Deltafolio.service.MarketIndicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/market-indices")
@CrossOrigin(origins = "*")
public class MarketIndicesController {

    private final MarketIndicesService marketIndicesService;

    @Autowired
    public MarketIndicesController(MarketIndicesService marketIndicesService) {
        this.marketIndicesService = marketIndicesService;
    }

    @GetMapping
    public ResponseEntity<List<MarketIndexDTO>> getMarketIndices() {
        return ResponseEntity.ok(marketIndicesService.getMarketIndices());
    }
}
