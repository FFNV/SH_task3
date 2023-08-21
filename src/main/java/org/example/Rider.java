package org.example;

import org.springframework.stereotype.Component;

@Component
public class Rider {
    private String name;

    public Rider(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
