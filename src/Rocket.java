public class Rocket implements SpaceShip {
    // Fields
    int cost;
    int weight;
    int maxWeight;
    int currentWeight;
    double launchExplosion;
    double landingCrash;

    // Methods
    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public final boolean canCarry(Item item) {
        return (this.maxWeight - this.currentWeight) >= item.weight;
    }

    public final int carry(Item item) {
        this.currentWeight += item.weight;
        return this.currentWeight;
    }
}
