import java.awt.Color;

public class Herbivore extends Lifeform{
    public static final Color IMAGE = Color.YELLOW;

    public Herbivore(World world, Cell cell) {
        super(world, cell);
        super.setName("Herbivore");
    }

//    public Cell checkNeighbour() {
//        return super.checkNeighbour();
//    }

    public void move() {

    }

    public void eat() {

    }

    public void die() {

    }

    public void draw() {
        cell.setBackground(IMAGE);
    }
}
