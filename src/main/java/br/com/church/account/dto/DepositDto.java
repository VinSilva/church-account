package br.com.church.account.dto;

import br.com.church.account.model.ExpenseEntity;
import br.com.church.account.model.PaymentTypeEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Date;

public class DepositDto {

    private Date depositDate;
    private Date creationDate;
    private String name;
    private String responsible;
    private PaymentTypeEnum paymentType;
    private Double amount;

    public DepositDto(){
    }

    public DepositDto(Date creationDate, String name, String responsible, PaymentTypeEnum paymentType, Double amount) {

        this.creationDate = creationDate;
        this.name = name;
        this.responsible = responsible;
        this.paymentType = paymentType;
        this.amount = amount;
    }

    public DepositDto(Date creationDate, String responsible, PaymentTypeEnum paymentType, Double amount) {
        this.creationDate = creationDate;
        this.responsible = responsible;
        this.paymentType = paymentType;
        this.amount = amount;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonValue
    public PaymentTypeEnum getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypeEnum pay_type) {
        this.paymentType = pay_type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getResponsible() {
        return responsible;
    }


}
