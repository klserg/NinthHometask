package org.example.domains;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ContactType {
    EMAIL("E-Mail"), PHONE("Телефон");
    private final String name;

    public int getId() {
        for (int i = 0; i < values().length ; i++) {
            if (values()[i] == this) return i;
        }
        return 0;
    }
}
