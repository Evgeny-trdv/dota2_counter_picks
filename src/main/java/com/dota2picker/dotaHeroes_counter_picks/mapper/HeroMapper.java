package com.dota2picker.dotaHeroes_counter_picks.mapper;

import com.dota2picker.dotaHeroes_counter_picks.dto.Hero;
import com.dota2picker.dotaHeroes_counter_picks.entity.HeroEntity;
import org.springframework.stereotype.Component;

@Component
public class HeroMapper {

    public Hero toHeroDto(HeroEntity heroEntity) {
        Hero hero = new Hero();
        hero.setHeroName(heroEntity.getHeroName());
        hero.setAttribute(heroEntity.getAttribute());
        return hero;
    }

    public HeroEntity toHeroEntity(Hero hero) {
        HeroEntity heroEntity = new HeroEntity();
        heroEntity.setHeroName(hero.getHeroName());
        heroEntity.setAttribute(hero.getAttribute());
        return heroEntity;
    }
}
