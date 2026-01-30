package com.example.market.controller;

import com.example.market.dto.BoxWhiskerStats;
import com.example.market.service.MarketSimulator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/market")
public class MarketController {

    private final MarketSimulator simulator;

    public MarketController(MarketSimulator simulator) {
        this.simulator = simulator;
    }

    @PostMapping("/generate/{symbol}")
    public String generate(
            @PathVariable String symbol,
            @RequestParam(defaultValue = "100") int ticks
    ) {
        simulator.generate(symbol, ticks);
        return "Generated " + ticks + " ticks for " + symbol;
    }

    @GetMapping("/prices/{symbol}")
    public List<Double> prices(@PathVariable String symbol) {
        return simulator.getPrices(symbol);
    }

    @GetMapping("/box/{symbol}")
    public BoxWhiskerStats box(@PathVariable String symbol) {
        return BoxWhiskerStats.from(simulator.getPrices(symbol));
    }
}
