package com.restUnitTesting.unitTesting.service.imp;
import com.restUnitTesting.unitTesting.service.InvoiceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.restUnitTesting.unitTesting.model.InvoiceQuery.*;

@Service
public class InvoiceServiceImp implements InvoiceService {

    @Value("${invoiceInfo.path}")
    private String invoiceInfoPath;

    public InvoiceQueryInfo getInvoiceInfo(String phoneNumber) {
        return null;
    }

}
