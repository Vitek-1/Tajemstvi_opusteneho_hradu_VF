package Command;

import Hrac.Item;

import java.util.HashMap;

public class Inventar extends Command {

    private HashMap<Integer, Item> items;

    public void addItem(Item item) {}

    public void removeItem(String name) {}

    public Item getItem(String name) {
        return null;
    }

    public boolean contains(String name) {
        return false;
    }

    public void showInventory() {

    }

    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}