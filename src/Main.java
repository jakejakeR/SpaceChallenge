public class Main {
    public static void main(String[] args) throws Exception {
        Simulation simulation = new Simulation();

        // Checking if loadItems method works
        Item itemFromList = simulation.loadItems("phase-1.txt").get(0);
        System.out.println(itemFromList.name + " " + itemFromList.weight);
    }
}
