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

    public ArrayList<Rocket> loadU1(ArrayList<Item> listOfItems) {
        ArrayList<Rocket> rocketArrayList = new ArrayList<>();
        ArrayList<Item> itemsToBeTaken = new ArrayList<>(listOfItems);
        Rocket rocketU1 = new U1();

        while(!itemsToBeTaken.isEmpty()) {
            for(Item item : listOfItems) {
                if(rocketU1.canCarry(item)) {
                    rocketU1.carry(item);
                    System.out.println(item.name + " added.");
                    itemsToBeTaken.remove(item);
                }
            }
            rocketArrayList.add(rocketU1);
            rocketU1 = new U1();
            listOfItems = itemsToBeTaken;
            itemsToBeTaken = new ArrayList<>(listOfItems);
        }
        return rocketArrayList;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> listOfItems) {
        ArrayList<Rocket> rocketArrayList = new ArrayList<>();
        ArrayList<Item> itemsToBeTaken = new ArrayList<>();
        Rocket rocketU2 = new U2();

        while(!listOfItems.isEmpty()) {
            for(Item item : listOfItems) {
                if(rocketU2.canCarry(item)) {
                    rocketU2.carry(item);
                    System.out.println(item.name + " added.");
                } else itemsToBeTaken.add(item);
            }
            rocketArrayList.add(rocketU2);
            rocketU2 = new U2();
            listOfItems = itemsToBeTaken;
            itemsToBeTaken = new ArrayList<>();
        }
        return rocketArrayList;
    }
}
