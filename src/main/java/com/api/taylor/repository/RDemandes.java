package com.api.taylor.repository;

import com.api.taylor.models.TDemandes;
import com.api.taylor.models.TTaylors;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RDemandes extends CrudRepository<TDemandes, Long> {
}
