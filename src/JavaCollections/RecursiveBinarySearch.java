package JavaCollections;

import java.util.*;

/**
 * Created by marin on 2/25/16.
 *
 * Binary search is an algorithm that works on already sorted arrays.
 * Basically, it goes to the middle element and checks it has to
 * continue searching to the left, or to the right.
 * Return the index of the element, or -1, if the element is not found.
 *
 */
public class RecursiveBinarySearch {

    private static int recursiveBinarySearch(int[] sortedArray, int target) {
        return recursiveBinarySearch(sortedArray, 0, sortedArray.length-1, target);
    }

    private static int recursiveBinarySearch(int[] sortedArray, int start, int end, int target) {
        int middle = (start + end) / 2;
        if (end < start) {
            return -1;
        }

        if (target == sortedArray[middle]) {
            return middle;
        } else if (target < sortedArray[middle]) {
            return recursiveBinarySearch(sortedArray, start, middle-1, target);
        } else {
            return recursiveBinarySearch(sortedArray, middle+1, end, target);
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("What number are you looking for?");
        int x = input.nextInt();
        input.nextLine();

        System.out.println("Enter sequence of numbers:");
        String[] strNums = input.nextLine().split(" ");

        int[] numbers = new int[strNums.length];
        for (int i = 0; i < strNums.length; i++) {
            numbers[i] = Integer.parseInt(strNums[i]);
        }
        Arrays.sort(numbers);

        System.out.println(recursiveBinarySearch(numbers, x));

    }
}
