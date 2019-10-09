package heroes;

import game.Team;
import heroes.Heroes.Role;

public class Healer extends Hero {
    protected static final int DAMAGE_AMOUNT = 10;
    protected static final int HEAL_AMOUNT = 10;
    protected static final int HEALER_HIT_POINTS = 35;
    private Party party;

    protected Healer(Team team, Party party) {
        super(Heroes.getName(team, Heroes.Role.HEALER), HEALER_HIT_POINTS);
        this.party = party;
    }

    @Override
    public void attack(Hero enemy) {
        heal(HEAL_AMOUNT);
        for(Hero h : party.getHeroes()){
            if(h.getName() != this.getName())
                h.heal(HEAL_AMOUNT);
        }
        enemy.takeDamage(DAMAGE_AMOUNT);
    }

    @Override
    public Role getRole() { return Heroes.Role.HEALER; }
}
