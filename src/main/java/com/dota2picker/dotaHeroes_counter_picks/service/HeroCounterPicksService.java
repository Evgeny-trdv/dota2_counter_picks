package com.dota2picker.dotaHeroes_counter_picks.service;

import com.dota2picker.dotaHeroes_counter_picks.dto.Hero;
import com.dota2picker.dotaHeroes_counter_picks.mapper.HeroMapper;
import com.dota2picker.dotaHeroes_counter_picks.repository.HeroRepository;
import org.springframework.stereotype.Service;

@Service
public class HeroCounterPicksService {

    private final HeroRepository heroRepository;
    private final HeroService heroService;
    private final HeroMapper heroMapper;

    public HeroCounterPicksService(HeroRepository heroRepository, HeroService heroService, HeroMapper heroMapper) {
        this.heroRepository = heroRepository;
        this.heroService = heroService;
        this.heroMapper = heroMapper;
    }

}
