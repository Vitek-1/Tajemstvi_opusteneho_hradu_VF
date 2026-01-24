package characters;

import game.GameData;
import game.Player;

public abstract class Character {

    public Character() {;
    }

    public abstract void talk(Player player, GameData gamedata);

}