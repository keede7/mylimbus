package io.keede.mylimbus.domains.statistic.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author keede
 * Created on 2025/05/21
 */
public interface VisitorActivityRepository extends JpaRepository<VisitorActivity, Long> {

    @Query("SELECT COUNT(DISTINCT v.visitorId) FROM VisitorActivity v " +
            "WHERE YEAR(v.timestamp) = :year AND MONTH(v.timestamp) = :month")
    long countDistinctVisitorsByYearAndMonth(@Param("year") int year, @Param("month") int month);

}
