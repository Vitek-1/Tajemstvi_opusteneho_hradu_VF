public abstract class Character {

    protected String name;
    protected String description;

    public Character(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract void talk(Player player, Console game);

}