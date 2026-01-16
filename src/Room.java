import Characters.Character;

import java.util.HashMap;

public class Room {
    private String name;
    private String description;

    private HashMap<String, Room> exits;
    private HashMap<String, Item> items;
    private HashMap<String, Characters.Character> characters;

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

    public void addExit(String name, Room room) {

    }

    public Room getExit(String name) {
        return null;
    }

    public void addItem(Item item) {

    }

    public Item getItem(String name) {
        return null;
    }

    public void removeItem(String name) {

    }

    public void addCharacter(Characters.Character character) {

    }

    public Character getCharacter(String name) {
        return null;
    }

    public boolean isLocked() {
        return false;
    }

    public void unlock() {

    }
}
