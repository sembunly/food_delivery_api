package com.bunli.service.handler;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bunli.dto.PaymentRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KhQRHandlerService {

    private final RestTemplate restTemplate;

    public KhQRHandlerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String postingToKhQRApi(PaymentRequest paymentRequest) {

        try {
            final String url = "https://khqr.example.com/transactions";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + "my-secret-token");

            HttpEntity<PaymentRequest> httpEntity = new HttpEntity<>(paymentRequest, headers);

            log.info("Posting to KhQR API: {}", paymentRequest);
            ResponseEntity<String> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    httpEntity,
                    String.class);
            log.info("Response from KhQR API: {}", response.getBody());

            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            }
        } catch (Exception ex) {
            log.error("KhQR service response error: {}", ex.getMessage());
        }
        return null;
    }
}
