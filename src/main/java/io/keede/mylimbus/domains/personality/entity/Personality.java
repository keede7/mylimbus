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

    @Enumerated
    @AttributeOverrides(
            value = {
                    @AttributeOverride(name = "skillSequence", column = @Column(name = "first_skill_sequence")),
                    @AttributeOverride(name = "sin", column = @Column(name = "first_skill_sin")),
                    @AttributeOverride(name = "attackType", column = @Column(name = "first_skill_attack_type")),
            }
    )
    private PersonalitySkill firstSkill;

    @Enumerated
    @AttributeOverrides(
            value = {
                    @AttributeOverride(name = "skillSequence", column = @Column(name = "second_skill_sequence")),
                    @AttributeOverride(name = "sin", column = @Column(name = "second_skill_sin")),
                    @AttributeOverride(name = "attackType", column = @Column(name = "second_skill_attack_type")),
            }
    )
    private PersonalitySkill secondSkill;

    @Enumerated
    @AttributeOverrides(
            value = {
                    @AttributeOverride(name = "skillSequence", column = @Column(name = "third_skill_sequence")),
                    @AttributeOverride(name = "sin", column = @Column(name = "third_skill_sin")),
                    @AttributeOverride(name = "attackType", column = @Column(name = "third_skill_attack_type")),
            }
    )
    private PersonalitySkill thirdSkill;

    private int grade;

    private String mainPassive;

    private String supportPassive;

    private String defend;

    private LocalDateTime releaseDate;

    public Personality(
            String name,
            List<PersonalityKeyword> keywords
    ) {
        this.name = name;
        this.keywords = keywords;
    }

    public Personality(
            int grade,
            String name,
            List<PersonalityKeyword> keywords
    ) {
        this.grade = grade;
        this.name = name;
        this.keywords = keywords;
    }

}
