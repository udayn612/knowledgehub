package com.stackroute.repository;

import com.stackroute.model.Knowledge;
import com.stackroute.model.Knowledge;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

public interface KnowledgeRepository extends Neo4jRepository<Knowledge,String> {

    @Query("MATCH (u:Knowledge) RETURN u")
    Collection<Knowledge> getAllKnowledge();

    @Query("match(k:Knowledge{paragraphId:{0},intentLevel:{1}}) return k")
    Collection<Knowledge> getKnowledge(Integer paragraphId,String intentLevel);

    //insert knowledge relationship
    @Query("match(p:Concept{name:{0}}) match(k:Knowledge{paragraphId:{1},intentLevel:{2}}) CREATE(p)-[:knowledgeOf {confidenceScore:{3}}]->(k)")
    Collection<Knowledge> insertKnowledgeRelationship(String name,String paragraphId,String intentLevel,double confidenceScore);

    //insert comprehension relationship
    @Query("match(p:Concept{name:{0}}) match(k:Knowledge{paragraphId:{1},intentLevel:{2}}) CREATE(p)-[:comprehensionOf {confidenceScore:{3}}]->(k)")
    Collection<Knowledge> insertComprehensionRelationship(String name,String paragraphId,String intentLevel,double confidenceScore);

    //insert  application relationship
    @Query("match(p:Concept{name:{0}}) match(k:Knowledge{paragraphId:{1},intentLevel:{2}}) CREATE(p)-[:applicationOf {confidenceScore:{3}}]->(k)")
    Collection<Knowledge> insertApplicationRelationship(String name,String paragraphId,String intentLevel,double confidenceScore);

    //insert analysis application
    @Query("match(p:Concept{name:{0}}) match(k:Knowledge{paragraphId:{1},intentLevel:{2}}) CREATE(p)-[:analysisOf {confidenceScore:{3}}]->(k)")
    Collection<Knowledge> insertAnalysisRelationship(String name,String paragraphId,String intentLevel,double confidenceScore);

    //insert synthesis application
    @Query("match(p:Concept{name:{0}}) match(k:Knowledge{paragraphId:{1},intentLevel:{2}}) CREATE(p)-[:synthesisOf {confidenceScore:{3}}]->(k)")
    Collection<Knowledge> insertSynthesisRelationship(String name,String paragraphId,String intentLevel,double confidenceScore);

    //insert evaluation application
    @Query("match(p:Concept{name:{0}}) match(k:Knowledge{paragraphId:{1},intentLevel:{2}}) CREATE(p)-[:evaluationOf {confidenceScore:{3}}]->(k)")
    Collection<Knowledge> insertEvaluationRelationship(String name,String paragraphId,String intentLevel,double confidenceScore);
}
