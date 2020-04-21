
package com.restUnitTesting.unitTesting.model.InvoiceQuery;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Id",
    "Name",
    "Price",
    "Currency"
})
public class InvoiceList {

    @JsonProperty("Id")
    public String id;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("Price")
    public String price;
    @JsonProperty("Currency")
    public String currency;

}
