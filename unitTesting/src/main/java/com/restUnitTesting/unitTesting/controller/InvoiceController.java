package com.restUnitTesting.unitTesting.controller;

import com.restUnitTesting.unitTesting.model.InvoiceQuery.ClientResponse;
import com.restUnitTesting.unitTesting.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.restUnitTesting.unitTesting.model.InvoiceQuery.InvoiceQueryInfo;


@RestController
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("invoiceQuery/{phoneNumber}")
    public ClientResponse getBillingInquiry(@PathVariable("phoneNumber") String phoneNumber) {

    	InvoiceQueryInfo invoiceQueryInfo = invoiceService.getInvoiceInfo(phoneNumber);

    	if(invoiceQueryInfo != null) {
    		return new ClientResponse(HttpStatus.OK, invoiceQueryInfo);
    	}
    	

        return new ClientResponse(HttpStatus.NO_CONTENT, null);
        
    }
}
