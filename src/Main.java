public class Main {
    public static void main(String[] args) throws Exception {
        Simulation simulation = new Simulation();
        //System.out.println(simulation.loadU1(simulation.loadItems("phase-1.txt")).size());
        System.out.println(simulation.loadU2(simulation.loadItems("phase-1.txt")).size());
    }
}
