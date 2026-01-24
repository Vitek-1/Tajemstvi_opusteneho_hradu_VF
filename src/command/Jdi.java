package command;

import game.GameData;
import game.Player;
import game.Room;

import java.util.Scanner;

/**
 * This class is for moving to different room
 */

public class Jdi extends Command {
    Player player;
    GameData gameData;
    Scanner sc = new Scanner(System.in);

    public Jdi(Player player, GameData gameData) {
        this.player = player;
        this.gameData = gameData;
    }

    /**
     * Method that move player to room
     *
     * @return result of move
     */

    @Override
    public String execute() {
        boolean keca = false;

        do {
            System.out.print("Napis mi nazev mistnosti kam chces jit: ");
            String idCile = sc.next();

            try {
                Room novaMistnost = gameData.findRoomById(idCile);
                if (!player.getCurrentRoom().getId().equals(idCile)) {
                    if (player.getCurrentRoom().neighbour(idCile) && !gameData.findRoomById(idCile).isLocked()) {
                        player.setCurrentRoom(novaMistnost);
                        System.out.println("Nachazíš se v " + player.getCurrentRoom().getName() + "\nPopis: " + player.getCurrentRoom().getDescription());
                        keca = true;
                    } else {
                        System.out.println("Nelze jít do této místnosti\n");
                    }
                } else {
                    System.out.println("Proč bys chodil do stejné místnosti???\n");
                }

            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");
            }
        } while (!keca);
        return "Přesun do místnosti " + player.getCurrentRoom().getName() + " byl úspěšný";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
