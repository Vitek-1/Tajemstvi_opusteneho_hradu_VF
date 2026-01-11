public abstract class Character {

    protected String name;
    protected String description;

    public abstract String getName();
    public abstract void talk(Player player, Console game);

}