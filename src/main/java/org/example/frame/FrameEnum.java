package org.example.frame;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Getter
public enum FrameEnum {
    LICZBA_JEDNOSTEK("liczba jednostek"),
    LICZBA_ITERACJI("liczba iteracji"),
    ROZMIAR_MAPY("rozmiar mapy");

    private final String value;

    public static List<FrameEnum> getAll() {
        List<FrameEnum> list = new ArrayList<>();
        Collections.addAll(list, FrameEnum.values());
        return list;
    }
}
