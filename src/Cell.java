import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class Cell extends JPanel {
    private final World world;
    private Lifeform lifeform;
    private int Xcoord;
    private int Ycoord;

    public Cell(int x, int y, World world) {
        Xcoord = x;
        Ycoord = y;
        this.world = world;
    }

    public ArrayList<Cell> checkNeighbour() {
        ArrayList<Cell> neighbours = new ArrayList<>();
        int x, y;
        for (int i = -1; i <= 1; i++) {
            x = Xcoord + i;
            if (0 <= x && x < 25) {
                for (int j = -1; j <= 1; j++) {
                    y = Ycoord + j;
                    if (0 <= y && y < 25) {
                        neighbours.add(world.getCell(x, y));
                    }
                }
            }
        }
        neighbours.remove(this);
        return neighbours;
    }

    public void setLifeform(Lifeform lifeform) {
        this.lifeform = lifeform;
    }

    public Lifeform getLifeform() {
        return lifeform;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(0, 0, getWidth(), getHeight());
        setBackground(Color.white);

        if (lifeform != null) {
            lifeform.draw();
        }
    }
}
