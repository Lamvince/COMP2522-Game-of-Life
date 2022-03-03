import java.awt.Color;
import java.util.ArrayList;

public class Plant extends Lifeform{
    public static final Color IMAGE = Color.GREEN;

    public Plant(Cell cell) {
        super(cell);
        super.setName("Plant");
    }

    public void reproduce() {
        ArrayList<Cell> neighbours = cell.checkNeighbour();
        boolean seeded = false;
        int random;
        int emptyNeighbour = 0;
        int plantNeighbour = 0;
        for (Cell cellNeighbour : neighbours) {
            if(cellNeighbour.getLifeform() == null) {
                emptyNeighbour++;
            } else if (cellNeighbour.getLifeform().getName().equals("Plant")) {
                plantNeighbour++;
            }
        }

        if (plantNeighbour == 4 && emptyNeighbour >= 3) {
            while (!seeded) {
                random = RandomGenerator.nextNumber(neighbours.size() - 1);
                if (neighbours.get(random).getLifeform() == null) {
                    neighbours.get(random).setLifeform(new Seed(neighbours.get(random)));
                    seeded = true;
                }
            }
        }
    }

    public void die() {

    }

    public void draw() {
        cell.setBackground(IMAGE);
    }
}
