import java.awt.Color;
import java.util.ArrayList;

public class Herbivore extends Lifeform implements CarnEdible, OmniEdible{
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
            if (cellNeighbour.getLifeform() != null && !(cellNeighbour.getLifeform() instanceof HerbEdible)){
                occupied++;
            }
        }

        if (occupied < neighbours.size()) {
            while (!moved && !eaten) {
                random = RandomGenerator.nextNumber(neighbours.size());
                potentialDestination = neighbours.get(random);
                if (potentialDestination.getLifeform() == null) {
                    moved = true;
                } else if (potentialDestination.getLifeform() instanceof HerbEdible) {
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
                potentialDestination.getLifeform().die();
                potentialDestination.setLifeform(this);
                setCell(potentialDestination);
                eat();
            }
        }
    }

    public void reproduce() {
        ArrayList<Cell> neighbours = cell.checkNeighbour();
        boolean seeded = false;
        int random;
        int emptyNeighbour = 0;
        int foodNeighbour = 0;
        int mateNeighbour = 0;
        for (Cell cellNeighbour : neighbours) {
            if(cellNeighbour.getLifeform() == null) {
                emptyNeighbour++;
            } else if (cellNeighbour.getLifeform() instanceof HerbEdible) {
                foodNeighbour++;
            } else if (cellNeighbour.getLifeform().getName().equals("Herbivore")) {
                mateNeighbour++;
            }
        }

        if (mateNeighbour >= 1 && foodNeighbour >= 2 && emptyNeighbour >= 2) {
            while (!seeded) {
                random = RandomGenerator.nextNumber(neighbours.size());
                if (neighbours.get(random).getLifeform() == null) {
                    neighbours.get(random).setLifeform(new Herbivore(neighbours.get(random)));
                    seeded = true;
                }
            }
        }
    }

    public void eat() {
        hunger = 0;
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
