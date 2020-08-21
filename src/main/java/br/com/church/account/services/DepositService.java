package br.com.church.account.services;

import br.com.church.account.dto.DepositDto;
import br.com.church.account.model.DepositEntity;
import br.com.church.account.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositService {

    @Autowired
    DepositRepository depositRepository;

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

    public DepositEntity save(DepositDto depositDto){
        depositDto.setAmount(this.processAmount(depositDto.getPay_type(), depositDto.getAmount()));
        DepositEntity depositEntity = depositRepository.save(depositDto);
        return depositEntity;
    }
}
