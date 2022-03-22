import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Game extends JFrame{
    World world;

    public Game() {
        this.world = new World(25,25);
    }

    public void init() {
        world.chanceToGenerate();

        setLayout(new GridLayout(world.getLength(), world.getWidth()));
        for (int row = 0; row < world.getLength(); row++) {
            for (int col = 0; col < world.getWidth(); col++) {
                add(world.getCell(row, col));
            }
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                turn();
                repaint();
            }
        });
    }

    public void turn() {
        int numPlants = 0;
        int numHerbs = 0;
        int numCarns = 0;
        int numOmnis = 0;
        ArrayList<Lifeform> allLife = new ArrayList<>();

        // populate world
        for (int row = 0; row < world.getLength(); row++) {
            for (int col = 0; col < world.getWidth(); col++) {
                if (world.getCell(row, col).getLifeform() != null) {
                    allLife.add(world.getCell(row, col).getLifeform());
                }
            }
        }

        // all reproduce
        for (Lifeform life : allLife) {
            if (life.isAlive()) {
                life.reproduce();
            }
        }

        // reset, populate world
        allLife.removeAll(allLife);
        for (int row = 0; row < world.getLength(); row++) {
            for (int col = 0; col < world.getWidth(); col++) {
                if (world.getCell(row, col).getLifeform() != null) {
                    allLife.add(world.getCell(row, col).getLifeform());
                }
            }
        }

        // all move
        for (Lifeform life : allLife) {
            if (life.isAlive()) {
                life.move();
            }
        }

        // reset, populate world
        allLife.removeAll(allLife);
        for (int row = 0; row < world.getLength(); row++) {
            for (int col = 0; col < world.getWidth(); col++) {
                if (world.getCell(row, col).getLifeform() != null) {
                    allLife.add(world.getCell(row, col).getLifeform());
                }
            }
        }

        // all grow
        for (Lifeform life : allLife) {
            if (life.isAlive()) {
                life.grow();
            }
        }

        // for printing to console
        for (int row = 0; row < world.getLength(); row++) {
            for (int col = 0; col < world.getWidth(); col++) {
                if (world.getCell(row, col).getLifeform() != null) {
                    if (world.getCell(row, col).getLifeform().getName().equals("Plant")) {
                        numPlants++;
                    } else if (world.getCell(row, col).getLifeform().getName().equals("Herbivore")) {
                        numHerbs++;
                    } else if (world.getCell(row, col).getLifeform().getName().equals("Carnivore")) {
                        numCarns++;
                    } else if (world.getCell(row, col).getLifeform().getName().equals("Omnivore")) {
                        numOmnis++;
                    }
                }
            }
        }
        System.out.println("Herbs: " + numHerbs + ", Plants: " + numPlants + ", Carns: " + numCarns + ", Omnis: " + numOmnis);
    }
}
