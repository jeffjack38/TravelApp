package jaden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jaden.model.Destination;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
    
}

