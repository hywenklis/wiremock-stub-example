package com.example.fipe.wiremock.service;

import com.example.fipe.wiremock.feign.FipeClient;
import com.example.fipe.wiremock.feign.response.FipeResponse;
import org.springframework.stereotype.Service;

@Service
public class FipeService {

    private final FipeClient fipeClient;

    public FipeService(FipeClient fipeClient) {
        this.fipeClient = fipeClient;
    }

    public FipeResponse fetchCarValue(String brand, String model, String year) {
        return fipeClient.getCarValue(brand, model, year);
    }
}
