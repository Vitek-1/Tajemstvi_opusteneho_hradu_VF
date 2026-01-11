public abstract class Item {
    protected String name;
    protected String description;

    public abstract String getName();
    public abstract String getDescription();

    public abstract void use(Player player, Console game);
}
