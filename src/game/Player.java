package game;

import command.Inventar;
import game.GameData;

public class Player {
    private Room currentRoom;
    private GameData gameData;
    private Inventar inventar;
    private boolean alive;

    public Player(Room currentRoom, Inventar inventar, boolean alive) {
        this.currentRoom = currentRoom;
        this.inventar = inventar;
        this.alive = alive;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public Inventar getInventory() {
        return inventar;
    }

    public boolean isAlive() {
        return alive;
    }

    public void die() {
    }

}
