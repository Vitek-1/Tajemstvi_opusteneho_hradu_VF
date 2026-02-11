package command;

/**
 * Class Command is for creating commands in the game
 * @author vitek
 */

public abstract class Command {

    protected String prikaz;

    /**
     * Method execute is for doing the exact thing
     * @return some information about the action
     * @author vitek
     */

    public abstract String execute();

    /**
     * Method exit is for ending game
     * @return true or false to end game
     * @author vitek
     */

    public abstract boolean exit();
}