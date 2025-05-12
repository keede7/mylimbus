package io.keede.mylimbus.domains.defense.entity;

import io.keede.mylimbus.domains.personality.entity.Sin;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Defense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Sin sinType;

    private DefenseType defenseType;

    public Defense(
            Sin sinType,
            DefenseType defenseType
    ) {
        this.sinType = sinType;
        this.defenseType = defenseType;
    }

}
