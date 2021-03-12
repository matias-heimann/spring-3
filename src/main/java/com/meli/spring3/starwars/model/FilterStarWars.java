package com.meli.spring3.starwars.model;

import lombok.Getter;
import lombok.Setter;

public class FilterStarWars {

    @Getter @Setter
    private String filter;

    public FilterStarWars(String filter) {
        this.filter = filter;
    }
}
