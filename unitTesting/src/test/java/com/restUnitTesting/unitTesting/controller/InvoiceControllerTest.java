package com.restUnitTesting.unitTesting.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restUnitTesting.unitTesting.model.InvoiceQuery.InvoiceQueryInfo;
import com.restUnitTesting.unitTesting.service.InvoiceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StreamUtils;

import java.io.FileInputStream;
import java.nio.charset.Charset;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InvoiceService invoiceService;

    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testWhenPhoneNumEnteredAndDataExists_thenReturnHttp200() throws Exception {

        final String mockPhoneNumber = "534*******";

        final FileInputStream fileInputStream = new FileInputStream(ResourceUtils.getFile("classpath:response_http200.json"));
        final String staticResponse = StreamUtils.copyToString(fileInputStream, Charset.defaultCharset());

        InvoiceQueryInfo mockInvoiceQueryInfo = mapper.readValue(staticResponse, InvoiceQueryInfo.class);

        when(invoiceService.getInvoiceInfo(mockPhoneNumber))
                .thenReturn(mockInvoiceQueryInfo);

        mockMvc.perform(get("/invoiceQuery/{phoneNumber}", mockPhoneNumber))
                .andExpect(jsonPath("$.statusCode", is(200)));

    }

    @Test
    public void testWhenPhoneNumEnteredAndNoDataFound_thenReturnHttp204() throws Exception {

        final String mockPhoneNumber = "542*******";

        mockMvc.perform(get("/invoiceQuery/{phoneNumber}", mockPhoneNumber))
                .andExpect(jsonPath("$.statusCode", is(204)));

    }

}
