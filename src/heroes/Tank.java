package heroes;

import game.Team;
import heroes.Heroes.Role;

public class Tank extends Hero {
    protected static final int DAMAGE_AMOUNT = 15;
    protected static final double SHIELD_DMG_MULTIPLIER = 0.9;
    protected static final int TANK_HIT_POINTS = 40;

    protected Tank(Team team) {
        super(Heroes.getName(team, Heroes.Role.TANK), TANK_HIT_POINTS);
    }

    @Override
    public void attack(Hero enemy) {
        enemy.takeDamage(DAMAGE_AMOUNT);
    }

    @Override
    public Role getRole() {
        return Heroes.Role.BERSERKER;
    }

    @Override
    public void takeDamage(int amount) {
        super.takeDamage((int)(amount*SHIELD_DMG_MULTIPLIER));
    }
}
