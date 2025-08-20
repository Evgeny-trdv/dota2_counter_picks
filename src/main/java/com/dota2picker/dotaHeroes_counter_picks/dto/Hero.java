package com.dota2picker.dotaHeroes_counter_picks.dto;

import com.dota2picker.dotaHeroes_counter_picks.entity.attribute.Attribute;

import java.util.Objects;

public class Hero {

    private String heroName;
    private Attribute attribute;

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return Objects.equals(heroName, hero.heroName) && attribute == hero.attribute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(heroName, attribute);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "heroName='" + heroName + '\'' +
                ", attribute=" + attribute +
                '}';
    }
}
