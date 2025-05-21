package com.example.fipe.wiremock.feign.response;

public record FipeResponse(
    String brand,
    String model,
    String year,
    Integer value,
    String error
) { }
