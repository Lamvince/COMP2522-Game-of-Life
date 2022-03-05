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
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < length; y++) {
                world[x][y] = new Cell(x, y, this);
                random = RandomGenerator.nextNumber(100);
                if (random >= 85) {
                    world[x][y].setLifeform(new Herbivore(world[x][y]));
                } else if (random >= 65) {
                    world[x][y].setLifeform(new Plant( world[x][y]));
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

    public Cell getCell(int x, int y) {
            return world[x][y];
    }
}
