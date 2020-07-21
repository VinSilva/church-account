package br.com.church.account.repository;

import br.com.church.account.model.LoginEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<LoginEntity, Long> {
}
