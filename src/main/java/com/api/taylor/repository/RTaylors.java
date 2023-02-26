package com.api.taylor.repository;

import com.api.taylor.models.TTaylors;
import com.api.taylor.models.TUsers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RTaylors extends CrudRepository<TTaylors, Long> {

}
