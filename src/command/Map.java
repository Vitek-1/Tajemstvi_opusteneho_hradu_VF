package command;

/**
 * Class Map is for showing the entire map of the game
 * @author vitek
 */

public class Map extends Command{

    /**
     * This method is for writing the map into console
     * @return the map
     * @author vitek
     */
    @Override
    public String execute() {
            return """
              +------------+     +---------+      / \\
                 |  hrad_sin  |     | loznice |     | v |
                 +-----+------+     +----+----+     | e |
                       |                 |          | z |
       +----------+  +-+----------+------+------+   +---+
       | bludiste +--+         nadvori          +--< BRÁNA
       +----------+  +-+-----------------+------+
                       |                 |
                 +-----+------+    +-----+-----+
                 |  knihovna  +    |   sklep   |
                 +-----+------+    +-----------+
                       |
                +------+-------+
                |  tajna_mist. |
                +--------------+
       """;
    }


    /**
     * This method is here for checking end game
     * @return false
     * @author vitek
     */

    @Override
    public boolean exit() {
        return false;
    }
}
