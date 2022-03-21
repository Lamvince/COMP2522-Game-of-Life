import java.awt.Color;

public class Carnivore extends Lifeform{
    public static final Color IMAGE = Color.RED;

    public Carnivore(Cell cell) {
        super(cell);
    }

    public void draw() {
        cell.setBackground(IMAGE);
    }
}
