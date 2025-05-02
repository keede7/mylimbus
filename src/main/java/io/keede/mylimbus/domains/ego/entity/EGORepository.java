package io.keede.mylimbus.domains.ego.entity;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EGORepository extends JpaRepository<EGO, Long> {

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"egoUseConditions"})
    @Query("SELECT ego " +
            "FROM EGO ego " +
            "WHERE ego.characterName = :characterKRName")
    List<EGO> findEGOsByCharacterKRName(@Param("characterKRName") String characterKRName);

}
