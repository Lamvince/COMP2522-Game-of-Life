import java.awt.*;

public abstract class Lifeform{
    private World world;
    protected Cell cell;
    private String name;

    public Lifeform(World world, Cell cell) {
        this.world = world;
        this.cell = cell;
    }

//    public Cell[] checkNeighbour() {
//        Cell[] neighbours;
//        return neighbours;
//    }

    public void move() {

    }

    public void eat() {

    }

    public void die() {

    }

    public void draw() {}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
