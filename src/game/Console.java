package game;

import command.*;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Class for creating menu
 */

public class Console{
    private Player player;
    private GameData gameData;
    private boolean running;
    private HashMap<String, Command> mapa = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public Console(){}

    /**
     * Method for putting commands into hash map
     */

    private void inicializace() {
        mapa.put("jdi", new Jdi(this.player, this.gameData));
        mapa.put("inventar", new Inventar(this.player));
        mapa.put("mluv", new Mluv());
        mapa.put("pouzij", new Pouzij());
        mapa.put("prozkoumej", new Prozkoumej(this.player));
        mapa.put("help", new Help(this.mapa));
    }

    /**
     * Method for creating command line
     */

    private void proved() {
        System.out.print(">> ");
        String prikaz = scanner.next();
        prikaz = prikaz.trim().toLowerCase();
        if (mapa.containsKey(prikaz)) {
            System.out.println(">> " + mapa.get(prikaz).execute());
            running = mapa.get(prikaz).exit();
        } else {
            System.out.println(">> Nedefinovany prikaz");
        }
    }

    /**
     * Method for rtarting game loop
     */

    public void start() {
        gameData = GameData.loadGameDataFromResources("/Rooms.json");
        Room startovni_room = gameData.findRoomById("nadvori");
        this.player = new Player(startovni_room, true);
        inicializace();
        try {
            do {
                proved();
            } while (!running);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void endGame(boolean victory){}

    private void checkVictory(){}
}
