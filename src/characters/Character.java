package characters;

import game.GameData;
import game.Player;

/**
 * Class Character is for creating characters
 * @author vitek
 */

public abstract class Character {

    public Character() {;
    }

    public abstract void talk(Player player, GameData gamedata);

}