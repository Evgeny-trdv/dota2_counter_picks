package com.dota2picker.dotaHeroes_counter_picks.service;

import com.dota2picker.dotaHeroes_counter_picks.model.Hero;
import com.dota2picker.dotaHeroes_counter_picks.repository.HeroRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class HeroService {

    Logger logger = LoggerFactory.getLogger(HeroService.class);

    public final HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public Hero addHero(Hero hero) {
        if (!(validateNameHero(hero))) {
            logger.error("Hero name is incorrect");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Hero name is incorrect");
        }
        if (hero.getName().isEmpty() || hero.getAttribute() == null) {
            logger.error("An empty name was entered");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name cannot be empty");
        }
        if (heroRepository.existsHeroByName(hero.getName())) {
            logger.debug("hero exists");
            throw new ResponseStatusException(HttpStatus.FOUND, "Hero exists"); //требует доработки
        }
        return heroRepository.save(hero);
    }

    public Hero getHero(String heroName) {
        return null; //is being developed
    }

    public Hero getHero(Long id) {
        return null; //is being developed
    }

    public Hero updateHero(Hero hero) {
        return heroRepository.save(hero); //в работе
    }

    public void deleteHero(Hero hero) {
        heroRepository.delete(hero); //is being developed
    }


    private static boolean validateNameHero(Hero hero) {
        return StringUtils.isAlpha(hero.getName());
    }
}
