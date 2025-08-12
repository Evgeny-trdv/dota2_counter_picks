package com.dota2picker.dotaHeroes_counter_picks.model;

import com.dota2picker.dotaHeroes_counter_picks.model.attribute.Attribute;

import java.util.Objects;

public class HeroCarry extends Hero {

     private int position;

    public HeroCarry(String name, Attribute attribute, int position) {
        super(name, attribute);
        this.position = position;
    }

    public HeroCarry() {
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HeroCarry heroCarry = (HeroCarry) o;
        return position == heroCarry.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), position);
    }

    @Override
    public String toString() {
        return "HeroCarry{" +
                "position=" + position +
                '}';
    }

}
