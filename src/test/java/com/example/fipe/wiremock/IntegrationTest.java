package com.example.fipe.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = {DemoFipeWiremockApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0, stubs = "classpath:/mappings")
@ActiveProfiles("test")
abstract class IntegrationTest {

    @BeforeEach
    void init() {
        WireMock.resetAllRequests();
        WireMock.resetAllScenarios();
    }
}
