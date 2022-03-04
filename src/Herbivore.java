import java.awt.Color;
import java.util.ArrayList;

public class Herbivore extends Lifeform{
    public static final Color IMAGE = Color.YELLOW;
    private int hunger;

    public Herbivore(Cell cell) {
        super(cell);
        super.setName("Herbivore");
        hunger = 0;
    }

    public void move() {
        ArrayList<Cell> neighbours = cell.checkNeighbour();
        Cell potentialDestination = null;
        boolean moved = false;
        boolean eaten = false;
        int random;
        int occupied = 0;

        for (Cell cellNeighbour : neighbours) {
            if (cellNeighbour.getLifeform() != null
                    && (cellNeighbour.getLifeform().getName().equals("Herbivore")
                    || (cellNeighbour.getLifeform().getName().equals("Seed")))){
                occupied++;
            }
        }

        if (occupied < neighbours.size()) {
            while (!moved && !eaten) {
                random = RandomGenerator.nextNumber(neighbours.size() - 1);
                potentialDestination = neighbours.get(random);
                if (potentialDestination.getLifeform() == null) {
                    moved = true;
                } else if (potentialDestination.getLifeform().getName().equals("Plant")) {
                    eaten = true;
                }
            }
            if (moved) {
                cell.setLifeform(null);
                potentialDestination.setLifeform(this);
                setCell(potentialDestination);
                hunger++;
            } else if (eaten) {
                cell.setLifeform(null);
                potentialDestination.setLifeform(this);
                setCell(potentialDestination);
                eat();
            }
        }
    }

    public void eat() {
        hunger = 0;
    }

    public void die() {
        cell.setLifeform(null);
    }

    public void draw() {
        cell.setBackground(IMAGE);
    }

    @Override
    public boolean isAlive() {
        if (hunger >= 5) {
            die();
            super.alive = false;
        }
        return alive;
    }
}
