package io.keede.mylimbus.domains.personality.entity;

import io.keede.mylimbus.web.dto.response.GetPersonalityResponseDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Embedded
    @AttributeOverrides(
            value = {
//                    @AttributeOverride(name = "skillSequence", column = @Column(name = "first_skill_sequence")),
                    @AttributeOverride(name = "sin", column = @Column(name = "first_skill_sin")),
                    @AttributeOverride(name = "attackType", column = @Column(name = "first_skill_attack_type")),
            }
    )
    private PersonalitySkill firstSkill;

    @Embedded
    @AttributeOverrides(
            value = {
//                    @AttributeOverride(name = "skillSequence", column = @Column(name = "second_skill_sequence")),
                    @AttributeOverride(name = "sin", column = @Column(name = "second_skill_sin")),
                    @AttributeOverride(name = "attackType", column = @Column(name = "second_skill_attack_type")),
            }
    )
    private PersonalitySkill secondSkill;

    @Embedded
    @AttributeOverrides(
            value = {
//                    @AttributeOverride(name = "skillSequence", column = @Column(name = "third_skill_sequence")),
                    @AttributeOverride(name = "sin", column = @Column(name = "third_skill_sin")),
                    @AttributeOverride(name = "attackType", column = @Column(name = "third_skill_attack_type")),
            }
    )
    private PersonalitySkill thirdSkill;

    private int grade;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "personality_id")
    private Set<Passive> passives = new HashSet<>();

    private String defend;

    private LocalDate releaseDate;

    public Personality(
            int grade,
            String name,
            List<PersonalityKeyword> keywords,
            PersonalitySkill firstSkill,
            PersonalitySkill secondSkill,
            PersonalitySkill thirdSkill,
            String defend,
            Set<Passive> passives,
            LocalDate releaseDate
    ) {
        this.grade = grade;
        this.name = name;
        this.keywords = keywords;
        this.firstSkill = firstSkill;
        this.secondSkill = secondSkill;
        this.thirdSkill = thirdSkill;
        this.defend = defend;
        this.passives.addAll(passives);
        this.releaseDate = releaseDate;
    }

    public GetPersonalityResponseDto toDto() {
        return new GetPersonalityResponseDto(
                this.id,
                this.name,
                this.grade,
                this.defend,
                this.firstSkill,
                this.secondSkill,
                this.thirdSkill,
                this.passives.stream()
                        .map(Passive::toDto)
                        .collect(Collectors.toSet()),
                this.releaseDate
        );
    }
}
