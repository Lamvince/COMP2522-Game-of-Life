import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class Game extends JFrame implements MouseListener {
    World world;

    public Game() {
        this.world = new World(25,25);
    }

    public void init() {
        world.chanceToGenerate();

        setLayout(new GridLayout(world.getWidth(), world.getLength()));
        for (int row = 0; row < world.getWidth(); row++) {
            for (int col = 0; col < world.getLength(); col++) {
                JPanel square = world.getCell(row, col);
                square.setBorder(new LineBorder(Color.BLACK, 0));
                add(square);
            }
        }

        addMouseListener(this);
    }

    public void turn() {
        for (int row = 0; row < world.getWidth(); row++) {
            for (int col = 0; col < world.getLength(); col++) {
                world.getCell(row, col).getLifeform().move();
            }
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        turn();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
