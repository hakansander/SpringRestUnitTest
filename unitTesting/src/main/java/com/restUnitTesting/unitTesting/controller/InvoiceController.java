package com.restUnitTesting.unitTesting.controller;

import com.restUnitTesting.unitTesting.model.InvoiceQuery.InvoiceResponse;
import com.restUnitTesting.unitTesting.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("invoiceQuery/{phoneNumber}")
    public InvoiceResponse getInvoiceInfo(@PathVariable("phoneNumber") String phoneNumber) {

        InvoiceResponse invoiceResponse = invoiceService.getInvoiceInfo(phoneNumber);

        return invoiceResponse;
    }
}
