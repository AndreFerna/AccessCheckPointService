package co.com.pragma.jpa.repository;

import co.com.pragma.jpa.entities.RegisterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPARegisterRepository extends CrudRepository<RegisterEntity, Long>, QueryByExampleExecutor<RegisterEntity> {
}
