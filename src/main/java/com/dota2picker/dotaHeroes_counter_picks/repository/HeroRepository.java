package com.dota2picker.dotaHeroes_counter_picks.repository;

import com.dota2picker.dotaHeroes_counter_picks.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {

}
