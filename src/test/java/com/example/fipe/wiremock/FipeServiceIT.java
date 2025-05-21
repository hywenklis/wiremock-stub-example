package com.example.fipe.wiremock;

import static com.github.tomakehurst.wiremock.client.WireMock.setScenarioState;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import com.example.fipe.wiremock.service.FipeService;
import feign.FeignException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class FipeServiceIT extends IntegrationTest {
    @Autowired
    private FipeService fipeService;

    @Test
    @DisplayName("should return car value successfully")
    void shouldReturnCarValueSuccessfully() {
        // Arrange
        setScenarioState("FIPE_CAR_SUCCESS_SCENARIO", "OK_SUCCESS");

        String brand = "CHEVROLET";
        String model = "ONIX";
        String year = "2020";

        // Act
        var result = fipeService.fetchCarValue(brand, model, year);

        // Asserts
        assertThat(result)
            .isNotNull()
            .hasFieldOrPropertyWithValue("brand", "CHEVROLET")
            .hasFieldOrPropertyWithValue("model", "ONIX")
            .hasFieldOrPropertyWithValue("year", "2020")
            .hasFieldOrPropertyWithValue("value", 64500)
            .hasFieldOrPropertyWithValue("error", null);
    }

    @Test
    @DisplayName("should return error when car not found")
    void shouldThrowFeignExceptionNotFound_whenCarDoesNotExist() {
        setScenarioState("FIPE_CAR_NOT_FOUND_SCENARIO", "NOT_FOUND");

        String brand = "UNKNOWN";
        String model = "UNKNOWN";
        String year = "2020";

        assertThatThrownBy(() -> fipeService.fetchCarValue(brand, model, year))
            .isInstanceOf(FeignException.NotFound.class)
            .hasMessageContaining("404 Not Found")
            .hasMessageContaining("Vehicle not found in FIPE");
    }
}
