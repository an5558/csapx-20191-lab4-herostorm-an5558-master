package heroes;

import game.Team;
import test.TestParty;

/**
 *A Hero battles heroes from the other team in a queue based game.
 * Heroes have three roles: Berserker, Healer, and Tank. Each role has its own strengths and weaknesses.
 *
 * @author Ayane Naito
 */

public abstract class Hero {
    private String name;
    private final int MAX_HIT_POINTS;
    private int hitPoints;

    /**
     * Constructor for Hero, also assigns the maximum amount of hit points the hero is allowed to have.
     * @param name The name of the Hero
     * @param hitPoints The amount of hit points that the hero should have
     */
    protected Hero(String name, int hitPoints) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.MAX_HIT_POINTS = hitPoints;
    }

    /**
     * Creates a Hero of the specified role for the specified team and party.
     * @param role the role the Hero should have
     * @param team the team the Hero should belong to
     * @param party the party the Hero should belong to
     * @return A Hero with the specifications according to the parameters
     */
    public static Hero create(Heroes.Role role, Team team, Party party) {
        if(role == Heroes.Role.BERSERKER) {
            return new Berserker(team);
        } else if(role == Heroes.Role.HEALER) {
            return new Healer(team, party);
        } else {
            return new Tank(team);
        }
    }

    /**
     * Abstract method for attacking a specified enemy.
     * @param enemy the enemy that the Hero should attack
     */
    public abstract void attack(Hero enemy);

    /**
     * Accessor for the name of the Hero
     * @return the Hero's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns true if the Hero has fallen, which is when their hit points reach 0.
     * @return True if the Hero has fallen, False if the Hero is un-fallen.
     */
    public boolean hasFallen() {
        return (hitPoints == 0);
    }

    /**
     * Abstract method that returns the role of the Hero
     * @return the role of the Hero
     */
    public abstract Heroes.Role getRole();

    /**
     * Recovers a certain amount of hit points specified by the amount given. If the amount
     * to be healed exceeds the Hero's maximum amount of hit points, then
     * @param amount the amount the Hero should be healed for,then the Hero will be healed to
     *               maximum health.
     */
    public void heal(int amount) {
        hitPoints += amount;
        if(hitPoints > MAX_HIT_POINTS){
            hitPoints = MAX_HIT_POINTS;
        }
        System.out.println(name + " heals " + amount + " points");
    }

    /**
     * Subtracts specified amount of hit points from Hero.
     * @param amount amount Hero should take damage
     */
    public void takeDamage(int amount) {
        hitPoints -= amount;
        if(hitPoints < 0){
            hitPoints = 0;
        }
        System.out.println(name + " takes " + amount + " damage");
    }

    /**
     * Returns a string that contains the name, role of the Hero, and current hit points compared to
     * their maximum hit points.
     * @return
     */
    @Override
    public String toString() {
        return (name + ", " + getRole() + ", " + hitPoints + "/" + MAX_HIT_POINTS);
    }
}
