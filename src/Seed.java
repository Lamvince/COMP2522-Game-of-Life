import java.awt.*;
import java.util.ArrayList;

public class Seed extends Lifeform{
    public Seed(Cell cell) {
        super(cell);
        super.setName("Seed");
    }

    public void grow() {
        cell.setLifeform(new Plant(cell));
    }

    public void draw() {
        cell.setBackground(Color.DARK_GRAY);
    }
}
