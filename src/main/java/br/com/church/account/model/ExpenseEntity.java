package br.com.church.account.model;

import java.util.Date;

public class ExpenseEntity {

    private Long id;
    private String name;
    private String responsible;
    private Double amount;
    private Date creationDate;
    private PaymentTypeEnum paymentTypeEnum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
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

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public PaymentTypeEnum getPaymentTypeEnum() {
        return paymentTypeEnum;
    }


}
