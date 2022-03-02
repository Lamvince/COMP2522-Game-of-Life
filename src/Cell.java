import javax.swing.JPanel;
import java.awt.Graphics;

public class Cell extends JPanel {
    Lifeform lifeform;
    private int Xcoord;
    private int Ycoord;

    public Cell(int x, int y) {
        Xcoord = x;
        Ycoord = y;
    }

    public void setLifeform(Lifeform lifeform) {
        this.lifeform = lifeform;
    }

    public Lifeform getLifeform() {
        return lifeform;
    }

    public int getX() {
        return Xcoord;
    }

    public int getY() {
        return Ycoord;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(0, 0, getWidth(), getHeight());
        if (lifeform != null) {
            lifeform.draw();
        }
    }
}
