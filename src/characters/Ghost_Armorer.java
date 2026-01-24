package characters;

import game.GameData;
import game.Player;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Ghost_Armorer extends Character {

    private Player player;
    private int count;
    private GameData gameData;
    private Scanner sc = new Scanner(System.in);
    private final ArrayList<String> dialogArmorer = new ArrayList<>();
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";

    public Ghost_Armorer(Player player, GameData gameData) {
        this.player = player;
        this.gameData = gameData;
    }

    @Override
    public void talk(Player player, GameData gamedata) {
        if (player.contains("mec")) {
            System.out.print(dialogArmorer.get(3));
            sc.nextLine();
            System.out.print(dialogArmorer.get(4) + "\n");
            player.removeItem("mec");
            gamedata.findRoomById("vez").unlock();
        } else {
            for (int i = 0; i < dialogArmorer.size() - 2; i++) {
                if (!killed()) {
                    System.out.print(obarviText(dialogArmorer.get(i)));
                    sc.nextLine();
                }
            }
            count++;
        }
    }

    public void loadData() {
        try {
            InputStream isDialogy = getClass().getResourceAsStream("/dialogs.txt"); //
            if (isDialogy != null) {
                BufferedReader brD = new BufferedReader(new InputStreamReader(isDialogy));
                String line;
                while ((line = brD.readLine()) != null) {
                    dialogArmorer.add(line);
                }
                dialogArmorer.subList(0, 11).clear();
            } else {
                System.out.println("Nic jsme nenačetli!!");
            }
        } catch (Exception e) {
            System.out.println("Chyba při načítání dat: " + e.getMessage());
        }
    }

    private String obarviText(String text) {
        return text.replace("Stůj!", RED + "Stůj!" + RESET)
                .replace("mrazivý dotek smrti", RED + "mrazivý dotek smrti" + RESET);

    }

    public boolean killed() {
        if (count > 1) {
            return true;
        }
        return false;
    }
}