package com.netflorist.netflorist.repository;

import com.netflorist.netflorist.entity.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository extends CrudRepository<Customer, String> {

   
   @Query("SELECT c from Customer c where c.username = :username AND c.password = :password")
   public List<Customer> findByUsernameAndPassword(@Param("username") String username ,
                                                    @Param("password") String password);
}
