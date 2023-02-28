package com.api.taylor.repository;


import com.api.taylor.models.TTown;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RTown extends CrudRepository<TTown, Long> {
}
