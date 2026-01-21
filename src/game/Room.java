package game;

import java.util.ArrayList;

public class Room {
    private String id;
    private String name;
    private String description;
    private boolean locked;
    private ArrayList<String> items;
    private ArrayList<String> neighbours;

    public String getId() {
        return id;
    }

    public String getName() {
        return null;
    }

    public String getDescription() {
        return null;
    }

    public void addExit(String name, Room room) {}

    public Room getExit(String name) {
        return null;
    }

    public void addItem(Item item) {}

    public void addCharacter(characters.Character character) {

    }

    public boolean isLocked() {
        return false;
    }

    public void unlock() {

    }
}
