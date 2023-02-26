package com.api.taylor.repository;

import com.api.taylor.models.TUsers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RUsers extends CrudRepository<TUsers, Long> {

}
