package command;

import characters.Ghost_Armorer;
import characters.Ghost_King;
import characters.Ghost_librarian;
import game.GameData;
import game.Player;

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
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}