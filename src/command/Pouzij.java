package command;

import game.GameData;
import game.Player;

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

    @Override
    public String execute() {
        if (player.contains("svicka") && player.contains("zapalovac")) {
            System.out.println("Napadlo tě zapálit svíčku zapalovačem slyšel jsi cvaknutí ze směru kde je sklep...");
            gameData.findRoomById("sklep").unlock();
        } else if (player.contains("zlaty_klic") && player.getCurrentRoom().getId().equals("nadvori")) {
            System.out.println("Vezmeš zlatě se " + YELLOW + "třpytící klíč" + RESET + " a vložíš ho do zámku obrovské hradní brány, ustoupíš klíč se otočí v zámku a brána se pomalu otevře. Spojeně odcházíš:)\nDoufám že tě moje hra bavila a že sis jí užil.\n" + BLUE + "Creator: Vitek-1 :)" + RESET);
            konec = true;
        }
        return "";
    }

    @Override
    public boolean exit() {
        return konec;
    }
}