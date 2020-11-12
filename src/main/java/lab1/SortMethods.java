package lab1;


import java.util.List;

public class SortMethods {

    public static int selectionSwapCounter;
    public static int selectionCompareCounter;
    public static double selectionTimeInMillis;

    public static int quickSwapCounter;
    public static int quickCompareCounter;
    public static double quickTimeInMillis;

    public static void selectionSortShoesByPriceDesc(List<Shoes> shoesArray) {
        var startTime = System.nanoTime();
        for (int i = 0; i < shoesArray.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < shoesArray.size(); j++) {
                if (shoesArray.get(j).getPrice() > shoesArray.get(minIndex).getPrice()) {
                    minIndex = j;
                }
                selectionCompareCounter++;
            }
            swap(shoesArray, minIndex, i);
            selectionSwapCounter++;
        }
        selectionTimeInMillis = (System.nanoTime() - startTime) / 1000D;
    }

    public static void quickSortShoesByPriceAsc(List<Shoes> shoesList) {
        var startTime = System.nanoTime();
        quickSort(shoesList, 0, shoesList.size() - 1);
        quickTimeInMillis = (System.nanoTime() - startTime) / 1000D;
    }

    private static void quickSort(List<Shoes> shoesList, int low, int high) {
        if (low < high) {
            int pi = partition(shoesList, low, high);
            quickSort(shoesList, low, pi - 1);
            quickSort(shoesList, pi + 1, high);
        }
    }

    private static int partition(List<Shoes> shoesList, int low, int high) {
        var pivot = shoesList.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (shoesList.get(j).getPrice() < pivot.getPrice()) {
                i++;
                swap(shoesList, i, j);
                quickSwapCounter++;
            }
            quickCompareCounter++;
        }
        swap(shoesList, i + 1, high);
        quickSwapCounter++;
        return i + 1;
    }

    private static void swap(List<Shoes> array, int firstElement, int secondElement) {
        var temp = array.get(firstElement);
        array.set(firstElement, array.get(secondElement));
        array.set(secondElement, temp);
    }
}