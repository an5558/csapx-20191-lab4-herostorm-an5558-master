package game;

public class HeroStorm {
    private int roundCounter;
    private HeroParty dragonParty;
    private HeroParty lionParty;

    public HeroStorm(int dragonSeed, int lionSeed) {
        roundCounter = 1;
        dragonParty = new HeroParty(Team.DRAGON, dragonSeed);
        lionParty = new HeroParty(Team.LION, lionSeed);
    }

    public HeroParty getDragonParty() {
        return dragonParty;
    }

    public HeroParty getLionParty() {
        return lionParty;
    }

    public void play() {
        while(dragonParty.getHeroes().size() != 0 || lionParty.getHeroes().size() != 0) {

        }
    }

    public static void main(String[] args) {

    }
}
