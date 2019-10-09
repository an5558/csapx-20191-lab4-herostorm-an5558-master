package game;

import heroes.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import heroes.*;
import game.HeroStorm;
import test.TestParty;

public class HeroParty implements Party{
    private Team team;
    private List<Hero> heroes;

    public HeroParty(Team team, int seed) {
        this.team = team;
        heroes = new ArrayList<Hero>();
        heroes.add(Hero.create(Heroes.Role.BERSERKER, this.team, this));
        heroes.add(Hero.create(Heroes.Role.HEALER, this.team, this));
        heroes.add(Hero.create(Heroes.Role.TANK, this.team, this));
        Collections.shuffle(heroes, new Random(seed));
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public Hero removeHero() {
        return heroes.remove(0);
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public int numHeroes() {
        return heroes.size();
    }

    public Team getTeam() {
        return team;
    }

    @Override
    public String toString() {
        String temp = "";
        if(team == Team.DRAGON) {
            temp = "{DRAGON}: ";
            for(Hero h : heroes){
                temp += "\n" + h.toString();
            }
        } else {
            temp = "{LION}: ";
            for(Hero h : heroes) {
                temp += "\n" + h.toString();
            }
        }
        return temp;
    }
}
