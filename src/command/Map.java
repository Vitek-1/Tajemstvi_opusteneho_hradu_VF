package command;

public class Map extends Command{
    @Override
    public String execute() {
            return """
              +------------+     +---------+      / \\
                 | Hradní síň |     | Ložnice |     | V |
                 +-----+------+     +----+----+     | ě |
                       |                 |          | ž |
       +----------+  +-+----------+------+------+   +---+
       | Labyrint +--+         NÁDVOŘÍ          +--< BRÁNA
       +----------+  +-+-----------------+------+
                       |                 |
                 +-----+------+    +-----+-----+
                 |  Knihovna  +    |   Sklep   |
                 +-----+------+    +-----------+
                       |
                +------+-------+
                | Tajná místn. |
                +--------------+
       """;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
