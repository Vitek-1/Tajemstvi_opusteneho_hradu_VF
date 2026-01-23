package command;

import game.Player;

public class Prozkoumej extends Command {

    private Player player;

    public Prozkoumej(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        if (!player.getCurrentRoom().getItems().isEmpty()) {
            player.roomExplore();
        } else {
            return "Nic jsi nenašel :(";
        }
        return "Úspěšně prohledáno :)";
    }

    @Override
    public boolean exit() {
        return false;
    }
}