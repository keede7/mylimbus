package io.keede.mylimbus.domains.personality.entity;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonalityRepository extends JpaRepository<Personality, Long> {

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"keywords", "passives"})
    @Query("SELECT personality " +
            "FROM Personality personality ")
    List<Personality> findPersonalities();

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"keywords", "passives"})
    @Query("SELECT personality " +
            "FROM Personality personality " +
            "WHERE personality.id = :id ")
    Optional<Personality> findPersonalityById(@Param("id") Long id);

}
