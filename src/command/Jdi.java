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

        try{
            Room novaMistnost = gameData.findRoomById(idCile);
            player.setCurrentRoom(novaMistnost);
            System.out.println("Nachazis se v "+player.getCurrentRoom().getName() +"\nPopis: " + player.getCurrentRoom().getDescription());

        }catch (IllegalArgumentException e) {
            // Pokud findRoomById nenajde místnost, vyhodí chybu (viz tvůj GameData)
            return "Místnost s názvem '" + idCile + "' neexistuje.";
        }
        return "trouba hahah";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
