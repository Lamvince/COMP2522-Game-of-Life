public class World {
    private final int length;
    private final int width;
    private Cell[][] world;

    public World(int length, int width) {
        this.length = length;
        this.width = width;
        world = new Cell[length][width];
    }

    public void chanceToGenerate() {
        int random;
        for (int row = 0; row < width; row++) {
            for (int col = 0; col < length; col++) {
                world[row][col] = new Cell(row, col);
                random = RandomGenerator.nextNumber(99);
                if (random >= 85) {
                    world[row][col].setLifeform(new Herbivore(this, world[row][col]));
                } else if (random >= 65) {
                    world[row][col].setLifeform(new Plant(this, world[row][col]));
                }
            }
        }
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public Cell getCell(int row, int col) {
        if (0 <= row && row < width && 0 <= col && col <= length) {
            return world[row][col];
        } else {
            return null;
        }
    }
}
