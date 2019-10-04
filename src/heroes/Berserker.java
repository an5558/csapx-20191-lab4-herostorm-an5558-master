package heroes;

import game.Team;
import heroes.Heroes.Role;

public class Berserker extends Hero {
    private static final int BERSERKER_HIT_POINTS = 30;

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
