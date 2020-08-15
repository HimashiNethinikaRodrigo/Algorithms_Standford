package main.edu.course1.week2;

import main.edu.course1.Utils;


public class Inversions {
    public static final String readFile = ".//src/main/edu/course1/week2/IntegerArray.txt";

    private static long sort(int[] array, int[] sortedArray, int left, int right ){
        int size = array.length;
        int mid ;
        long inversionCount = 0L;
        if (left < right){
            mid = (left+right)/2;
            inversionCount = sort(array, sortedArray, left, mid);
            inversionCount += sort(array, sortedArray, mid + 1, right);
            inversionCount += merge(array, sortedArray, left, mid + 1, right);
        }
        return inversionCount;
    }
    private static long merge(int[] array, int[] sortedArray,int left, int mid, int right ){
        int i, j, k;
        long inversionCount = 0L;

        i = left;
        j = mid;
        k = left;
        while ((i <= mid - 1) && (j <= right)) {
            if (array[i] <= array[j]) {
                sortedArray[k++] = array[i++];
            }
            else {
                sortedArray[k++] = array[j++];
                inversionCount +=  (mid - i);
            }
        }
        while (i <= mid - 1)
            sortedArray[k++] = array[i++];

        while (j <= right)
            sortedArray[k++] = array[j++];

        for (i = left; i <= right; i++)
            array[i] = sortedArray[i];

        return inversionCount;
    }
    public static void main(String[] args) {
        int[] array = Utils.readInputFile(readFile, 100000);

        int[] sortedArray = new int[array.length];
        System.out.println("Number of inversions are "
                + sort(array, sortedArray, 0, (array.length - 1)));
    }
}
