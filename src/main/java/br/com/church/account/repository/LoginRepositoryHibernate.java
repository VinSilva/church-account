package br.com.church.account.repository;

import br.com.church.account.model.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepositoryHibernate extends JpaRepository<LoginEntity,Long> {

    List<LoginEntity> findByName(String name);

}
