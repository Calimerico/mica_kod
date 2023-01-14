package com.example.demo;

public class ModernInvoiceIssuingService implements InvoiceIssuingService, Comparable {

    @Override
     public String issueInvoice() {
        return "Modern calculating";
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
