package io.keede.mylimbus.domains.personality.entity;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonalityRepository extends JpaRepository<Personality, Long> {

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"keywords"})
    @Query("SELECT personality " +
            "FROM Personality personality " +
            "WHERE personality.id = 1 ")
    List<Personality> findPersonalities();

}
