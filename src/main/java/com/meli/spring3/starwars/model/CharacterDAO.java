package com.meli.spring3.starwars.model;

import lombok.Getter;

public class CharacterDAO {

    @Getter
    private String name;
    @Getter
    private String height;
    @Getter
    private String mass;
    @Getter
    private String hair_color;
    @Getter
    private String skin_color;
    @Getter
    private String eye_color;
    @Getter
    private String birth_year;
    @Getter
    private String gender;
    @Getter
    private String homeworld;
    @Getter
    private String species;

    public CharacterDAO(){}

    @Override
    public String toString() {
        return "CharacterDAO{" +
                "name='" + name + '\'' +
                '}';
    }
}
