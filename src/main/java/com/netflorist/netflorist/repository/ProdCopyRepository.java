package com.netflorist.netflorist.repository;

import com.netflorist.netflorist.entity.ProductCopy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProdCopyRepository extends CrudRepository<ProductCopy, Long> {

    
}
