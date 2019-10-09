package heroes;

import game.Team;
import heroes.Heroes.Role;

/**
 * A Hero with high defense and a higher amount of hit points. They are capable of absorbing a portion of
 * the incoming attack.
 */
public class Tank extends Hero {
    protected static final int DAMAGE_AMOUNT = 15;
    protected static final double SHIELD_DMG_MULTIPLIER = 0.9;
    protected static final int TANK_HIT_POINTS = 40;

    /**
     * Constructor for the Tank.
     * @param team the team that the Tank should belong to
     */
    protected Tank(Team team) {
        super(Heroes.getName(team, Heroes.Role.TANK), TANK_HIT_POINTS);
    }

    /**
     * Attacks a given enemy with the damage amount of a tank.
     * @param enemy the enemy the tank should attack
     */
    @Override
    public void attack(Hero enemy) {
        enemy.takeDamage(DAMAGE_AMOUNT);
    }

    /**
     * Accessor for the role of the Tank.
     * @return the role of this hero, Tank
     */
    @Override
    public Role getRole() {
        return Heroes.Role.TANK;
    }

    /**
     * Absorbs part of the damage from the incoming attack by the shield damage multiplier
     * before applying the remaining damage.
     * @param amount the amount of initial damage the Tank should take
     */
    @Override
    public void takeDamage(int amount) {
        super.takeDamage((int)(amount*SHIELD_DMG_MULTIPLIER));
    }
}
