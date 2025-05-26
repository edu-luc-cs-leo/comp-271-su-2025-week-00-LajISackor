import java.util.Arrays; // from printing array
/**
 * A class to demonstrate minimum heap operations using arrays
 */

 /*
 * EXPLANATION OF LOOPS:
 * 
 * First loop:
 * for (int i = 0; i < smallest_index; i++)
 * Copies all elements before the smallest element to the same positions in `temporary`.
 * 
 * Second loop:
 * for (int i = smallest_index + 1; i < arr.length; i++)
 * Skips the smallest element and shifts later elements one spot to the left.
 * This is why we use: temporary[i - 1] = arr[i];
 * 
 * Goal:
 * To remove the smallest value by copying over everything except that element.
 * 
 * Result:
 * The arr is updated to a shorter array with the smallest element removed.
 */

public class Realistic {

    /** Set up our test array. */
    static int[] arr = { 10, -5, 11, 2 };

    /**
     * Scan the entire array to find and remove its smallest value.
     * The method uses array arr[] created above.
     * 
     * @return int with the smallest value in array arr
     */
    public static int getSmallest() {
        // Assume smallest is first element
        int smallest_index = 0;
        // Scan the remaining elements, replacing the position of the smallest element
        // with the position of any element found to be smaller.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[smallest_index]) {
                // found new smallest, update index
                smallest_index = i;
            }
        }
        // When loop is done, smallest_index points to smallest element. Save it in a
        // variable so that we can return its value when we are done.
        int result = arr[smallest_index];
        // Prepare to shrink the processed array by one element, effectively removing
        // its smallest element. A temporary array will hold the remaining elements.
        int[] temporary = new int[arr.length - 1];

        /*
         * Use two loops to copy the elements of arr[] to temporary[], except for the
         * smallest element. The first loop copies all the elements before the smallest
         * element and the second loop the elements after it.
         */
        for (int i = 0; i < smallest_index; i++) {
            temporary[i] = arr[i];
        }
        for (int i = smallest_index + 1; i < arr.length; i++) {
            temporary[i - 1] = arr[i];
        }
        /*
         * Same result with a while loop
         * 
         * int temp_index = 0;
         * int arr_index = 0;
         * while (arr_index < arr.length) {
         *   if (arr_index != smallest_index) {
         *     temporary[temp_index] = arr[arr_index];
         *     temp_index++;
         *   }
         *   arr_index++;
         * }
         */

        arr = temporary; // array shorted by 1 (removing smallest elem)
        return result; // smallest element
    } // method getSmallest

     /**
     * Add a new value to the end of the array.
     * The method increases the size of arr by one,
     * copies all previous elements, and appends the new value at the end.
     *
     * @param value the value to be added to the array
     */
    public static void add(int value) {
        // Step 1: Create a new array one element larger
        int[] bigger = new int[arr.length + 1];

        // Step 2: Copy elements from original array to new array
        for (int i = 0; i < arr.length; i++) {
            bigger[i] = arr[i];
        }

        // Step 3: Insert the new value at the last index
        bigger[bigger.length - 1] = value;

        // Step 4: Update arr to refer to the new array
        arr = bigger;
    }

    /** Driver/simple test code */
    public static void main(String[] args) {
        System.out.printf("\n\nArray before removal of smallest element: %s",
                Arrays.toString(arr));
        System.out.printf("\nSmallest element found: %d", getSmallest());
        System.out.printf("\nArray after removal of smallest element: %s\n\n",
                Arrays.toString(arr));
    } // method main

} // class Realistic