package br.com.church.account.dto;

import br.com.church.account.model.ExpenseEntity;
import br.com.church.account.model.PaymentTypeEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Date;

public class ExpensesDto {

    private String name;
    private String responsible;
    private Double amount;
    private Date creationDate;

    private PaymentTypeEnum paymentType;

    public ExpensesDto(){
    }

    public ExpensesDto(ExpenseEntity expenseEntity){
        this.name = expenseEntity.getName();
        this.responsible = expenseEntity.getResponsible();
        this.amount = expenseEntity.getAmount();
        this.creationDate = expenseEntity.getCreationDate();
        this.paymentType = expenseEntity.getPaymentTypeEnum();
    }

    public ExpensesDto(String name, String responsible, Double amount, Date creationDate, PaymentTypeEnum paymentType){
        this.name = name;
        this.responsible = responsible;
        this.amount = amount;
        this.creationDate = creationDate;
        this.paymentType = paymentType;
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

    @JsonValue
    public PaymentTypeEnum getPaymentType() {
        return paymentType;
    }
}
