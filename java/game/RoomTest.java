package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    Room room;

    @org.junit.jupiter.api.BeforeEach
    void init() {
        room = new Room();
    }

    @Test
    void getItems() {
        room.addItem("prsten");
        assertFalse(room.getItems().isEmpty());
    }

    @Test
    void labyrintPlan() {
        assertFalse(room.labyrintPlan().isEmpty());
    }

    @Test
    void labyrintPlanWithout() {
        assertFalse(room.labyrintPlanWithout().isEmpty());
    }
}