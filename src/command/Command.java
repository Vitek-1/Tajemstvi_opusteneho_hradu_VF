package command;

public abstract class Command {

    protected String prikaz;

    public abstract String execute();

    public abstract boolean exit();
}