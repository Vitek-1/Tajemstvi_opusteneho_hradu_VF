package command;

import java.util.HashMap;

/**
 * This class Help is for writing all commands into console for player
 * @author vitek
 */

public class Help extends Command {
    private HashMap<String, Command> mapa;

    public Help(HashMap<String, Command> mapa) {
        this.mapa = mapa;
    }

    /**
     * Just writing the commands into console
     * @return all commands
     * @author vitek
     */

    @Override
    public String execute() {
        return "Dostupné příkazy: " + mapa.keySet();
    }

    /**
     * This method is here for checking end game
     * @return false
     * @author vitek
     */

    @Override
    public boolean exit() {
        return false;
    }
}
