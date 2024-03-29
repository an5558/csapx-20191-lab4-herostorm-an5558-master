package game;

import heroes.*;

/**
 *The main class for Super Fantasy Hero Storm. Deals with the main game playing.
 * Run program on command line as:
 * $java HeroStorm dragon_seed_# lion_seed_#
 *# represents the integers used to seed the random number generators when shuffling
 * the two teams consisting of 3 heroes.
 *
 * @author Ayane Naito
 */

public class HeroStorm {
    private int roundCounter;
    private HeroParty dragonParty;
    private HeroParty lionParty;

    /**
     * Constructs HeroStorm which deals with the main game playing.
     * @param dragonSeed the integer that seeds the random number generator for the dragon team
     * @param lionSeed the integer that seeds the random number generator for the lion team
     */
    public HeroStorm(int dragonSeed, int lionSeed) {
        roundCounter = 1;
        dragonParty = new HeroParty(Team.DRAGON, dragonSeed);
        lionParty = new HeroParty(Team.LION, lionSeed);
    }

    /**
     * Accessor for the dragonParty
     * @return the dragonParty associated with this instance of HeroStorm
     */
    public HeroParty getDragonParty() {
        return dragonParty;
    }

    /**
     * Accessor for the lionParty
     * @return the lionParty associated with this instance of HeroStorm
     */
    public HeroParty getLionParty() {
        return lionParty;
    }

    /**
     * The method that handles the gameplay for HeroStorm. Determines which team should be attacking,
     * checks to see if there is a winner, removes fallen heroes from the list, and prints status messages
     * and summaries of battles.
     */
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
            if(roundCounter % 2 != 0){
                System.out.println("*** " + currentDragon.getName() + " vs " + currentLion.getName() + "!");
                System.out.println();
                currentDragon.attack(currentLion);
                if(currentLion.hasFallen()){
                    System.out.println(currentLion.getName() + " has fallen!");
                    lionParty.removeHero();
                    dragonParty.addHero(dragonParty.removeHero());
                    roundCounter++;
                    continue;
                } else if(dragonParty.getHeroes().size() != 0 && lionParty.getHeroes().size() != 0){
                        currentLion.attack(currentDragon);
                        if (currentDragon.hasFallen()) {
                            System.out.println(currentDragon.getName() + " has fallen!");
                            dragonParty.removeHero();
                            lionParty.addHero(lionParty.removeHero());
                            roundCounter++;
                            continue;
                        }
                }
                lionParty.addHero(lionParty.removeHero());
                dragonParty.addHero(dragonParty.removeHero());
            } else{
                System.out.println("*** " + currentLion.getName() + " vs " + currentDragon.getName() + "!");
                System.out.println();
                currentLion.attack(currentDragon);
                if(currentDragon.hasFallen()){
                    System.out.println(currentDragon.getName() + " has fallen!");
                    dragonParty.removeHero();
                    lionParty.addHero(lionParty.removeHero());
                    roundCounter++;
                    continue;
                } else if(dragonParty.getHeroes().size() != 0 && lionParty.getHeroes().size() != 0){
                        currentDragon.attack(currentLion);
                        if (currentLion.hasFallen()) {
                            System.out.println(currentLion.getName() + " has fallen!");
                            lionParty.removeHero();
                            dragonParty.addHero(dragonParty.removeHero());
                            roundCounter++;
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

    /**
     * Handles the arguments input by the user, constructing the HeroStorm game using the
     * given integers for the seeds for the corresponding team.
     * @param args
     */
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
