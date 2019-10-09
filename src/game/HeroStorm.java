package game;

import heroes.*;

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
        while(dragonParty.getHeroes().size() != 0 && lionParty.getHeroes().size() != 0) {
            System.out.println("Battle #" + roundCounter);
            System.out.println("=========");
            System.out.println(dragonParty);
            System.out.println();
            System.out.println(lionParty);
            System.out.println();
            Hero currentDragon = dragonParty.getHeroes().get(0);
            Hero currentLion = lionParty.getHeroes().get(0);
            System.out.println("*** " + currentDragon.getName() + " vs " + currentLion.getName());
            System.out.println();
            if(roundCounter % 2 != 0){
                currentDragon.attack(currentLion);
                if(currentLion.hasFallen()){
                    System.out.println(currentLion.getName() + " has fallen!");
                    lionParty.removeHero();
                }
                currentLion.attack(currentDragon);
                if(currentDragon.hasFallen()){
                    System.out.println(currentDragon.getName() + " has fallen!");
                    dragonParty.removeHero();
                }
            } else{
                currentLion.attack(currentDragon);
                if(currentDragon.hasFallen()){
                    System.out.println(currentDragon.getName() + " has fallen!");
                    dragonParty.removeHero();
                }
                currentDragon.attack(currentLion);
                if(currentLion.hasFallen()){
                    System.out.println(currentLion.getName() + " has fallen!");
                    lionParty.removeHero();
                }
            }
            lionParty.addHero(currentLion);
            dragonParty.addHero(currentDragon);
            roundCounter++;
        }
    }

    public static void main(String[] args) {
        if(args.length == 2){
            int dragonSeedArg = Integer.parseInt(args[0].split("_")[2]);
            int lionSeedArg = Integer.parseInt(args[1].split("_")[2]);
            HeroStorm game = new HeroStorm(dragonSeedArg, lionSeedArg);
            game.play();
        } else{
            System.out.println("Usage: java HeroStorm dragon_seed_# lion_seed_#");
        }
    }
}
