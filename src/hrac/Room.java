package hrac;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
        ObjectMapper mapper = new ObjectMapper();
         try{
             InputStream input = new FileInputStream("resources/rooms.json");
             Character character = mapper.readValue(input, Character.class);
             System.out.println(character);
         } catch (FileNotFoundException e) {
             throw new RuntimeException(e);
         } catch (Exception e) {
             throw new RuntimeException(e);
         }
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
