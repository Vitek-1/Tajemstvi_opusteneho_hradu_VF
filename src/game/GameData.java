package game;

import com.google.gson.Gson;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Represents the game data loaded from a JSON file.
 * This class serves as a data container for all static game content,
 * specifically the rooms and starting room of the game world.
 * @author Maitnerova
 */
public class GameData {

    // Seznam všech místností herního světa
    public ArrayList<Room> rooms;
    public static final String WINE = "\u001B[1m";
    public static final String RESET = "\u001B[0m";

    /**
     * Loads game data from a JSON file located in the resources folder.
     *
     * @param resourcePath path to the resource file
     * @return a GameData object filled with the loaded data
     * @author Maitnerova
     */
    public static GameData loadGameDataFromResources(String resourcePath) {

        // Vytvoření objektu pro práci s JSON souborem
        Gson gson = new Gson();

        // Načtení souboru z resources (musí být označeno jako resource složka)
        try (InputStream is = Main.class.getResourceAsStream(resourcePath)) {

            // Ověření, zda soubor existuje
            if (is == null) {
                throw new IllegalStateException("Nenalezen resource: " + resourcePath +
                                " (zkontrolujte, že soubor je ve složce resources)."
                );
            }

            // Přečtení celého JSON souboru a vytvoření instance GameData
            return gson.fromJson(
                    new InputStreamReader(is, StandardCharsets.UTF_8),
                    GameData.class
            );

        } catch (Exception e) {
            // Zachycení chyby při načítání nebo parsování JSONu
            throw new RuntimeException(
                    "Chyba při načítání JSON: " + e.getMessage()
            );
        }

    }

    /**
     * Finds a specific room by its identifier.
     *
     * @param id the identifier of the room to be found
     * @return the matching room
     * @author Maitnerova
     */
    public Room findRoomById(String id) {
        // Procházení seznamu místností
        for (Room room : rooms) {
            if (room.getId().equals(id)) {
                return room;
            }
        }

        // Pokud místnost s daným ID neexistuje
        throw new IllegalArgumentException(
                "Neexistuje místnost s id: " + id
        );
    }

    /**
     * This method is for writing info to player
     * @return gemeral informations about game
     * @author vitek
     */

    public String intro(){
        System.out.println("--------------- " + WINE + "TAJEMSTVÍ OPUŠTĚNÉHO HRADU" + RESET + "---------------");
        return """
                Vítej ve hře, nacházíš se v ložnici na dávno opuštěném hradě.
                Tvým úkolem je utéct ze zámku hlavní branou za pomocí zlatého klíče.
                Pro zobrazení všech příkazů použij komand: 'pomoc' ale nejprve stiskni Enter
                
                
                           |>>>                      |>>>
                           |                         |
                       _  _|_  _                 _  _|_  _
                      | |_| |_| |               | |_| |_| |
                      \\         /               \\         /
                       |       |                 |       |
                       |   _   |_________________|   _   |
                       |  |_|  |                 |  |_|  |
                       |       |    _________    |       |
                       |       |   /         \\   |       |
                       |       |  /           \\  |       |
                       |_______| |      _      | |_______|
                       |         |     | |     |         |
                       |         |     |_|     |         |
                       |_________|_____________|_________|
                
                                  Hodně štěstí.
                """;
    }
}
