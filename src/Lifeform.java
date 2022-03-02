import java.util.ArrayList;

public abstract class Lifeform{
    private World world;
    protected Cell cell;
    private String name;

    public Lifeform(World world, Cell cell) {
        this.world = world;
        this.cell = cell;
    }

//    public ArrayList<Cell> checkNeighbour(Cell cell) {
//        ArrayList<Cell> neighbours = new ArrayList<Cell>();
//        int x, y;
//        for (int i = -1; i <= 1; i++) {
//            x = cell.getX() + i;
//            if (0 <= x || x < 25) {
//                for (int j = -1; j <= 1; j++) {
//                    y = cell.getY() + j;
//                    if (0 <= y || y < 25) {
//                        neighbours.add(world.getCell(x, y));
//                    }
//                }
//            }
//        }
//        neighbours.remove(world.getCell(cell.getX(), cell.getY()));
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
