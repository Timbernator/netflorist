package com.netflorist.netflorist.repository;

import com.netflorist.netflorist.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT p from Product p where p.name = :name ")
   public List<Product> findByName(@Param("name") String name);
}
