package io.keede.mylimbus.domains.personality.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author keede
 * Created on 2025/04/10
 */
@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Personality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "personality_keywords")
    private List<PersonalityKeyword> keywords;

    @Column(nullable = false, name = "personality_name")
    private String name;

//    private List<String> skills;

    private String mainPassive;

    private String supportPassive;

    private String defend;

    private LocalDateTime releaseDate;

    public Personality(String name) {
        this.name = name;
        this.keywords = List.of(PersonalityKeyword.G사, PersonalityKeyword.N사);
    }

    public Personality(
            String name,
            List<PersonalityKeyword> keywords
    ) {
        this.name = name;
        this.keywords = keywords;
    }

}
