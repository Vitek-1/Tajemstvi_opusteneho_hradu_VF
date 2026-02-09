package command;

import game.Player;

/**
 * This class Inventar is for showing players inventory to him
 */

public class Inventar extends Command {

    private Player player;

    public Inventar(Player player) {
        this.player = player;
    }

    /**
     * Writing all things that he has into his inventory into console
     * @return all his items
     */

    @Override
    public String execute() {
        return "Inventář: " + player.showInventory();
    }

    /**
     * This method is here for checking end game
     * @return false
     */

    @Override
    public boolean exit() {
        return false;
    }
}