
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
    public InvoiceQueryResponse invoiceQueryResponse;

}
