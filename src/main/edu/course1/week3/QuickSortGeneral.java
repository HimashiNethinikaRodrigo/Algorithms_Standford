package main.edu.course1.week3;

import main.edu.course1.Utils;

public class QuickSortGeneral {
    public static final String readFile = ".//src/main/edu/course1/week3/QuickSort.txt";
    public static int quickSort(int[] array, int low, int high, String type) {
        if (low < high) {
            int partitionValue= -1;
            switch (type){
                case "first":
                    partitionValue = QuickSortFirstElementPivot.partitionArray(array, low, high);
                    break;
                case "last":
                    partitionValue = QuickSortLastElementPivot.partitionArray(array, low, high);
                    break;
                case "middle":
                    partitionValue = QuickSortMiddleElementPivot.partitionArray(array, low, high);
                    break;

            }
            int a1 = quickSort(array, low, partitionValue - 1, type);
            int a2 = quickSort(array, partitionValue + 1, high, type);
            return a1 + a2 + high - low;
        } else {
            return 0;
        }
    }

    public static void swap(int[] array, int i, int j){
        int temp =array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array1 = Utils.readInputFile(readFile, 10000);
        int[] array2 = Utils.readInputFile(readFile, 10000);
        int[] array3 = Utils.readInputFile(readFile, 10000);

//        for (int a : array) {
//            System.out.print(a + " , ");
//        }
//        System.out.println();
//        System.out.println("---------------------------------------------");
//        int comparison = quickSort(array, 0, array.length - 1);
//        System.out.println("Comparison from recursion " +comparison);
//        for (int a : array) {
//            System.out.print(a + " , ");
//        }
//        System.out.println();
//        System.out.println(comparisons);
        int comparisonFirstPivot = quickSort(array1, 0, array1.length-1,"first");
        int comparisonLastPivot = quickSort(array2, 0, array2.length-1, "last");
        int comparisonMiddlePivot = quickSort(array3, 0, array3.length-1, "middle");

        System.out.println("First:  "+comparisonFirstPivot);
        System.out.println("Last:   "+comparisonLastPivot);
        System.out.println("Middle: "+comparisonMiddlePivot);
    }
}
