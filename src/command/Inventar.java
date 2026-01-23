package command;

import game.Player;

public class Inventar extends Command {

    private Player player;

    public Inventar(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        return "Inventář: " + player.showInventory();
    }

    @Override
    public boolean exit() {
        return false;
    }
}