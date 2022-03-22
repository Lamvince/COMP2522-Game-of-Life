—Added—
Created Omnivore and Carnivore classes.
Added CarnEdible and OmniEdible and implemented them into the correct lifeform type

—Modified for A2b specifications—
Added reproduce() to Herbivore
Modified Plant rate of reproduction to match A2b description.

—Modified for Design Purposes—
In A2a, Herbivore move() was hard coded to look out for Plant or Seed only. Now Herbivore looks for all Lifeforms with the help of HerbEdible interface.

Removed die() from children of Lifeform. Not necessary to override when Lifeform abstract has a functioning die method.

Added “alive = false” to die() to prevent eaten lifeforms from moving/eating within a turn. Wasn’t needed in A2a since Herbivore was the only moving lifeform but needed in A2b to handle movement/eating for herbivore, carnivore and omnivore.