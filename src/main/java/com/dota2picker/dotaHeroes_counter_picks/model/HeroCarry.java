package com.dota2picker.dotaHeroes_counter_picks.model;

import com.dota2picker.dotaHeroes_counter_picks.model.attribute.Attribute;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
public class HeroCarry extends Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int position;

    public HeroCarry(String name, Attribute attribute, int position) {
        super(name, attribute);
        this.position = position;
    }

    public HeroCarry() {
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
