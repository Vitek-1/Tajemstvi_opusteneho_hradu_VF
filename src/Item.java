import java.util.ArrayList;

public class Item {
    private String name;
    private String description;
    private ArrayList<Item> items;


    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
    }

    public void itemCreating(){

    }

    public void use(Player player, Console game){

    }
}