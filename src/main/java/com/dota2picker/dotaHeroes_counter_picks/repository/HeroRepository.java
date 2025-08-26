package com.dota2picker.dotaHeroes_counter_picks.repository;

import com.dota2picker.dotaHeroes_counter_picks.entity.HeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeroRepository extends JpaRepository<HeroEntity, Long> {

    public boolean existsHeroByHeroName(String heroName);

    public Optional<HeroEntity> findHeroByHeroName(String heroName);

    public Optional<HeroEntity> findHeroById(Long id);
}
