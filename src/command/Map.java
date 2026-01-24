package command;

public class Map extends Command{
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

    @Override
    public boolean exit() {
        return false;
    }
}
