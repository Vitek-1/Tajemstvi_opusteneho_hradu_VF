package command;

import game.Player;

/**
 * This class is for searching items into current location
 * @author vitek
 */

public class Prozkoumej extends Command {

    private Player player;

    public Prozkoumej(Player player) {
        this.player = player;
    }

    /**
     * This method is for searching the items into locations
     * @return the result of searching
     * @author vitek
     */

    @Override
    public String execute() {
        if (!player.getCurrentRoom().getItems().isEmpty()) {
            player.roomExplore();
            return "Úspěšně prohledáno :)";
        } else {
            return "Nic jsi nenašel :(";
        }
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