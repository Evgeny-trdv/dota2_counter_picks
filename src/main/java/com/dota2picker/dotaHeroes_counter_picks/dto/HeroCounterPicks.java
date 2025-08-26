package com.dota2picker.dotaHeroes_counter_picks.dto;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class HeroCounterPicks extends Hero{

    private Set<Hero> heroesCounterPicks;

    public Set<Hero> getHeroesCounterPicks() {
        return heroesCounterPicks;
    }

    public void setHeroesCounterPicks(Set<Hero> heroesCounterPicks) {
        this.heroesCounterPicks = heroesCounterPicks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HeroCounterPicks that = (HeroCounterPicks) o;
        return Objects.equals(heroesCounterPicks, that.heroesCounterPicks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), heroesCounterPicks);
    }

    @Override
    public String toString() {
        return "HeroCounterPicks{" +
                "heroesCounterPicks=" + heroesCounterPicks +
                '}';
    }
}
