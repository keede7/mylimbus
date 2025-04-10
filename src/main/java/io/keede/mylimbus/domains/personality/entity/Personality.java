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

//    @Column(nullable = false)
    private String keyword;

    @Column(nullable = false)
    private String name;

//    private List<String> skills;

    private String mainPassive;

    private String supportPassive;

    private String defend;

    private LocalDateTime releaseDate;

    public Personality(String name) {
        this.name = name;
    }

}
