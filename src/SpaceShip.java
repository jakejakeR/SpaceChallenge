public interface SpaceShip {
    // Methods' definitions
    boolean launch(); // returns either true or false based on the success of the launching.
    boolean land(); // returns either true or false based on the success of the landing.
    boolean canCarry(Item item); // returns true if the rocket can carry such item.
    int carry(Item item); // updates the current weight of the rocket.
}
