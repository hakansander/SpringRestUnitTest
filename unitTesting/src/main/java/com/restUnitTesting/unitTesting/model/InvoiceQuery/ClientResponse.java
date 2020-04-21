package com.restUnitTesting.unitTesting.model.InvoiceQuery;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ClientResponse {

    private int statusCode;
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private InvoiceQueryInfo invoiceQueryInfo;

    public ClientResponse(HttpStatus httpStatus, InvoiceQueryInfo invoiceQueryInfo) {
        this.statusCode = httpStatus.value();
        this.status = httpStatus;
        this.invoiceQueryInfo = invoiceQueryInfo;
        this.timestamp = LocalDateTime.now();
    }
}
