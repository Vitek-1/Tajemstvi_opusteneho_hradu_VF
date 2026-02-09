package characters;

import game.GameData;
import game.Player;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class Ghost_Armorer is for creating an armored enemy in the game
 */

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

    /**
     * This method talk is made for talking player with npc
     * @param player for getting player methods
     * @param gamedata for getting gamedata
     */

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

    /**
     * This method loadData is for loading data from dialogs
     */

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

    /**
     * This method is for changing colours in the console
     * @param text input text from the dialogs
     * @return writing into console coloured text
     */

    private String obarviText(String text) {
        return text.replace("Stůj!", RED + "Stůj!" + RESET)
                .replace("mrazivý dotek smrti", RED + "mrazivý dotek smrti" + RESET);

    }

    /**
     * This method is for killing the player
     * @return that is the player killed or not
     */

    public boolean killed() {
        if (count > 1) {
            return true;
        }
        return false;
    }
}