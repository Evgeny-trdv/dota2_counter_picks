package com.dota2picker.dotaHeroes_counter_picks.model;

import com.dota2picker.dotaHeroes_counter_picks.model.attribute.Attribute;

import java.util.Objects;

public class Hero {

    private String name;
    private Attribute attribute;

    public Hero(String name, Attribute attribute) {
        this.name = name;
        this.attribute = attribute;
    }

    public Hero() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return Objects.equals(name, hero.name) && attribute == hero.attribute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, attribute);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", attribute=" + attribute +
                '}';
    }
}
