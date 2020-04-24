
package com.restUnitTesting.unitTesting.model.InvoiceQuery;

import com.fasterxml.jackson.annotation.*;
import com.sun.org.apache.xpath.internal.operations.Bool;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "success",
    "responseMsg",
    "statusCode",
    "response",
    "data"
})
public class InvoiceResponse {

    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("responseMsg")
    private String responseMsg;
    @JsonProperty("statusCode")
    private String statusCode;
    @JsonProperty("response")
    private String response;
    @JsonProperty("data")
    private Data data;

    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty("responseMsg")
    public String getResponseMsg() {
        return responseMsg;
    }


    @JsonProperty("statusCode")
    public String getStatusCode() {
        return statusCode;
    }

    @JsonProperty("response")
    public String getResponse() {
        return response;
    }


    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonCreator
    public InvoiceResponse(@JsonProperty("success") Boolean success,
                                          @JsonProperty("responseMsg") String responseMsg,
                                          @JsonProperty("response") String response,
                                          @JsonProperty("data") Data data,
                                          @JsonProperty("statusCode") String statusCode
                                          ) {
        this.success = success;
        this.responseMsg = responseMsg;
        this.response = response;
        this.statusCode = statusCode;
        this.data = data;
    }


    public InvoiceResponse(Boolean success, String responseMsg, String response, String statusCode) {
        this.success = success;
        this.responseMsg = responseMsg;
        this.response = response;
        this.statusCode = statusCode;
    }

}
