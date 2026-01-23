package game;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private Room currentRoom;
    private ArrayList<String> items;
    private boolean alive;
    private Scanner sc = new Scanner(System.in);

    public Player(Room currentRoom, boolean alive) {
        this.currentRoom = currentRoom;
        this.alive = alive;
        this.items = new ArrayList<>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public void roomExplore() {
        int exit = 1;
        do {
            boolean keca = true;
            String item;
            do {
                System.out.print("V místnosti se nachází tyto itemy: " + getCurrentRoom().getItems().toString() +
                        "\nChceš nějaký vzít (pokud nechceš stiskni 0): ");
                item = sc.next();

                if (item.equals("0")) {
                    exit = 0;
                    break;
                } else {
                    for (int i = 0; i < getCurrentRoom().getItems().size(); i++) {
                        if (item.equals(getCurrentRoom().getItems().get(i))) {
                            keca = false;
                            break;
                        }
                    }
                }
            } while (keca);
            if (exit == 1) {
                keca = true;
                if (items.size() < 2) {
                    items.add(item);
                    getCurrentRoom().removeItem(item);
                    System.out.println("Inventář: " + showInventory() + "\n");
                } else {
                    do {
                        System.out.println("\nMáš plný inventář musíš něco vyhodit pokud ho chceš vzít." +
                                "\nCo to bude: \n1) " + items.get(0) + "\n2) " + items.get(1) + "\n3) nic");
                        int vyhozeno = sc.nextInt();

                        if (vyhozeno == 1 || vyhozeno == 2) {
                            getCurrentRoom().addItem(items.get(vyhozeno - 1));
                            items.remove(vyhozeno - 1);
                            items.add(item);
                            keca = false;
                        } else if (vyhozeno == 3) {
                            keca = false;
                        }
                    } while (keca);
                }
            }
        } while (exit == 1 && !getCurrentRoom().getItems().isEmpty());
    }

    public void removeItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(name)) {
                items.remove(i);
            }
        }
    }

    public boolean contains(String name) {
        for (String item : items) {
            if (item.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public String showInventory() {
        return items.toString();
    }

    public boolean isAlive() {
        return alive;
    }

    public void die() {
    }

}
