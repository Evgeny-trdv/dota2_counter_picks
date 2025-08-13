package com.dota2picker.dotaHeroes_counter_picks.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class HeroCounterPick {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "hero_id")
    private Hero hero;

    @OneToMany
    private List<Hero> listHeroes;

}
