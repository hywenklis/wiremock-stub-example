package com.example.fipe.wiremock.feign;

import com.example.fipe.wiremock.feign.response.FipeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "fipeClient", url = "${integration.fipe.url}")
public interface FipeClient {
    @GetMapping("/car")
    FipeResponse getCarValue(@RequestParam String brand,
                             @RequestParam String model,
                             @RequestParam String year);
}
