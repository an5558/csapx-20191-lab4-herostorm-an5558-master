package heroes;

import game.Team;
import heroes.Heroes.Role;

/**
 *
 *
 * @author Ayane Naito
 */

public class Berserker extends Hero {
    protected static final int BERSERKER_HIT_POINTS = 30;
    protected static final int DAMAGE_AMOUNT = 20;

    protected Berserker(Team team) {
        super(Heroes.getName(team, Heroes.Role.BERSERKER), BERSERKER_HIT_POINTS);
    }

    @Override
    public void attack(Hero enemy) { }

    @Override
    public Role getRole() {
        return Heroes.Role.BERSERKER;
    }
}
