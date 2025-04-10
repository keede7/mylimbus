package io.keede.mylimbus.domains.personality.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author keede
 * Created on 2025/04/10
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Personality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String keyword;

    @Column(nullable = false)
    private String name;

//    private List<String> skills;

    @Column(nullable = false)
    private String mainPassive;

    @Column(nullable = false)
    private String supportPassive;

    @Column(nullable = false)
    private String defend;

    private LocalDateTime releaseDate;

    public Personality(
            String keyword,
            String name,
            String mainPassive,
            String supportPassive,
            String defend,
            LocalDateTime releaseDate
    ) {
        this.keyword = keyword;
        this.name = name;
        this.mainPassive = mainPassive;
        this.supportPassive = supportPassive;
        this.defend = defend;
        this.releaseDate = releaseDate;
    }

}
