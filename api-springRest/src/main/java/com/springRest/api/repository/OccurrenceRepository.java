package com.springRest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springRest.api.model.Occurrence;

@Repository
public interface OccurrenceRepository extends JpaRepository<Occurrence, Long> {

}
