import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Simulation {
    // Methods
    /**
     * This method loads all items from a text file and returns an ArrayList of Items.
     * Each line in the text file consists of the item name followed by = then its weigh in kg.
     * This method reads the text file line by line and creates an Item object for each,
     * Then adds it to an ArrayList of Items
     * @param fileName name of the file that contains list of items
     * @return ArrayList that consists of Items
     */
    public ArrayList<Item> loadItems(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        ArrayList<Item> listOfItems = new ArrayList<>();

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitter = line.split("=");
            listOfItems.add(new Item(splitter[0], Integer.parseInt(splitter[1])));
        }
        return listOfItems;
    }

    /**
     * Takes the ArrayList of Items returned from loadItems and starts creating U1 rockets.
     * It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object
     * and filling that one until all items are loaded.
     * Then adds it to an ArrayList of Items
     * @param listOfItems returned from loadItems
     * @return the ArrayList of those U1 rockets that are fully loaded.
     */
    public ArrayList<Rocket> loadU1(ArrayList<Item> listOfItems) {
        ArrayList<Rocket> rocketArrayList = new ArrayList<>();
        ArrayList<Item> itemsToBeTaken = new ArrayList<>(listOfItems);
        Rocket rocketU1 = new U1();

        while(!itemsToBeTaken.isEmpty()) {
            for(Item item : listOfItems) {
                if(rocketU1.canCarry(item)) {
                    rocketU1.carry(item);
                    //System.out.println(item.name + " added.");
                    itemsToBeTaken.remove(item);
                }
            }
            // Check if rocket is fully loaded. If yes, add rocket to rocketArrayList
            if(rocketU1.currentWeight == rocketU1.maxWeight) {
                rocketArrayList.add(rocketU1);
            }
            rocketU1 = new U1();
            listOfItems = itemsToBeTaken;
            itemsToBeTaken = new ArrayList<>(listOfItems);
        }
        return rocketArrayList;
    }

    /**
     * Takes the ArrayList of Items returned from loadItems and starts creating U2 rockets.
     * It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object
     * and filling that one until all items are loaded.
     * Then adds it to an ArrayList of Items
     * @param listOfItems returned from loadItems
     * @return the ArrayList of those U1 rockets that are fully loaded.
     */
    public ArrayList<Rocket> loadU2(ArrayList<Item> listOfItems) {
        ArrayList<Rocket> rocketArrayList = new ArrayList<>();
        ArrayList<Item> itemsToBeTaken = new ArrayList<>();
        Rocket rocketU2 = new U2();

        while(!listOfItems.isEmpty()) {
            for(Item item : listOfItems) {
                if(rocketU2.canCarry(item)) {
                    rocketU2.carry(item);
                    //System.out.println(item.name + " added.");
                } else itemsToBeTaken.add(item);
            }
            // Check if rocket is fully loaded. If yes, add rocket to rocketArrayList
            if(rocketU2.currentWeight == rocketU2.maxWeight) {
                rocketArrayList.add(rocketU2);
            }
            rocketU2 = new U2();
            listOfItems = itemsToBeTaken;
            itemsToBeTaken = new ArrayList<>();
        }
        return rocketArrayList;
    }

    /**
     * Takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in the ArrayList.
     * Every time a rocket explodes or crashes it will have to send that rocket again.
     * All while keeping track of the total budget required to send each rocket safely to Mars.
     * @param rocketArrayList that are loaded for each phase
     * @return total budget in millions of $
     */
    public int totalBudget(ArrayList<Rocket> rocketArrayList) {
        int totalBudget=0;

        for(Rocket rocket : rocketArrayList) {
            do {
                totalBudget += rocket.cost;
            } while(!(rocket.launch() && rocket.land()));
        }
        return totalBudget;
    }
}
