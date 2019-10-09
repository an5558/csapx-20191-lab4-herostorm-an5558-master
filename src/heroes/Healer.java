package heroes;

import game.Team;
import heroes.Heroes.Role;

public class Healer extends Hero {
    protected static final int DAMAGE_AMOUNT = 10;
    protected static final int HEAL_AMOUNT = 10;
    protected static final int HEALER_HIT_POINTS = 35;

    protected Healer(Team team, Party party) {
        super(Heroes.getName(team, Heroes.Role.HEALER), HEALER_HIT_POINTS);
    }

    @Override
    public void attack(Hero enemy) { }

    @Override
    public Role getRole() { return Heroes.Role.HEALER; }
}
