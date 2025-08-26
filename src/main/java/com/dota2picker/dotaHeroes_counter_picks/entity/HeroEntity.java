package com.dota2picker.dotaHeroes_counter_picks.entity;

import com.dota2picker.dotaHeroes_counter_picks.dto.Hero;
import com.dota2picker.dotaHeroes_counter_picks.entity.attribute.Attribute;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@EqualsAndHashCode
@ToString
@Table(name = "heroes")
public class HeroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String heroName;

    @Enumerated(EnumType.STRING)
    private Attribute attribute;

    @OneToMany
    private Set<HeroEntity> counterPicks;

    public HeroEntity(String name, Attribute attribute) {
        this.heroName = name;
        this.attribute = attribute;
        counterPicks = new HashSet<>();
    }

    public HeroEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String name) {
        this.heroName = name;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public Set<HeroEntity> getCounterPicks() {
        return counterPicks;
    }

    public void setCounterPicks(Set<HeroEntity> counterPicks) {
        this.counterPicks = counterPicks;
    }
}
