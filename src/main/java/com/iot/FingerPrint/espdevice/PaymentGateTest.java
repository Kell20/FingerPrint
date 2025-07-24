package com.iot.FingerPrint.espdevice;

//DTO data transfer for payment request
public class PaymentGateTest {
    private String customerNumber;
    private double amount;

    public PaymentGateTest(String customerNumber, double amount) {
        this.customerNumber = customerNumber;
        this.amount = amount;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
