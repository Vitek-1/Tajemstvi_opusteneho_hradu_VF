package game;

import characters.Ghost_Armorer;
import characters.Ghost_King;
import characters.Ghost_librarian;
import command.*;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Class for creating game menu
 */

public class Console{
    private Player player;
    private GameData gameData;
    private Ghost_librarian librarian;
    private Ghost_King king;
    private Ghost_Armorer  armorer;
    private boolean running;
    private HashMap<String, Command> mapa = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public Console(){}

    /**
     * Method for putting commands into hash map
     */

    private void inicializace() {
        mapa.put("jdi", new Jdi(player, gameData));
        mapa.put("inventar", new Inventar(player));
        mapa.put("mluv", new Mluv(player, armorer, king, librarian,gameData));
        mapa.put("pouzij", new Pouzij(player, gameData));
        mapa.put("prozkoumej", new Prozkoumej(player));
        mapa.put("pomoc", new Help(mapa));
        mapa.put("map", new Map());
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
     * Method for starting game loop
     */

    public void start() {
        gameData = GameData.loadGameDataFromResources("/rooms.json");
        Room startovni_room = gameData.findRoomById("loznice");

        System.out.print(gameData.intro());
        scanner.nextLine();

        System.out.println("Napiš jak se bude jmenovat tvoje postava: ");
        String name =  scanner.next();
        this.player = new Player(name, startovni_room, gameData);
        player.addItem("zapalovac");

        System.out.println(player.getCurrentRoom().getDescription());
        scanner.nextLine();

        System.out.println("Vidíš:\n" + player.getCurrentRoom().labyrintPlan());

        king = new Ghost_King(player, gameData);
        king.loadData();

        librarian = new Ghost_librarian(player, gameData);
        librarian.loadData();

        armorer = new Ghost_Armorer(player, gameData);
        armorer.loadData();

        inicializace();
        try {
            do {
                proved();
            } while (!running);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
