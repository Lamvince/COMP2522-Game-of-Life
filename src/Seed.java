import java.awt.*;

public class Seed extends Plant{
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
