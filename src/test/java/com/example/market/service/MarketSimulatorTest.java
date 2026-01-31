package com.example.market.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MarketSimulatorTest {

    @Test
    void generateShouldCreatePrices() {
        MarketSimulator simulator = new MarketSimulator();

        simulator.generate("AAPL", 10);
        List<Double> prices = simulator.getPrices("AAPL");

        assertEquals(10, prices.size());
        assertTrue(prices.stream().allMatch(p -> p >= 1.0));
    }
}
