package com.company;

public class Main {

    // Insertion Sort Algorithm
    static void insertionSort(int[] numbers, int arraySize) {
        int i = 0;
        int j = 0;
        int temp = 0; // Temporary variable for swap

        for (i = 1; i < arraySize; ++i) {
            j = i;
            // Insert numbers[i] into sorted part
            // stopping once numbers[i] in correct position
            while (j > 0 && numbers[j] < numbers[j - 1]) {

                // Swap numbers[j] and numbers[j - 1]
                temp = numbers[j];
                numbers[j] = numbers[j - 1];
                numbers[j - 1] = temp;
                --j;
            }
        }
    }

    // helper method for shellSort method
    static void insertionSortInterleaved(int [] numbers, int numbersSize, int startIndex, int gap) {
        int i = 0;
        int j = 0;
        int temp = 0; // Temporary variable for swap

        for (i = startIndex + gap; i < numbersSize; i = i + gap) {
            j = i;
            while (j - gap >= startIndex && numbers[j] < numbers[j - gap]) {
                temp = numbers[j];
                numbers[j] = numbers[j - gap];
                numbers[j - gap] = temp;
                j = j - gap;
            }
        }
    }

    // Shell Sort Algorithm
    static void shellSort(int[] numbers, int numbersSize, int[] gapValues) {

        for(int gapValue : gapValues) {
            for (int i = 0; i < gapValue; i++) {
                insertionSortInterleaved(numbers, numbersSize, i, gapValue);
            }
            System.out.println("\n   Array after gap value: " + gapValue);
            for(int num: numbers) {
                System.out.print("   " + num + "   ");
            }
        }
    }

    // HeapSort helper method
    static void maxHeapPercolateDown(int nodeIndex, int[] heapArray, int arraySize) {
        int childIndex = 2 * nodeIndex + 1;
        int value = heapArray[nodeIndex];

        while (childIndex < arraySize) {
            // Find the max among the node and all the node's children
            int maxValue = value;
            int maxIndex = -1;
            for (int i = 0; i < 2 && i + childIndex < arraySize; i++) {
                if (heapArray[i + childIndex] > maxValue) {
                    maxValue = heapArray[i + childIndex];
                    maxIndex = i + childIndex;
                }
            }

            if (maxValue == value) {
                return;
            }
            else {
                // Swap
                int temp = heapArray[nodeIndex];
                heapArray[nodeIndex] = heapArray[maxIndex];
                heapArray[maxIndex] = temp;
                nodeIndex = maxIndex;
                childIndex = 2 * nodeIndex + 1;
            }
        }
    }

    // HeapSort Algorithm
    static void heapSort(int[] numbers, int size) {
        // Heapify numbers array
        for (int i = size / 2 - 1; i >= 0; i--)
            maxHeapPercolateDown(i, numbers, size);

        int temp = 0;
        for (int i = size - 1; i > 0; i--) {
            // swap
            temp = numbers[0];
            numbers[0] = numbers[i];
            numbers[i] = temp;
            maxHeapPercolateDown(0, numbers, i);
        }
    }

    public static void main(String[] args) {

        int[] numbers = { 3, 1, 4, 1, 5, 9, 2, 6, 5 };
        int arraySize = numbers.length;


        System.out.println("\nUnsorted: ");
        for(int num: numbers) {
            System.out.print(num + " ");
        }

        // Sort using Insertion Sort Algorithm
        insertionSort(numbers, arraySize);

        System.out.println("\nSorted with Insertion Sort: ");
        for(int num : numbers) {
            System.out.print(num + " ");
        }

        System.out.println();

        int[] numbers2  = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int arraySize2  = numbers2.length;
        int[] gapValues = { 7, 3, 1 };

        System.out.println("\nUnsorted");
        for(int num: numbers2) {
            System.out.print(num + " ");
        }

        // Sort using Shell Sort Algorithm
        shellSort(numbers2, arraySize2, gapValues);
        System.out.println("\nSorted with Shell Sort:");
        for(int num: numbers2) {
            System.out.print(num + " ");
        }

        System.out.println();

        int[] numbers3 = { 142, 543, 123, 65, 453, 879, 572, 434, 111, 242, 811, 102 };
        int arraySize3 = numbers3.length;

        System.out.println("\nUnsorted");
        for(int num: numbers3) {
            System.out.print(num + " ");
        }

        // Sort using Heapsort Algorithm
        heapSort(numbers3, arraySize3);
        System.out.println("\nSorted with Heapsort:");
        for(int num: numbers3) {
            System.out.print(num + " ");
        }
    }
}
