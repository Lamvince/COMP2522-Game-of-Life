import java.awt.Color;

public class Omnivore extends Lifeform{
    public static final Color IMAGE = Color.BLUE;

    public Omnivore(Cell cell) {
        super(cell);
    }

    public void draw() {
        cell.setBackground(IMAGE);
    }
}
