import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int A[] = {4, 6, 7, 8, 12, 9, 0, 15, 1, 2, 3, 4, 5};
//        insertionSort(A);
        mergeSort(A);
        System.out.println(Arrays.toString(A));
    }

    private static void insertionSort(@NotNull int A[]) {
        for (int j = 1; j < A.length; j++) {
            int key = A[j];
//        Insert A[j] into the sorted sequence A[1..j-1].
            int i = j - 1;
            while (i >= 0 && A[i] > key) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = key;
        }
    }

    //    @SuppressWarnings("rawtypes")
    private static void mergeSort(@NotNull int[] list) {
        //If list is empty; no need to do anything
        if (list.length <= 1) {
            return;
        }

        //Split the array in half in two parts
        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        //Sort each half recursively
        mergeSort(first);
        mergeSort(second);

        //Merge both halves together, overwriting to original array
        merge(first, second, list);
    }

    //    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void merge(@NotNull int[] first, int[] second, int[] result) {
        //Index Position in first array - starting with first element
        int iFirst = 0;

        //Index Position in second array - starting with first element
        int iSecond = 0;

        //Index Position in merged array - starting with first position
        int iMerged = 0;

        //Compare elements at iFirst and iSecond,
        //and move smaller element at iMerged
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] - second[iSecond] < 0) {
                result[iMerged] = first[iFirst];
                iFirst++;
            } else {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        //copy remaining elements from both halves - each half will have already sorted elements
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }
}
