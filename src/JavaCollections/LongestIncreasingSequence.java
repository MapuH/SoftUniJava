package JavaCollections;

import java.util.*;

/**
 * Created by marin on 2/18/16.
 *
 * Write a program to find all increasing sequences inside an array of integers.
 * The integers are given in a single line, separated by a space.
 * Print the sequences in the order of their appearance in the input array,
 * each at a single line. Separate the sequence elements by a space.
 * Find also the longest increasing sequence and print it at the last line.
 * If several sequences have the same longest length, print the leftmost of them.
 *
 * Note: the count of the input numbers is not explicitly specified,
 * so you might need to read the sequence as string,
 * then split it by a space and finally parse the obtained tokens
 * to take their integer values.
 *
 */
public class LongestIncreasingSequence {

    public static void main(String[] args) {

        System.out.println("Enter sequence of integers:");
        Scanner input = new Scanner(System.in);
        String[] strNums = input.nextLine().split(" ");

        int[] numbers = new int[strNums.length];
        for (int i = 0; i < strNums.length; i++) {
            numbers[i] = Integer.parseInt(strNums[i]);
        }

        // list of integers to keep the current sequence and list of Integer lists to keep all sequences
        List<List<Integer>> allSequences = new ArrayList<>();
        List<Integer> sequence = new ArrayList<>();

        // We start from the first value in the int array
        // if next value is greater, then it's part of the sequence so we keep it in the sequence list
        // otherwise next value is the start of a new sequence
        for (int i = 0; i < numbers.length ; i++) {
            if (i == numbers.length - 1) {
                sequence.add(numbers[i]);
                allSequences.add(sequence);

                for (int num : sequence) {
                    System.out.print(num + " ");
                }
                System.out.print("\r\n");
                break;
            }

            if (numbers[i+1] > numbers[i]) {
                sequence.add(numbers[i]);
            } else {
                sequence.add(numbers[i]);
                ArrayList<Integer> saveSeq = new ArrayList<>(sequence);
                allSequences.add(saveSeq);

                for (int num : saveSeq) {
                    System.out.print(num + " ");
                }
                System.out.print("\r\n");

                sequence.clear();
            }
        }

        //Starting with the first sequence as a reference, we iterate till we find the longest sequence
        List<Integer> longestSeq = new ArrayList<>(allSequences.get(0));
        for (List<Integer> seq : allSequences) {
            if (seq.size() > longestSeq.size()) {
                longestSeq = seq;
            }
        }

        System.out.print("Longest:");
        for (int n : longestSeq) {
            System.out.print(" " + n);
        }

    }
}
