package br.com.church.account.dto;

import java.util.Date;

public class DepositDto {

    private Date deposit_date;
    private String name;
    private String type;
    private String pay_type;
    private Double amount;

    public DepositDto(){
    }

    public DepositDto(Date deposit_date, String name, String type, String pay_type, Double amount) {

        this.deposit_date = deposit_date;
        this.name = name;
        this.type = type;
        this.pay_type = pay_type;
        this.amount = amount;
    }

    public DepositDto( Date deposit_date, String type, String pay_type, Double amount) {
        this.deposit_date = deposit_date;
        this.type = type;
        this.pay_type = pay_type;
        this.amount = amount;
    }

    public Date getDeposit_date() {
        return deposit_date;
    }

    public void setDeposit_date(Date deposit_date) {
        this.deposit_date = deposit_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
