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

    private static void mergeSort(@NotNull int[] A) {
//        Simply return terminate this function if the list
//         meets the end
        if (A.length <= 1)
            return;


        //Divide the n-element sequence to be sorted into two sub-sequences
//        of n/2 elements each
        int[] left = new int[A.length / 2];
        int[] right = new int[A.length - left.length];
        System.arraycopy(A, 0, left, 0, left.length);
        System.arraycopy(A, left.length, right, 0, right.length);

        //Sort the two sub-sequences recursively using merge sort
        mergeSort(left);
        mergeSort(right);

        //Merge the two sorted sub-sequences to produce the sorted answer
        merge(left, right, A);
    }

    private static void merge(@NotNull int[] left, int[] right, int[] result) {
        //Index Position in left array - starting with left element
        int iForLeft = 0;

        //Index Position in right array - starting with left element
        int iForRight = 0;

        //Index Position in merged array - starting with left position
        int iMerged = 0;

        //Compare elements at iForLeft and iForRight,
        //and move smaller element at iMerged
        while (iForLeft < left.length && iForRight < right.length) {
            if (left[iForLeft] - right[iForRight] < 0) {
                result[iMerged] = left[iForLeft];
                iForLeft++;
            } else {
                result[iMerged] = right[iForRight];
                iForRight++;
            }
            iMerged++;
        }
        //copy remaining elements from both halves - each half will have already sorted elements
        System.arraycopy(left, iForLeft, result, iMerged, left.length - iForLeft);
        System.arraycopy(right, iForRight, result, iMerged, right.length - iForRight);
    }
}
