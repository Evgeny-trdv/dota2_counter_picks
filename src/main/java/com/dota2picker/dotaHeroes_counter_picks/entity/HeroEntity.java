package com.dota2picker.dotaHeroes_counter_picks.entity;

import com.dota2picker.dotaHeroes_counter_picks.entity.attribute.Attribute;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@EqualsAndHashCode
@ToString
@Table(name = "heroes")
public class HeroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Attribute attribute;

    public HeroEntity(String name, Attribute attribute) {
        this.name = name;
        this.attribute = attribute;
    }

    public HeroEntity() {
    }

    public Long getId() {
        return id;
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
}
