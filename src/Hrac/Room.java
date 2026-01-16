package Hrac;

import Characters.Character;

import java.util.HashMap;

public class Room {
    private String name;
    private String description;

    private HashMap<String, Room> exits;

    private boolean locked;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private void createRooms(){

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

    public void addCharacter(Characters.Character character) {

    }

    public boolean isLocked() {
        return false;
    }

    public void unlock() {

    }
}
