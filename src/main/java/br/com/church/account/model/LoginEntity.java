package br.com.church.account.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Login")
public class LoginEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
