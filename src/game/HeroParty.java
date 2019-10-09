package game;

import heroes.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import heroes.*;
import game.HeroStorm;
import test.TestParty;

/**
 * Manages the party of heroes (a collection of non-fallen allies on a team).
 * Implements the methods necessary for a FIFO (queue) that allow the hero at the front to
 * move to the back after its attack, or be removed from the party if they have fallen.
 */
public class HeroParty implements Party {
    private Team team;
    private List<Hero> heroes;

    /**
     * Constructor for HeroParty, a collection of non-fallen allies on a given team.
     * @param team the team the party should belong to
     * @param seed the seed given through user input that will be fed into a random number generator to
     *             shuffle the queue.
     */
    public HeroParty(Team team, int seed) {
        this.team = team;
        heroes = new ArrayList<Hero>();
        heroes.add(Hero.create(Heroes.Role.BERSERKER, this.team, this));
        heroes.add(Hero.create(Heroes.Role.HEALER, this.team, this));
        heroes.add(Hero.create(Heroes.Role.TANK, this.team, this));
        Collections.shuffle(heroes, new Random(seed));
    }

    /**
     * Adds a given hero to the back of the queue.
     * @param hero the new hero
     */
    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    /**
     * Removes the hero at the front of the queue and returns the removed hero
     * @return the hero that was removed
     */
    public Hero removeHero() {
        return heroes.remove(0);
    }

    /**
     * Accessor for the party consisting of non-fallen allies on the team
     * @return An ArrayList consisting of non-fallen allies on the team
     */
    public List<Hero> getHeroes() {
        return heroes;
    }

    /**
     * Calculates how many heroes are left on the team.
     * @return the number of non-fallen heroes on a team
     */
    public int numHeroes() {
        return heroes.size();
    }

    /**
     * Accessor for the party's team.
     * @return the team the party belongs to
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Prints the team the party belongs to and the stats of each non-fallen hero in the order of the queue.
     * @return A string that contains information on the team, including the hitPoints of each non-fallen hero
     */
    @Override
    public String toString() {
        String temp = "";
        if(team == Team.DRAGON) {
            temp = "DRAGON: ";
            for(Hero h : heroes){
                temp += "\n" + h.toString();
            }
        } else {
            temp = "LION: ";
            for(Hero h : heroes) {
                temp += "\n" + h.toString();
            }
        }
        return temp;
    }
}
