
package com.restUnitTesting.unitTesting.model.InvoiceQuery;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "InvoiceQueryResponse"
})
public class InvoiceQueryInfo {

    @JsonProperty("InvoiceQueryResponse")
    private InvoiceQueryResponse invoiceQueryResponse;

    @JsonProperty("InvoiceQueryResponse")
    public InvoiceQueryResponse getInvoiceQueryResponse() {
        return invoiceQueryResponse;
    }

    @JsonProperty("InvoiceQueryResponse")
    public void setInvoiceQueryResponse(InvoiceQueryResponse invoiceQueryResponse) {
        this.invoiceQueryResponse = invoiceQueryResponse;
    }

}
