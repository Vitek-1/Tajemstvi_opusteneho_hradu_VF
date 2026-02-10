package command;

import characters.Ghost_Armorer;
import characters.Ghost_King;
import characters.Ghost_librarian;
import game.GameData;
import game.Player;

/**
 * This class is for start talk between player and npc
 */

public class Mluv extends Command {

    private Player player;
    private Ghost_Armorer armorer;
    private Ghost_King king;
    private Ghost_librarian librarian;
    private GameData gameData;

    public Mluv(Player player, Ghost_Armorer armorer, Ghost_King king, Ghost_librarian librarian, GameData gameData) {
        this.player = player;
        this.armorer = armorer;
        this.king = king;
        this.librarian = librarian;
        this.gameData = gameData;
    }

    /**
     * This method check where is the player and choose the dialog
     *
     * @return dialog or there is no one to talk
     */

    @Override
    public String execute() {
        switch (player.getCurrentRoom().getId()) {
            case "nadvori":
                armorer.talk(player, gameData);
                break;
            case "hrad_sin":
                king.talk(player, gameData);
                break;
            case "knihovna":
                librarian.talk(player, gameData);
                break;
            default:
                return "Nikdo zde není...";
        }
        return "";
    }


    /**
     * This method is here for checking end game
     * @return false or true dippends on the situation
     */

    @Override
    public boolean exit() {
        return armorer.killed();
    }
}