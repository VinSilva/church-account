package br.com.church.account.model;

import java.io.Serializable;
import java.util.Date;

public class DepositEntity implements Serializable {

    private Long id;
    private Date deposit_date;
    private String name;
    private String type;
    private String pay_type;
    private Double amount;

    public DepositEntity(){
    }

    public DepositEntity(Long id, Date deposit_date, String name, String type, String pay_type, Double amount) {
        this.id = id;
        this.deposit_date = deposit_date;
        this.name = name;
        this.type = type;
        this.pay_type = pay_type;
        this.amount = amount;
    }

    public DepositEntity(Long id, Date deposit_date, String type, String pay_type, Double amount) {
        this.id = id;
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

    public String getPay_type() { return pay_type; }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }
}
