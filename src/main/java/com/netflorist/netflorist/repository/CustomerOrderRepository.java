package com.netflorist.netflorist.repository;


import com.netflorist.netflorist.entity.CustomerOrder;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Long> {

    public List<CustomerOrder> findByCustomerId(String customerId);
}