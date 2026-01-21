package game;

import com.google.gson.Gson;
import com.sun.tools.javac.Main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Represents the game data loaded from a JSON file.
 * This class serves as a data container for all static game content,
 * specifically the rooms and starting room of the game world.
 */
public class GameData {

    // Seznam všech místností herního světa
    public ArrayList<Room> rooms;

    /**
     * Loads game data from a JSON file located in the resources folder.
     *
     * @param resourcePath path to the resource file
     * @return a GameData object filled with the loaded data
     */
    public static GameData loadGameDataFromResources(String resourcePath) {

        // Vytvoření objektu pro práci s JSON souborem
        Gson gson = new Gson();

        // Načtení souboru z resources (musí být označeno jako resource složka)
        try (InputStream is = Main.class.getResourceAsStream(resourcePath)) {

            // Ověření, zda soubor existuje
            if (is == null) {
                throw new IllegalStateException(
                        "Nenalezen resource: " + resourcePath +
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
}
