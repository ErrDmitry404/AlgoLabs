package lab1;

import java.util.List;

import static lab1.SortMethods.*;

public class Main {

    public static void main(String[] args) {
        List<Shoes> dataFromFile = WriteAndReadCsvFile.getDataFromFile();

        selectionSortShoesByPriceDesc(dataFromFile);

        System.out.println("Selection Algorithm");
        System.out.println("Work time: " + selectionTimeInMillis);
        System.out.println("Swaps: " + selectionSwapCounter);
        System.out.println("Comparisons: " + selectionCompareCounter);
        for (Shoes shoes : dataFromFile) {
            System.out.println(shoes);
        }

        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        quickSortShoesByPriceAsc(dataFromFile);

        System.out.println("Quick Algorithm");
        System.out.println("Work time: " + quickTimeInMillis);
        System.out.println("Swaps: " + quickSwapCounter);
        System.out.println("Comparisons: " + quickCompareCounter);
        for (Shoes shoes : dataFromFile) {
            System.out.println(shoes);
        }
    }
}