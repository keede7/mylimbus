package io.keede.mylimbus.domains.personality.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AttackType {

    SLASH("참격"),
    PIERCE("찌르기"),
    BLUNT("타격"),
    ;

    private final String type;

}
