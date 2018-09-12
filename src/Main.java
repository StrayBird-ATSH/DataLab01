import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int length = 10000;
        int A[] = new int[length];

        for (int i = 0; i < length; i++)
            A[i] = length - i;
        long time = System.currentTimeMillis();
//        insertionSort(A);
        mergeSort(A);
        System.out.println("The time used is: " +
                (System.currentTimeMillis() - time) + " milliseconds");
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
//        Simply return terminate this function if the list meets the end
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
        /*
         *Index Position in left array, right array and the merged array,
         *All starting from the left
         * */
        int indexLeft = 0, indexRight = 0, indexMerged = 0;

        /*
         * Compare the elements at the index position from the left array and
         * the right array, and pull the smaller one down to the merged array to
         * continuously combine the two arrays in order.
         * */
        while (indexLeft < left.length && indexRight < right.length) {
            if (left[indexLeft] - right[indexRight] < 0) {
                result[indexMerged] = left[indexLeft];
                indexLeft++;
            } else {
                result[indexMerged] = right[indexRight];
                indexRight++;
            }
            indexMerged++;
        }
//        Directly copy the sorted elements from the origin
        System.arraycopy(left, indexLeft, result,
                indexMerged, left.length - indexLeft);
        System.arraycopy(right, indexRight, result,
                indexMerged, right.length - indexRight);
    }
}
