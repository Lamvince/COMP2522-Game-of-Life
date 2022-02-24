public class World {
    public int length;
    public int width;
    private Cell[] world;

    public World(int length, int width) {
        this.length = length;
        this.width = width;
        world = new Cell[length*width];
    }

    public void chanceToGenerate() {
        int index = 0;
        int random;

        for (int row = 0; row < width; row++) {
            for (int col = 0; col < length; col++) {
                world[index] = new Cell(row, col);
                random = RandomGenerator.nextNumber(99);
                if (random >= 85) {
                    world[index].setLifeform(new Herbivore(this, world[index]));
                } else if (random >= 65) {
                    world[index].setLifeform(new Plant(this, world[index]));
                }
                index++;
            }
        }
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public Cell getCell(int x, int y) {
        for (Cell worldCell : world) {
            if (worldCell.Xcoord == x && worldCell.Ycoord == y) {
                return worldCell;
            }
        }
        return null;
    }
}