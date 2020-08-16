package main.edu.course1.week3;

public class QuickSortLastElementPivot {
    public static int partitionArray(int[] array, int low, int high) {
        QuickSortGeneral.swap(array, low, high);
        return QuickSortFirstElementPivot.partitionArray(array, low, high);
    }


}
