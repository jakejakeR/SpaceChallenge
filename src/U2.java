public class U2 extends Rocket {
    // Constructor
    public U2() {
        cost = 120;
        weight = 18000;
        maxWeight = 29000; // Max weight with cargo
        currentWeight = weight;
        launchExplosionChance = 0;
        landCrashChance = 0;
    }

    // Methods
    public boolean launch() {
        this.launchExplosionChance = 4.0 * ((double)(this.currentWeight-this.weight) / (double)(this.maxWeight-this.weight));
        int randomNumber = (int)(Math.random()*100+1);
        return randomNumber > this.launchExplosionChance;
    }

    public boolean land() {
        this.landCrashChance = 8.0 * ((double)(this.currentWeight - this.weight) / (double)(this.maxWeight - this.weight));
        int randomNumber = (int)(Math.random()*100+1);
        return randomNumber > this.landCrashChance;
    }
}

