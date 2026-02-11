package game;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * \this class is for creating player and for his methods
 * @author vitek
 */

public class Player {
    private String name;
    private Room currentRoom;
    private GameData gameData;
    private ArrayList<String> items;
    private Scanner sc = new Scanner(System.in);

    public Player(String name, Room currentRoom, GameData gameData) {
        this.name = name;
        this.currentRoom = currentRoom;
        this.items = new ArrayList<>();
        this.gameData = gameData;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * This method is for setting players current room
     * @param room needed here for room methods
     * @author vitek
     */

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
        System.out.println(getCurrentRoom().getDescription());
        if (currentRoom.getId().equals("bludiste")) {
            sc.nextLine();
            System.out.print("\nStojíš před vstupem do temného labyrintu. Podle plánku z ložnice víš, že jediná chybná odbočka tě vyvede zpět na nádvoří.\nNepiš nesmysly a zadej sérii směrů (např. sever, jih...), abys našel cestu k cíli\n" + room.labyrintPlanWithout() + "\nOdpoved: ");
            String cesta = sc.nextLine();

            if (cesta.equalsIgnoreCase("vychod, jih, vychod, jih, vychod, sever, vychod")) {
                System.out.println("Úspěšně jsi prošel bludištěm a na jeho konci jsi našel svíčku opatrně jsi jí zvedl a vložil jsi jí do kapsy\n");
                items.add("svicka");
                room.removeItem("svicka");
            } else {
                System.out.println("Bohužel jsis kód zapamatoval špatně vrať se až ho budeš znát.\n");
                currentRoom = gameData.findRoomById("nadvori");
            }
        } else if (currentRoom.getId().equals("loznice")) {
            System.out.println("\nVidíš: \n" + currentRoom.labyrintPlan());
            sc.nextLine();
        }
    }

    public void addItem(String nazev) {
        items.add(nazev);
    }

    /**
     * This method is for room exploring
     * @author vitek
     */

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

    /**
     * Deleting items
     * @param name which item should be deleted
     * @author vitek
     */

    public void removeItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(name)) {
                items.remove(i);
            }
        }
    }

    /**
     * Checking if the player has current item in their inventory
     * @param name of item
     * @return Whether he has it or not
     * @author vitek
     */

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
}
