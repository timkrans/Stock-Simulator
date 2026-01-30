package com.example.market.service;

import com.example.market.model.PriceTick;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MarketSimulator {

    private final Map<String, List<PriceTick>> marketData = new HashMap<>();
    private final Random random = new Random();

    public void generate(String symbol, int ticks) {
        marketData.putIfAbsent(symbol, new ArrayList<>());
        List<PriceTick> list = marketData.get(symbol);

        double lastPrice = list.isEmpty()
                ? 100.0
                : list.get(list.size() - 1).price();

        for (int i = 0; i < ticks; i++) {
            double change = random.nextGaussian() * 0.5;
            lastPrice = Math.max(1.0, lastPrice + change);

            list.add(new PriceTick(System.currentTimeMillis(), lastPrice));
        }
    }

    public List<Double> getPrices(String symbol) {
        return marketData.getOrDefault(symbol, List.of())
                .stream()
                .map(PriceTick::price)
                .toList();
    }
}
