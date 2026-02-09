package characters;

import game.GameData;
import game.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Class Ghost_King is for creating king in the game
 */

public class Ghost_King extends Character {

    private Player player;
    private GameData gameData;
    private Scanner sc = new Scanner(System.in);
    private Random rn = new Random();
    private final ArrayList<String> riddles = new ArrayList<>();
    private final ArrayList<String> answers = new ArrayList<>();
    private final ArrayList<String> dialogKing = new ArrayList<>();
    private ArrayList<Integer> pouzite = new ArrayList<>();
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String YELLOW = "\u001B[33m";

    public Ghost_King(Player player, GameData gameData) {
        this.player = player;
        this.gameData = gameData;
    }

    /**
     * This method talk is made for talking player with npc
     * @param player for getting player methods
     * @param gameData for getting gamedata
     */

    @Override
    public void talk(Player player, GameData gameData) {
        if (player.contains("prsten")) {
            System.out.println(obarviText(dialogKing.get(3)));
            sc.nextLine();
            hadanky();
        } else {
            for (int i = 0; i < dialogKing.size() - 1; i++) {
                System.out.print(obarviText(dialogKing.get(i)));
                sc.nextLine();
            }
        }
    }

    public void loadData() {
        try {
            InputStream isHadanky = getClass().getResourceAsStream("/hadanky.csv");
            if (isHadanky != null) {
                BufferedReader brH = new BufferedReader(new InputStreamReader(isHadanky));
                String line;
                while ((line = brH.readLine()) != null) {
                    String[] parts = line.split("\\."); //
                    if (parts.length >= 2) {
                        riddles.add(parts[0] + ".");
                        answers.add(parts[1]);
                    }
                }
            } else {
                System.out.println("Nic jsme nenačetli!!");
            }

            InputStream isDialogy = getClass().getResourceAsStream("/dialogs.txt"); //
            if (isDialogy != null) {
                BufferedReader brD = new BufferedReader(new InputStreamReader(isDialogy));
                String line;
                while (!(line = brD.readLine()).equals("stop")) {
                    dialogKing.add(line);
                }
            } else {
                System.out.println("Nic jsme nenačetli!!");
            }

        } catch (Exception e) {
            System.out.println("Chyba při načítání dat: " + e.getMessage());
        }
    }

    /**
     * Method hadanky is for player to get the golden key for exit
     * @return whether he succeeded
     */

    private boolean hadanky() {
        int spravne = 0;
        int chybne = 0;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            int index;

            do {
                index = rn.nextInt(0, riddles.size());
            }while (pouzite.contains(index));
            pouzite.add(index);

            System.out.println("\nKrál: " + riddles.get(index));
            System.out.print("Tvá odpověď: ");
            String odpovedHrace = sc.nextLine().trim().toLowerCase();

            if (odpovedHrace.equals(answers.get(index).toLowerCase())) {
                System.out.println("Král: " + GREEN + "Správně..." + RESET);
                spravne++;
            } else {
                System.out.println("Král: " + RED + "Špatně!" + RESET + " Cítím tvůj strach. (" + answers.get(index) + ")");
                chybne++;
            }

            if (chybne == 2) {
                System.out.println("\nKrál se začal hrozivě smát a pronesl: Tvá cesta zde" + RED + "končí." + RESET);
                return false;
            }
        }

        if (spravne >= 2) {
            System.out.println("\nKrál: Uspěl jsi, smrtelníku. Zde je tvá odměna.");
            player.addItem("zlaty_klic");
            player.removeItem("prsten");
            System.out.println(player.showInventory());
        }
        return true;
    }

    /**
     * This method is for changing colours in the console
     * @param text input text from the dialogs
     * @return writing into console coloured text
     */

    private String obarviText(String text) {
        return text.replace("zlatý prsten", YELLOW + "zlatý prsten" + RESET)
                .replace("zlatý klíč", YELLOW + "zlatý klíč" + RESET)
                .replace("dvě správně", BLUE + "dvě správně" + RESET)
                .replace("dvou chybách", RED + "dvou chybách" + RESET)
                .replace("končí!" + RED + "končí!" + RESET, "");
    }
}