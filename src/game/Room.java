package game;

import java.util.ArrayList;

/**
 * Class Room is for creating rooms and their parameters
 * @author vitek
 */

public class Room {
    private String id;
    private String name;
    private String description;
    private boolean locked;
    private ArrayList<String> items = new ArrayList<>();
    private ArrayList<String> neighbours = new ArrayList<>();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Checking rooms neighbours
     * @param id of current room
     * @return is neighbour or not
     * @author vitek
     */

    public boolean neighbour(String id) {
        for (String neighbour : neighbours) {
            if (neighbour.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean isLocked() {
        return locked;
    }

    public void unlock() {
        locked = false;
    }

    public void addItem(String item) {
        items.add(item);
    }
    public void removeItem(String item) {
        items.remove(item);
    }

    public String getCurrentItem(Integer id){
        return items.get(id);
    }

    public ArrayList<String> getItems() {
        return items;
    }

    /**
     * This Method is for writing plan of labirynt with shown path into console
     * @return the plan
     * @author vitek
     */

    public String labyrintPlan(){
        return """
                        [ PLÁNEK BLUDIŠTĚ ]
                                 S
                     _________________________
                 Start * * * * |           |  |
                    |  |_| | * |  _______  |  |
                    |  |   | * | |  _    | |  |
                    |  |  _| * |_| | |   | |  |
                  Z |  | |   * * * | |   | |  |  V
                    |  | |______ * | |___| |  |
                    |  | _ _ _   * |     * * * Cíl
                    |  |       | * |____ * |  |
                    |  |       | * * * * * |  |
                    |__|_______|___________|__|
                                J
                    * = cesta
                """;
    }

    /**
     * This Method is for writing plan of labirynt without path into console
     * @return the plan
     * @author vitek
     */

    public String labyrintPlanWithout(){
        return """
                            [ BLUDIŠTĚ ]
                     _________________________
                               |           |  |
                    |  |_| |   |  _______  |  |
                    |  |   |   | |  _    | |  |
                    |  |  _|   |_| | |   | |  |
                    |  | |         | |   | |  |
                    |  | |______   | |___| |  |
                    |  | _ _ _     |
                    |  |       |   |____   |  |
                    |  |       |           |  |
                    |__|_______|___________|__|
                """;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", locked=" + locked +
                ", items=" + items +
                ", neighbours=" + neighbours + "\n"+
                '}';
    }
}
