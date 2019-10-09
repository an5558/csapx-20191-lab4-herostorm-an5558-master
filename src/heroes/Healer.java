package heroes;

import game.Team;
import heroes.Heroes.Role;

/**
 * A hero that can restore their own hit points and the hit points of their non-fallen allies when it is their turn
 * to attack. Can also deal damage but it is very little.
 *
 */

public class Healer extends Hero {
    protected static final int DAMAGE_AMOUNT = 10;
    protected static final int HEAL_AMOUNT = 10;
    protected static final int HEALER_HIT_POINTS = 35;
    private Party party;

    /**
     * Constructor for the Healer.
     * @param team the team the Healer should belong to
     * @param party the party the Healer should belong to, used to determine which party to heal
     */
    protected Healer(Team team, Party party) {
        super(Heroes.getName(team, Heroes.Role.HEALER), HEALER_HIT_POINTS);
        this.party = party;
    }

    /**
     * The Healer heals themselves first, then heals their non-fallen allies, and finally attacks.
     * Prints status messages that says who was healed and by how much, as well as who took how much damage.
     * @param enemy
     */
    @Override
    public void attack(Hero enemy) {
        heal(HEAL_AMOUNT);
        for(Hero h : party.getHeroes()){
            if(h.getName() != this.getName())
                h.heal(HEAL_AMOUNT);
        }
        enemy.takeDamage(DAMAGE_AMOUNT);
    }

    /**
     * Accessor for the Healer role.
     * @return the role of this Hero, the Healer
     */
    @Override
    public Role getRole() { return Heroes.Role.HEALER; }
}
