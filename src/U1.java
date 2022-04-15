public class U1 extends Rocket {
    // Constructor
    public U1() {
        cost = 100;
        weight = 10000;
        maxWeight = 18000; // Max weight with cargo
        currentWeight = weight;
        launchExplosionChance = 0;
        landCrashChance = 0;
    }

    // Methods
    public boolean launch() {
        this.launchExplosionChance = 5.0 * ((double)(this.currentWeight-this.weight) / (double)(this.maxWeight-this.weight));
        // System.out.println("Launch explosion chance: " + this.launchExplosionChance);
        int randomNumber = (int)(Math.random()*100+1);
        // System.out.println("Random number: " + randomNumber);
        return randomNumber > this.launchExplosionChance;
    }

    public boolean land() {
        this.landCrashChance = (double)(this.currentWeight - this.weight) / (double)(this.maxWeight - this.weight);
        int randomNumber = (int)(Math.random()*100+1);
        return randomNumber > this.landCrashChance;
    }
}
