package Game.Adventure;

import Game.Entity.*;
import Game.Player.Player;
import Game.Menus.AdventureMenu;

import java.util.Random;

public class Adventure {

    private Player player;
    private boolean isAdventureOver;
    Enemy randEnemy;

    public Adventure(){
        this.player = Player.getCurrentCharacter();
        setRandEnemy();
    }

    public void doAdventure(){
        isAdventureOver = false;

        Fight();
    }

    private void Fight(){

        while (!isAdventureOver){
            player.receiveDamage(randEnemy.getDamage());
            randEnemy.receiveDamage(player.getStats().getStrength());

            System.out.println(player.getName() + " deals " + player.getStats().getStrength() + " damage!");
            System.out.println(randEnemy.getName() + " deals " + randEnemy.getDamage() + " damage back at you!");
            System.out.println("Health of " + player.getName()  + player.getStats().getCurrentHealth() + ". "
                    + randEnemy.getName() + " 's Health: " + randEnemy.getHealth());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isAdventureOver = !randEnemy.isAlive();
        }
        player.addExperience(randEnemy.getXpGiven());
        player.addMoney(randEnemy.getGoldGiven());
        System.out.println("The Battle has ended. " + player.getName() + " Wins!");
        System.out.println("Gold Looted: " + randEnemy.getGoldGiven() + ", Earned XP: " + randEnemy.getXpGiven() );
    }

    public void setRandEnemy() {
        Random rand = new Random();
        int randNum = rand.nextInt(7);

        switch (randNum){
            case 0:
                randEnemy = new Ghoul();
            case 1:
                randEnemy = new Goblin();
                break;
            case 2:
                randEnemy = new Slime();
                break;
            case 3:
                randEnemy = new Skeleton();
                break;
            case 4:
                randEnemy = new Boar();
                break;
            case 5:
                randEnemy = new Bandit();
                break;
            case 6:
                randEnemy = new MotherInLaw();
                break;
        }
    }

    public String getEnemy() {
        return randEnemy.toString();
    }
}
