package io.keede.mylimbus.domains.personality.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sin {

    WRATH("분노"),
    LUST("욕망"),
    SLOTH("나태"),
    GLUTTONY("탐식"),
    GLOOM("우울"),
    PRIDE("자만"),
    ENVY("질투"),
    ;

    private final String type;

}
