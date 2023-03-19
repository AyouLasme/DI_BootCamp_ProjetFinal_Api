package com.api.taylor.repository;

import com.api.taylor.models.TMessages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RMessages extends JpaRepository<TMessages,Long> {
//    public List<TMessages> findBySenderDemande(long demande_fk, long sender);
//    List<TMessages> findAllByOrderByTimestampDesc();

}
