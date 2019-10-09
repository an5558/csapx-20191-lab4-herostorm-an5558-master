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
//        for(int i = 0; i < 4; i++) {
            System.out.println("Battle #" + roundCounter);
            System.out.println("=========");
            System.out.println(dragonParty);
            System.out.println();
            System.out.println(lionParty);
            System.out.println();
            Hero currentDragon = dragonParty.getHeroes().get(0);
            Hero currentLion = lionParty.getHeroes().get(0);
            if(roundCounter % 2 != 0){
                System.out.println("*** " + currentDragon.getName() + " vs " + currentLion.getName());
                System.out.println();
                currentDragon.attack(currentLion);
                if(currentLion.hasFallen()){
                    System.out.println(currentLion.getName() + " has fallen!");
                    lionParty.removeHero();
                    dragonParty.addHero(dragonParty.removeHero());
                    continue;
                } else if(dragonParty.getHeroes().size() != 0 && lionParty.getHeroes().size() != 0){
                        currentLion.attack(currentDragon);
                        if (currentDragon.hasFallen()) {
                            System.out.println(currentDragon.getName() + " has fallen!");
                            dragonParty.removeHero();
                            lionParty.addHero(lionParty.removeHero());
                            continue;
                        }
                }
                lionParty.addHero(lionParty.removeHero());
                dragonParty.addHero(dragonParty.removeHero());
            } else{
                System.out.println("*** " + currentLion.getName() + " vs " + currentDragon.getName());
                System.out.println();
                currentLion.attack(currentDragon);
                if(currentDragon.hasFallen()){
                    System.out.println(currentDragon.getName() + " has fallen!");
                    dragonParty.removeHero();
                    lionParty.addHero(lionParty.removeHero());
                    continue;
                } else if(dragonParty.getHeroes().size() != 0 && lionParty.getHeroes().size() != 0){
                        currentDragon.attack(currentLion);
                        if (currentLion.hasFallen()) {
                            System.out.println(currentLion.getName() + " has fallen!");
                            lionParty.removeHero();
                            dragonParty.addHero(dragonParty.removeHero());
                            continue;
                        }
                }
                dragonParty.addHero(dragonParty.removeHero());
                lionParty.addHero(lionParty.removeHero());
            }
            roundCounter++;
        }
        if(dragonParty.getHeroes().size() == 0) {
            System.out.println("The Lions have won!");
        } else if(lionParty.getHeroes().size() == 0){
            System.out.println("The Dragons have won!");
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
