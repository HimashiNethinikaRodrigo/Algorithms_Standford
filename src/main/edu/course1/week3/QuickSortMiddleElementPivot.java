package main.edu.course1.week3;

public class QuickSortMiddleElementPivot {
    private static int chooseMedianOfThreePivot(int[] array, int low, int high){
        int first = array[low];//a
        int mid;//b
        int midElement;
        int last = array[high];//c
        int length = (high+1-low);
        midElement =  (length % 2==0)? low+(length / 2 - 1): low+(length / 2);
        mid = array[midElement];
        if (first> mid){ //b<a
            if (first<last) //b<a<c
                return low;
            if (mid>last) //c<b<a
                return midElement;
            return high;//b<a
        }
        if (first<last) {
            if (mid>last) {
                return high;
            }
            return midElement;
        }
        return low;
    }

    public static int partitionArray(int[] array, int low, int high) {
        int pivotIndex = chooseMedianOfThreePivot(array, low, high);
        QuickSortGeneral.swap(array, low, pivotIndex);
        return QuickSortFirstElementPivot.partitionArray(array, low, high);
    }

}
