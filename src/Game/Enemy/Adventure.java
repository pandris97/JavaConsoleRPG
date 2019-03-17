package Game.Enemy;

import Game.Player.Player;

public class Adventure {

    private Player player;

    public Adventure(Player player){
        this.player = player;
    }

    public void doAdventure(){
        player.addExperience(1);
        player.addMoney(1);
        player.receiveDamage(1);
    }
}
