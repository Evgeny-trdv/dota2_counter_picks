package com.dota2picker.dotaHeroes_counter_picks.model;

import com.dota2picker.dotaHeroes_counter_picks.model.attribute.Attribute;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Attribute attribute;

    public Hero(String name, Attribute attribute) {
        this.name = StringUtils.capitalize(name.toLowerCase());
        this.attribute = attribute;
    }

    public Hero() {
    }
}
