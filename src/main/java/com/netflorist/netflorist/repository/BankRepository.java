package com.netflorist.netflorist.repository;

import com.netflorist.netflorist.entity.Bank;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BankRepository extends CrudRepository<Bank, Long> {

     @Query("SELECT c from Bank c where c.accountNo = :accountNo AND c.pin = :pin")
   public List<Bank> findByAccountNoAndPin(@Param("accountNo") String accountNo ,
                                                    @Param("pin") String pin);
}
