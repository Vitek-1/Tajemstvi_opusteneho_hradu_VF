package command;

import game.GameData;
import game.Player;
import game.Room;

import java.util.Scanner;

public class Jdi extends Command {
    Player player;
    GameData gameData;
    Scanner sc = new Scanner(System.in);

    public Jdi(Player player, GameData gameData) {
        this.player = player;
        this.gameData = gameData;
    }

    @Override
    public String execute() {

        System.out.print("Napis mi nazev mistnosti kam chces jit: ");
        String idCile = sc.next();

        try {
            Room novaMistnost = gameData.findRoomById(idCile);
            if (!player.getCurrentRoom().getId().equals(idCile)) {
                if (player.getCurrentRoom().neighbour(idCile)) {
                    player.setCurrentRoom(novaMistnost);
                    System.out.println("Nachazíš se v " + player.getCurrentRoom().getName() + "\nPopis: " + player.getCurrentRoom().getDescription());
                } else {
                    return "Nelze jít do této místnosti";
                }
            } else {
                return "Proč bys chodil do stejný místnosti???";
            }
        } catch (IllegalArgumentException e) {
            // Pokud findRoomById nenajde místnost, vyhodí chybu (viz tvůj GameData)
            return "Místnost s názvem '" + idCile + "' neexistuje.";
        }
        return "Přesun do jiné místnosti byl úspěšný";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
