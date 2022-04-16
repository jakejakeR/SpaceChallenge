import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Simulation simulation = new Simulation();
        // U1 simulation
        // Loading items for Phase 1 and Phase 2
        ArrayList<Item> itemsPhase1 = new ArrayList<>(simulation.loadItems("phase-1.txt"));
        ArrayList<Item> itemsPhase2 = new ArrayList<>(simulation.loadItems("phase-2.txt"));
        //Loading a fleet of U1 rockets for Phase 1 and then for Phase 2
        ArrayList<Rocket> u1RocketsP1 = new ArrayList<>(simulation.loadU1(itemsPhase1));
        ArrayList<Rocket> u1RocketsP2 = new ArrayList<>(simulation.loadU1(itemsPhase2));
        System.out.println("U1 Rockets (fully loaded!) for Phase 1: " + u1RocketsP1.size());
        System.out.println("U1 Rockets (fully loaded!) for Phase 2: " + u1RocketsP2.size());
        // Running simulation and displaying total budget required
        int totalBudgetForU1 = simulation.totalBudget(u1RocketsP1) + simulation.totalBudget(u1RocketsP2);
        System.out.println("Total cost of U1 rockets for Phase 1 and 2: $" + totalBudgetForU1 + " million.");

        // U2 simulation
        //Loading a fleet of U1 rockets for Phase 1 and then for Phase 2
        ArrayList<Rocket> u2RocketsP1 = new ArrayList<>(simulation.loadU2(itemsPhase1));
        ArrayList<Rocket> u2RocketsP2 = new ArrayList<>(simulation.loadU2(itemsPhase2));
        System.out.println("U2 Rockets (fully loaded!) for Phase 1: " + u2RocketsP1.size());
        System.out.println("U2 Rockets (fully loaded!) for Phase 2: " + u2RocketsP2.size());
        // Running simulation and displaying total budget required
        int totalBudgetForU2 = simulation.totalBudget(u2RocketsP1) + simulation.totalBudget(u2RocketsP2);
        System.out.println("Total cost of U2 rockets for Phase 1 and 2: $" + totalBudgetForU2 + " million.");

        if(totalBudgetForU1 > totalBudgetForU2) System.out.println("Using U2 rockets is cheaper.");
        else System.out.println("Using U1 rockets is cheaper.");
    }
}
