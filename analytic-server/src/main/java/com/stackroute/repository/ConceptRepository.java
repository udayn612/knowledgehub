package com.stackroute.repository;

import com.stackroute.domain.Concept;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface ConceptRepository extends Neo4jRepository<Concept, Integer> {
    @Query("MATCH(u:Concept) RETURN u")
    Collection<Concept> getAllConcepts();
}
