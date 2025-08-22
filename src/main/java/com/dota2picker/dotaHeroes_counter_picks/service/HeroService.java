package com.dota2picker.dotaHeroes_counter_picks.service;

import com.dota2picker.dotaHeroes_counter_picks.dto.Hero;
import com.dota2picker.dotaHeroes_counter_picks.entity.HeroEntity;
import com.dota2picker.dotaHeroes_counter_picks.mapper.HeroMapper;
import com.dota2picker.dotaHeroes_counter_picks.repository.HeroRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class HeroService {

    Logger logger = LoggerFactory.getLogger(HeroService.class);

    public final HeroRepository heroRepository;
    public final HeroMapper heroMapper;

    public HeroService(HeroRepository heroRepository, HeroMapper heroMapper) {
        this.heroRepository = heroRepository;
        this.heroMapper = heroMapper;
    }

    public Hero addHero(Hero hero) {

        validateInputData(hero.getHeroName());

        makeNameIsCapitalized(hero);

        if (heroRepository.existsHeroByName(hero.getHeroName())) {
            logger.debug("hero exists");
            throw new ResponseStatusException(HttpStatus.FOUND, "Hero exists"); //требует доработки
        }

        HeroEntity heroEntity = heroMapper.toHeroEntity(hero);

        heroRepository.save(heroEntity);
        logger.info("hero saved");
        return heroMapper.toHeroDto(heroEntity);
    }

    public Hero getHero(String heroName) {
        validateInputData(heroName);

        makeNameIsCapitalized(heroName);

        Optional<HeroEntity> heroEntity = heroRepository
                .findHeroByName(heroName);
        if (heroEntity.isPresent()) {
            return heroMapper.toHeroDto(heroEntity.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hero not found");
        }
    }

    public Hero updateHero(String heroName, Hero hero) {
        validateInputData(heroName);

        makeNameIsCapitalized(heroName);

        Optional<HeroEntity> heroEntity = heroRepository
                .findHeroByName(heroName);
        if (heroEntity.isPresent()) {
            heroRepository.save(heroMapper.toHeroEntity(hero));
            logger.info("hero updated");
            return heroMapper.toHeroDto(heroEntity.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hero not found");
        }
    }

    public void deleteHero(String heroName) {
        validateInputData(heroName);

        makeNameIsCapitalized(heroName);

        Optional<HeroEntity> heroEntity = heroRepository
                .findHeroByName(heroName);
        if (heroEntity.isPresent()) {
            heroRepository.delete(heroEntity.get());
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Hero is deleted");
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hero not found");
    }

    private void validateInputData(String heroName) {
        if (!(validateNameHero(heroName))) {
            logger.error("Hero name is incorrect");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Hero name is incorrect");
        }

        if (heroName.isEmpty()) {
            logger.error("An empty name was entered");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name cannot be empty");
        }
    }

    private static boolean validateNameHero(String heroName) {
        return StringUtils.isAlpha(heroName);
    }

    private static void makeNameIsCapitalized(Hero hero) {
        hero.setHeroName(StringUtils.capitalize(hero.getHeroName().toLowerCase()));
    }

    private static void makeNameIsCapitalized(String heroName) {
        StringUtils.capitalize(heroName.toLowerCase());
    }
}
