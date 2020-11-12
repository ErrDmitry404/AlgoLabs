
package lab1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadCsvFile {


    protected static List<Shoes> getDataFromFile() {

        var file = new File("shoes.csv");
        List<Shoes> shoesList = new ArrayList<>();

        if (!file.exists()) {
            createFileWithShoesData();
        }
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {

            String line;
            fileReader.readLine();

            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(",");
                shoesList.add(new Shoes(tokens[0], Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2]), (tokens[3])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return shoesList;
    }

    private static void createFileWithShoesData() {

        var shoesList = createShoesList();

        try (FileWriter fileWriter = new FileWriter("shoes.csv")) {

            fileWriter.write(Shoes.getHeaders() + "\n");

            for (Shoes shoes : shoesList) {
                fileWriter.write(shoes.toCSV());
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Shoes> createShoesList() {
        List<Shoes> shoesList = new ArrayList<>();
        shoesList.add(new Shoes("Shoes1", 10F, 3F, "Blue"));
        shoesList.add(new Shoes("Shoes2", 20F, 25F, "Red"));
        shoesList.add(new Shoes("Shoes3", 11.5F, 31F, "Pink"));
        shoesList.add(new Shoes("Shoes4", 13.8F, 3F, "Green"));
        shoesList.add(new Shoes("Shoes5", 21.1F, 30F, "Blue"));
        shoesList.add(new Shoes("Shoes6", 25.4F, 23F, "Yellow"));
        shoesList.add(new Shoes("Shoes7", 24.3F, 33F, "Brown"));
        shoesList.add(new Shoes("Shoes8", 16.7F, 60F, "Purple"));
        shoesList.add(new Shoes("Shoes9", 18.4F, 12F, "Orange"));
        shoesList.add(new Shoes("Shoes10", 19F, 18F, "White"));
        return shoesList;
    }
 }
