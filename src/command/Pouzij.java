package command;

import game.GameData;
import game.Player;

/**
 * This class Pouzij is for using items into game
 */

public class Pouzij extends Command {

    private Player player;
    private GameData gameData;
    private boolean konec = false;
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String YELLOW = "\u001B[33m";

    public Pouzij(Player player, GameData gameData) {
        this.player = player;
        this.gameData = gameData;
    }

    /**
     * this method check if player inventory contains current item and use them
     * @return some text about using item
     */

    @Override
    public String execute() {
        if (player.contains("svicka") && player.contains("zapalovac")) {
            gameData.findRoomById("sklep").unlock();
            return "Napadlo tě zapálit svíčku zapalovačem slyšel jsi cvaknutí ze směru kde je sklep...";
        } else if (player.contains("zlaty_klic") && player.getCurrentRoom().getId().equals("nadvori")) {
            konec = true;
            return "Vezmeš zlatě se " + YELLOW + "třpytící klíč" + RESET + " a vložíš ho do zámku obrovské hradní brány, ustoupíš klíč se otočí v zámku a brána se pomalu otevře. Spojeně odcházíš:)\nDoufám že tě moje hra bavila a že sis jí užil.\n" + BLUE + "Creator: Vitek-1 :)" + RESET;
        } else {
            return "Bohužel nemáš žádnou věc která by se dala někde použít";
        }
    }


    /**
     * This method is here for checking end game
     * @return konec
     */

    @Override
    public boolean exit() {
        return konec;
    }
}