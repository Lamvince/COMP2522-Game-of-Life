--Main--
Additions:
    main(argv:String[])
    centreOnScreen(size:Dimension)
    c alculateScreenArea(widthPercent:float, heightPercent:float)
Methods provided by instructor to run program and create window for GUI

Removals:
    turn()
Only needed on Game class

exit()
Functionality already included in main()


--Game--
Additions:
    init()
Added to create GUI grid and call chanceToGenerate(). Originally wanted to put functionality in constructor, but made more sense for init() to be its own method

World
Additions:
    getLength()
    getWidth()
    getCell(x:int, y:int)
Getters added to access private data members. For encapsulation


--Cell--
Additions:
    World: World
Added so that Cell can access other cells through world for checkNeighbour() method

    checkNeighbour()
Moved from Lifeform class. checkNeighbour() based on location of Lifeform, not Lifeform itself. Made more sense to access other Cells from Cell class

    paintComponent(g:Graphics)
Needed to make each grid cell in GUI

Changes:
    occupied:Lifeform renamed to lifeform:Lifeform
More appropriate naming convention


--Lifeform--
Additions:
    cell:Cell
Added so Lifeforms can move and reproduce. Lifeforms can interact with each other based on which Cell they are in.

    alive:Boolean
Way to know if the Lifeform is still alive. Useful for checking during Game.turn()

    reproduce()
Added so that all lifeforms have a way to reproduce.

    grow()
Used by Seed class to grow into Plant class. Added so that all lifeforms have a way to reproduce.

    setCell(cell:Cell)
    setName(name:String)
    getName() : String
    isAlive() : Boolean
Setters and getters to access and modify private data values. For encapsulation

Removals:
    checkNeighbour()
Moved from Lifeform class. checkNeighbour() based on location of Lifeform, not Lifeform itself. Made more sense to access other Cells from Cell class


--Herbivore--
Additions:
    move()
Added to herbivore so that Herbivore could move without relying on parent Lifeform for functionality. Each Lifeform child that moves should have it’s own move instead of relying on parent, to prevent Plant and Seed from moving accidentally

    isAlive()
Overrides Lifeform Alive getter that takes into account Herbivore’s hunger

Removals:
    checkNeighbour()
Moved from Lifeform class. checkNeighbour() based on location of Lifeform, not Lifeform itself. Made more sense to access other Cells from Cell class


--Plant--
Changes:
    seed() renamed to reproduce()
Change to naming convention to make Lifeforms more consistent


Seed - Class added so that a plant creates seeds, then herbivore moves, then seeds grow to become new plants. Seeds are similar to plants, but have their own functionality, thus Seed is its own class

    grow() - turns this Seed into a new Plant
    draw() - sets background colour (for testing purposes)


HerbEdible - removed methods in HerbEdible, not required for this iteration


RandomNumberGenerator - connects to Herbivores and Plant. Herbivore and Plant need random number for random move()