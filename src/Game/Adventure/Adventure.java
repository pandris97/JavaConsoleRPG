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

        Fight();
    }

    private void Fight(){
        Enemy enemy = new Enemy();
        System.out.println(enemy.toString());


        while (!isAdventureOver){
            player.addExperience(enemy.getXpGiven());
            player.addMoney(enemy.getGoldGiven());
            player.receiveDamage(enemy.getDamage());
            enemy.receiveDamage(player.getStats().getStrength());

            System.out.println(player.getName() + " támad " + player.getStats().getStrength() + " erővel!");
            System.out.println(enemy.getName() + " visszatámad " + enemy.getDamage() + " erővel!");
            System.out.println(player.getName() + " életereje: " + player.getStats().getCurrentHealth() + ". "
                    + enemy.getName() + " életereje: " + enemy.getHealth());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isAdventureOver = !enemy.isAlive();
        }
        System.out.println("A harc végetért. " + player.getName() + " győzött!");
        System.out.println("Kapott arany: " + enemy.getGoldGiven() + ", kapott XP: " + enemy.getXpGiven() );
    }
}
