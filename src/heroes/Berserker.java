package heroes;

import game.Team;
import heroes.Heroes.Role;

/**
 *A glass cannon character with high attack but no defense.
 *
 * @author Ayane Naito
 */

public class Berserker extends Hero {
    protected static final int BERSERKER_HIT_POINTS = 30;
    protected static final int DAMAGE_AMOUNT = 20;

    /**
     * Constructor for Berserker.
     * @param team the team the Berserker should belong to
     */
    protected Berserker(Team team) {
        super(Heroes.getName(team, Heroes.Role.BERSERKER), BERSERKER_HIT_POINTS);
    }

    /**
     * Attacks a given enemy with the Berserker's set Damage Amount.
     * @param enemy the enemy the Berserker should attack
     */
    @Override
    public void attack(Hero enemy) {
        enemy.takeDamage(DAMAGE_AMOUNT);
    }

    /**
     * Accessor for the Berserker role.
     * @return the role of this hero, Berserker
     */
    @Override
    public Role getRole() {
        return Heroes.Role.BERSERKER;
    }
}
