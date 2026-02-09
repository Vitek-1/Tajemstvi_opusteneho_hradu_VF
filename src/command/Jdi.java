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
     * That method is for moving player to different room
     * @return result of move
     */

    @Override
    public String execute() {
        boolean keca = true;
        String idCile;

        do {
            System.out.print("Napis mi nazev mistnosti kam chces jit (pokud nikam 0): ");
            idCile = sc.next();

            try {
                if (!idCile.equals("0")) {
                    Room novaMistnost = gameData.findRoomById(idCile);
                    if (!player.getCurrentRoom().getId().equals(idCile)) {
                        if (player.getCurrentRoom().neighbour(idCile) && !gameData.findRoomById(idCile).isLocked()) {
                            player.setCurrentRoom(novaMistnost);
                            keca = false;
                        } else {
                            System.out.println("Nelze jít do této místnosti.\n");
                        }
                    } else {
                        System.out.println("Proč bys chodil do stejné místnosti???\n");
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");
            }
        } while (keca && !idCile.equals("0"));
        if (!idCile.equals("0")) {
            return "Přesun do místnosti " + player.getCurrentRoom().getName() + " byl úspěšný\n";
        } else {
            return "Přesun byl zrušen!\n";
        }
    }


    /**
     * This method is here for checking end game
     * @return false
     */

    @Override
    public boolean exit() {
        return false;
    }
}
