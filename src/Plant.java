import java.awt.Color;

public class Plant extends Lifeform{
    public static final Color IMAGE = Color.GREEN;

    public Plant(World world, Cell cell) {
        super(world, cell);
        super.setName("Plant");
    }

    public Cell checkNeighbour() {
        return super.checkNeighbour();
    }

    public void seed() {

    }

    public void die() {

    }

    public void draw() {
        cell.setBackground(IMAGE);
    }
}
