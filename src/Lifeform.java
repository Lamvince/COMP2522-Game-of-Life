import java.awt.*;

public abstract class Lifeform{
    protected Cell cell;
    private String name;
    protected boolean alive;

    public Lifeform(Cell cell) {
        this.cell = cell;
        alive = true;
    }

    public void move() {}
    public void eat() {}
    public void reproduce() {}
    public void grow() {}

    public void die() {
        cell.setLifeform(null);
    }

    public void draw() {
        cell.setBackground(Color.white);
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return alive;
    }
}
