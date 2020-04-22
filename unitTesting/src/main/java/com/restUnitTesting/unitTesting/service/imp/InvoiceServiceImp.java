package com.restUnitTesting.unitTesting.service.imp;
import com.restUnitTesting.unitTesting.service.InvoiceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import com.restUnitTesting.unitTesting.model.InvoiceQuery.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class InvoiceServiceImp implements InvoiceService {

    @Value("${invoiceInfo.path}")
    private String invoiceInfoPath;

    private final RestTemplate restTemplate;

    public InvoiceServiceImp(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public InvoiceQueryInfo getInvoiceInfo(String phoneNumber) {
        try {
            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            HttpHeaders requestHeaders = new HttpHeaders();

            HttpEntity<?> httpEntity = new HttpEntity<>(body, requestHeaders);
            requestHeaders.setContentType(MediaType.APPLICATION_JSON);

            ResponseEntity<InvoiceQueryInfo> invoiceQueryResponse =
                    restTemplate.exchange(invoiceInfoPath + phoneNumber, HttpMethod.GET, httpEntity, InvoiceQueryInfo.class);

            return invoiceQueryResponse.getBody();
        } catch (Exception e) {
            System.out.println("Thrown the exception:" + e);
            return null;
        }
    }

}
