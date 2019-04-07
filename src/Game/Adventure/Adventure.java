package Game.Adventure;

import Game.Player.Player;

public class Adventure {

    private Player player;
    private boolean isAdventureOver;

    public Adventure(Player player){
        this.player = player;
    }

    public void doAdventure(){
        isAdventureOver = false;
        Enemy enemy = new Enemy();
        while (!isAdventureOver){
            player.addExperience(enemy.getXpGiven());
            player.addMoney(enemy.getGoldGiven());
            player.receiveDamage(enemy.getDamage());
            enemy.receiveDamage(player.getStats().getStrength());
            isAdventureOver = !enemy.isAlive();
        }
    }
}
