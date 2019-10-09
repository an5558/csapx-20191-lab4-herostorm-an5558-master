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

    protected Hero(String name, int hitPoints) {
        this.name = name;
    }

    public static Hero create(Heroes.Role role, Team team, TestParty party) {
        if(role == Heroes.Role.BERSERKER) {
            return new Berserker(team);
        }
        return null;
    }

    public abstract void attack(Hero enemy);

    public String getName() {
        return name;
    }

    public boolean hasFallen() { return false; }

    public abstract Heroes.Role getRole();

    public void heal(int amount) {}

    public void takeDamage(int amount) {}

    @Override
    public String toString() { return null; }
}
