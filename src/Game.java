import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class Game extends JFrame{
    private World world;

    public Game() {
        this.world = new World(25,25);
    }

    public void init() {
        world.chanceToGenerate();

        setLayout(new GridLayout(world.getWidth(), world.getLength()));
        for (int row = 0; row < world.getWidth(); row++) {
            for (int col = 0; col < world.getLength(); col++) {
                add(world.getCell(row, col));
            }
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("CLEEK! CLEEK!");
            }
        });
    }

    public void turn() {
        for (int row = 0; row < world.getWidth(); row++) {
            for (int col = 0; col < world.getLength(); col++) {
                world.getCell(row, col).getLifeform().move();
            }
        }
        repaint();
    }
}
