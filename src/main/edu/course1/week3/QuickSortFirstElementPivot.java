package main.edu.course1.week3;

public class QuickSortFirstElementPivot {
    public static int partitionArray(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low;
        for (int j = low + 1; j <= high; j++) {
            if (array[j] < pivot) {
                i++;
                QuickSortGeneral.swap(array,i, j);
            }
        }
        QuickSortGeneral.swap(array, i,low);
        return i;
    }

}

// Ans: 162085
