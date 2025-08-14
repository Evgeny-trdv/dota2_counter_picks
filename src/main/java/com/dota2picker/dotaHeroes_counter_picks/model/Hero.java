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
@Setter
@Getter
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Attribute attribute;

    public Hero(String name, Attribute attribute) {
        this.name = name;
        this.attribute = attribute;
    }

    public Hero() {
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
