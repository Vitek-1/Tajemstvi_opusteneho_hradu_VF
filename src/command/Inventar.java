package command;

import game.Player;

/**
 * This class Inventar is for showing players inventory to him
 * @author vitek
 */

public class Inventar extends Command {

    private Player player;

    public Inventar(Player player) {
        this.player = player;
    }

    /**
     * Writing all things that he has into his inventory into console
     * @return all his items
     * @author vitek
     */

    @Override
    public String execute() {
        return "Inventář: " + player.showInventory();
    }

    /**
     * This method is here for checking end game
     * @return false
     * @author vitek
     */

    @Override
    public boolean exit() {
        return false;
    }
}