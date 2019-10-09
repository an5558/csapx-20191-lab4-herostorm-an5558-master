package heroes;

import game.Team;
import test.TestParty;

/**
 *
 *
 * @author Ayane Naito
 */

public abstract class Hero {
    private String name;
    private final int MAX_HIT_POINTS;
    private int hitPoints;

    protected Hero(String name, int hitPoints) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.MAX_HIT_POINTS = hitPoints;
    }

    public static Hero create(Heroes.Role role, Team team, Party party) {
        if(role == Heroes.Role.BERSERKER) {
            return new Berserker(team);
        } else if(role == Heroes.Role.HEALER) {
            return new Healer(team, party);
        } else {
            return new Tank(team);
        }
    }

    public abstract void attack(Hero enemy);

    public String getName() {
        return name;
    }

    public boolean hasFallen() {
        return (hitPoints == 0);
    }

    public abstract Heroes.Role getRole();

    public void heal(int amount) {
        hitPoints += amount;
        if(hitPoints > MAX_HIT_POINTS){
            hitPoints = MAX_HIT_POINTS;
        }
        System.out.println(name + " heals " + amount + " points");
    }

    public void takeDamage(int amount) {
        hitPoints -= amount;
        if(hitPoints < 0){
            hitPoints = 0;
        }
        System.out.println(name + " takes " + amount + " damage");
    }

    @Override
    public String toString() {
        return (name + ", " + getRole() + ", " + hitPoints + "/" + MAX_HIT_POINTS);
    }
}
