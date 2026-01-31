package com.example.market.controller;

import com.example.market.service.MarketSimulator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MarketControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MarketSimulator simulator;

    @Test
    void boxEndpointReturnsCorrectBoxWhiskerValues() throws Exception {
        simulator.setPrices("AAPL",
                List.of(10.0, 20.0, 30.0, 40.0, 50.0));

        mockMvc.perform(get("/api/market/box/AAPL"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.min").value(10.0))
                .andExpect(jsonPath("$.q1").value(20.0))
                .andExpect(jsonPath("$.median").value(30.0))
                .andExpect(jsonPath("$.q3").value(40.0))
                .andExpect(jsonPath("$.max").value(50.0));
    }
}
