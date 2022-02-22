import java.awt.*;

public abstract class Lifeform{
    private World world;
    protected Cell cell;
    private String name;

    public Lifeform(World world, Cell cell) {
        this.world = world;
        this.cell = cell;
    }

    public Cell checkNeighbour() {
        boolean okayToMove = false;
        Cell destination = null;
        int random = RandomGenerator.nextNumber(7);

        while (!okayToMove) {
            switch (random) {
                case 0:
                    destination = world.getCell(cell.Xcoord - 1, cell.Ycoord - 1);
                    break;
                case 1:
                    destination = world.getCell(cell.Xcoord, cell.Ycoord - 1);
                    break;
                case 2:
                    destination = world.getCell(cell.Xcoord + 1, cell.Ycoord - 1);
                    break;
                case 3:
                    destination = world.getCell(cell.Xcoord - 1, cell.Ycoord);
                    break;
                case 4:
                    destination = world.getCell(cell.Xcoord + 1, cell.Ycoord);
                    break;
                case 5:
                    destination = world.getCell(cell.Xcoord - 1, cell.Ycoord + 1);
                    break;
                case 6:
                    destination = world.getCell(cell.Xcoord, cell.Ycoord + 1);
                    break;
                case 7:
                    destination = world.getCell(cell.Xcoord + 1, cell.Ycoord + 1);
                    break;
                default:
                    destination = cell;
            }
            if (!destination.getLifeform().getName().equals("Herbivore")) {
                okayToMove = true;
            }
        }
        return destination;
    }

    public void move() {
        Cell destination = checkNeighbour();
        destination = cell;
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
