package characters;

import game.GameData;
import game.Player;

public abstract class Character {

    protected String name;
    protected String description;

    public Character(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract void talk(Player player, GameData gamedata);

}