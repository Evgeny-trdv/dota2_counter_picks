package com.dota2picker.dotaHeroes_counter_picks.controller;

import com.dota2picker.dotaHeroes_counter_picks.dto.Hero;
import com.dota2picker.dotaHeroes_counter_picks.entity.HeroEntity;
import com.dota2picker.dotaHeroes_counter_picks.service.HeroService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @PostMapping
    public Hero addHero(@RequestBody Hero hero) {
        return heroService.addHero(hero);
    }

    @GetMapping("/{heroName}")
    public HeroEntity getHero(@PathVariable String heroName) {
        return heroService.getHero(heroName);
    }

    @GetMapping("/{heroId}")
    public HeroEntity getHero(@PathVariable Long heroId) {
        return heroService.getHero(heroId);
    }
}
