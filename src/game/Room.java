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
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isLocked() {
        return locked;
    }

    public void unlock() {

    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", locked=" + locked +
                ", items=" + items +
                ", neighbours=" + neighbours +
                '}';
    }
}
