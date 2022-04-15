import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    // Constructor - default

    // Methods
    public ArrayList<Item> loadItems(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        ArrayList<Item> listOfItems = new ArrayList<>();

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitter = line.split("=");
            int weight = 0;
            listOfItems.add(new Item(splitter[0], Integer.parseInt(splitter[1])));
        }

        return listOfItems;
    }
}
