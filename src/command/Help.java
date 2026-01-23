package command;

import java.util.HashMap;

public class Help extends Command {
    private HashMap<String, Command> mapa;

    public Help(HashMap<String, Command> mapa) {
        this.mapa = mapa;
    }

    @Override
    public String execute() {
        return "Dostupné příkazy: " + mapa.keySet();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
