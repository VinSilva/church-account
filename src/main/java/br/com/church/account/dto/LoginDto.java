package br.com.church.account.dto;

import br.com.church.account.model.LoginEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class LoginDto {

    private Long id;
    private String name;
    private String password;

    public LoginDto() {
    }

    public LoginDto(LoginEntity loginEntity) {
        this.id = loginEntity.getId();
        this.name = loginEntity.getName();
        this.password = loginEntity.getPassword();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public static List<LoginDto> converterToList(List<LoginEntity> loginEntityList){

         return loginEntityList.stream().map(LoginDto::new).collect(Collectors.toList());

        //A LINHA ACIMA FAZ A MESMA COISA QUE O CÓDIGO ABAIXO
        /*List<LoginDto> listLoginDto = new ArrayList<>();
        for(int i = 0; i < loginEntityList.size(); i++){

            LoginEntity loginEntity = loginEntityList.get(i);
            LoginDto loginDto = new LoginDto(loginEntity);
            listLoginDto.add(loginDto);
        }
        return listLoginDto;*/

    }


}
