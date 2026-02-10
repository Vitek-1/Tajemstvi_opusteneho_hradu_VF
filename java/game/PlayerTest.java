package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player;
    GameData  gameData;
    Room room;

    @org.junit.jupiter.api.BeforeEach
    void init() {
        player = new Player("Kryštof", room, gameData);
    }

    @Test
    void addItem() {
        player.addItem("mec");
        assertFalse(player.showInventory().isEmpty());
    }

    @Test
    void contains() {
        player.addItem("mec");
        assertTrue(player.contains("mec"));
    }

    @Test
    void showInventory() {
        player.addItem("zlaty_klic");
        assertFalse(player.showInventory().isEmpty());
    }
}