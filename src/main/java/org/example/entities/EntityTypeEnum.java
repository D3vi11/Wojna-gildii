package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EntityTypeEnum {
    WARRIOR("Wojowników"),
    ARCHER("Łuczników"),
    MAGE("Magów");

    private final String value;
}
