package br.com.church.account.services;

import org.springframework.stereotype.Service;

@Service
public class DepositService {

    public DepositService(){
    }

    public Double processAmount(String pay_type, Double amount){
        if(pay_type.toUpperCase().equals("DEBITO") || pay_type.toUpperCase().equals("DÉBITO") ){
            Double result = amount - (amount * 2 / 100);
            return result;
        }else if(pay_type.toUpperCase().equals("CREDITO") || pay_type.toUpperCase().equals("CRÉDITO")){
            Double result = amount - (amount * 3 /100);
            return result;
        }else {
            return amount;
        }
    }
}
