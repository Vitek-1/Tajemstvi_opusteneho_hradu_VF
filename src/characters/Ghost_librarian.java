package characters;

import game.GameData;
import game.Player;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Ghost_librarian extends Character {

    private Player player;
    private GameData gameData;
    private Scanner sc = new Scanner(System.in);
    private final ArrayList<String> dialogLibrarian = new ArrayList<>();
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";

    public Ghost_librarian(Player player, GameData gameData) {
        this.player = player;
        this.gameData = gameData;
    }

    @Override
    public void talk(Player player, GameData gamedata) {
        if (player.contains("stara_kniha")){
            System.out.println(dialogLibrarian.get(4));
            sc.nextLine();
            System.out.print("S hlasitým skřípěním se masivní zeď pohnula a odhalila průchod, o kterém svět dávno zapomněl.");
            sc.nextLine();
            System.out.print("Bez váhání jsi vykročil vstříc stínům, které pohltily tvé kroky, jakmile jsi vstoupil do hlubin temné místnosti...\n");
            player.removeItem("stara_kniha");
            gamedata.findRoomById("tajna_mist").unlock();
            player.setCurrentRoom(gamedata.findRoomById("tajna_mist"));
        } else {
            for (int i = 0; i < dialogLibrarian.size() - 1; i++) {
                System.out.print(obarviText(dialogLibrarian.get(i)));
                sc.nextLine();
            }
            System.out.println("Knihu získáš v temném sklepě za pomocí svíčky a zapalovače.");
        }
    }

    public void loadData(){
        try {
            InputStream isDialogy = getClass().getResourceAsStream("/dialogs.txt"); //
            if (isDialogy != null) {
                BufferedReader brD = new BufferedReader(new InputStreamReader(isDialogy));
                    String line;
                    while (!(line = brD.readLine()).equals("stuj")) {
                        dialogLibrarian.add(line);
                    }
                dialogLibrarian.subList(0, 5).clear();
            } else {
                System.out.println("Nic jsme nenačetli!!");
            }
        } catch (Exception e) {
            System.out.println("Chyba při načítání dat: " + e.getMessage());
        }
    }

    private String obarviText(String text) {
        return text.replace("vyrušeny!", RED + "vyrušeny!" + RESET);
    }
}