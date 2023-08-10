package com.db.repository;

import com.db.model.SignalSpec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignalSpecRepository extends JpaRepository<SignalSpec, Long> {
    Optional<SignalSpec> findBySignalId(Long id);
}
