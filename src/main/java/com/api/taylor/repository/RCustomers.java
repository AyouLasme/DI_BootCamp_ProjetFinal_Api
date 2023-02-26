package com.api.taylor.repository;

import com.api.taylor.models.TCustomers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RCustomers extends CrudRepository<TCustomers, Long> {
}
