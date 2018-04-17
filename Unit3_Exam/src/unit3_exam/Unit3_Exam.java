package unit3_exam;
import java.util.ArrayList;
/**
 *
 * @author Jixer
 */
public class Unit3_Exam {

 public static void main(String[] args) {
  System.out.print("|  Array size  |Selection Sort| Bubble Sort  |  Merge Sort  |  Quick Sort  |  Heap Sort   |  Radix Sort  |");
  for (int i = 50000; i <= 300000; i += 50000) {
   printValue(i);
  }
 }
 
 public static void printValue(int arraySize) {
  int  srtingWidth = 14;
  
  int[] list = new int[arraySize];
  for (int i = 0; i < list.length; i++) {
   list[i] = (int)(Math.random() * 1000000);
  }
  System.out.print("\n|");
  for (int i = 0; i < 7; i++) {
   for (int j = 0; j < srtingWidth; j++) {
    System.out.print("-");
   }
   System.out.print("|");
  }
  
  System.out.printf("\n|%" + srtingWidth + "d|", arraySize);
  
  int[] list2 = new int[arraySize];
  System.arraycopy(list, 0, list2, 0, list.length);  
  long startTime = System.currentTimeMillis();  
  selectionSort(list2);
  long endTime = System.currentTimeMillis();
  long executionTime = endTime - startTime;
  System.out.printf("%" + srtingWidth + "d|", executionTime);
  
  
  list2 = new int[arraySize];
  System.arraycopy(list, 0, list2, 0, list.length);  
  startTime = System.currentTimeMillis();  
  bubbleSort(list2);
  endTime = System.currentTimeMillis();
  executionTime = endTime - startTime;
  System.out.printf("%" + srtingWidth + "d|", executionTime);
  
  list2 = new int[arraySize];
  System.arraycopy(list, 0, list2, 0, list.length);  
  startTime = System.currentTimeMillis();  
  mergeSort(list2);
  endTime = System.currentTimeMillis();
  executionTime = endTime - startTime;
  System.out.printf("%" + srtingWidth + "d|", executionTime);
  
  list2 = new int[arraySize];
  System.arraycopy(list, 0, list2, 0, list.length);  
  startTime = System.currentTimeMillis();  
  quickSort(list2);
  endTime = System.currentTimeMillis();
  executionTime = endTime - startTime;
  System.out.printf("%" + srtingWidth + "d|", executionTime);
  
  list2 = new int[arraySize];
  System.arraycopy(list, 0, list2, 0, list.length);  
  startTime = System.currentTimeMillis();  
  heapSort(list2);
  endTime = System.currentTimeMillis();
  executionTime = endTime - startTime;
  System.out.printf("%" + srtingWidth + "d|", executionTime);
  
  list2 = new int[arraySize];
  System.arraycopy(list, 0, list2, 0, list.length);  
  startTime = System.currentTimeMillis();  
  radixSort(list2, 1000000);
  endTime = System.currentTimeMillis();
  executionTime = endTime - startTime;
  System.out.printf("%" + srtingWidth + "d|", executionTime);
  
  
  
  
 }
 
 public static void selectionSort(int[] list) {
  for (int i = 0; i < list.length - 1; i++) {
   int currentMin = list[i];
   int currentMinIndex = i;

   for (int j = i + 1; j < list.length; j++) {
    if (currentMin > list[j]) {
     currentMin = list[j];
     currentMinIndex = j;
    }
   }
   if (currentMinIndex != i) {
    list[currentMinIndex] = list[i];
    list[i] = currentMin;
   }
  }
 }

 
 
 public static void bubbleSort(int[] list) {
  boolean nextPassNeeded = true;
  for (int k = 1; k < list.length && nextPassNeeded; k++) {
   // Array may be sorted and next pass not needed
   nextPassNeeded = false;
   for (int i = 0; i < list.length - k; i++) {
    if (list[i] > list[i + 1]) {
     // Swap list
     int temp = list[i];
     list[i] = list[i + 1];
     list[i + 1] = temp;
     nextPassNeeded = true; // Next pass needed
    }
   }
  }
 }
 
 
 public static void mergeSort(int[] list) {
  if (list.length > 1) {
   // Merge sort first half
   int[] firstHalf = new int[list.length / 2];
   System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
   mergeSort(firstHalf);

   // Merge sort second half
   int secondHalfLength = list.length - list.length / 2;
   int[] secondHalf = new int[secondHalfLength];
   System.arraycopy(list, list.length / 2, secondHalf, 0,
     secondHalfLength);
   mergeSort(secondHalf);

   // Merge firstHalf with secondHalf into list
   merge(firstHalf, secondHalf, list);
  }
 }
 public static void merge(int[] list1, int[] list2, int[] temp) {
  int current1 = 0; // Current index in list1
  int current2 = 0; // Current index in list2
  int current3 = 0; // Current index in temp

  while (current1 < list1.length && current2 < list2.length) {
   if (list1[current1] < list2[current2])
    temp[current3++] = list1[current1++];
   else
    temp[current3++] = list2[current2++];
  }

  while (current1 < list1.length)
   temp[current3++] = list1[current1++];

  while (current2 < list2.length)
   temp[current3++] = list2[current2++];
 }
 
 
 public static void quickSort(int[] list) {
  quickSort(list, 0, list.length - 1);
 }

 private static void quickSort(int[] list, int first, int last) {
  if (last > first) {
   int pivotIndex = partition(list, first, last);
   quickSort(list, first, pivotIndex - 1);
   quickSort(list, pivotIndex + 1, last);
  }
 }

 
 private static int partition(int[] list, int first, int last) {
  int pivot = list[first]; // Choose the first element as pivot
  int low = first + 1; // Index for forward search
  int high = last; // Index for backward search

  while (high > low) {
   // Search forward from left
   while (low <= high && list[low] <= pivot)
    low++;

   // Search backward from right
   while (low <= high && list[high] > pivot)
    high--;

   // Swap two elements in list
   if (high > low) {
    int temp = list[high];
    list[high] = list[low];
    list[low] = temp;
   }
  }

  while (high > first && list[high] >= pivot)
   high--;

  // Swap pivot with list[high]
  if (pivot > list[high]) {
   list[first] = list[high];
   list[high] = pivot;
   return high;
  } else {
   return first;
  }
 }
 
 
 public static void heapSort(int[] list) {
  // Create a heap of integers
  Heap<Integer> heap = new Heap<Integer>();

  // Add elements to heap
  for (int i = 0; i < list.length; i++)
   heap.add(list[i]);

  // Remove elements from heap
  for (int i = list.length - 1; i >= 0; i--)
   list[i] = heap.remove();
 }
 static class Heap<E extends Comparable<E>> {
  private java.util.ArrayList<E> list = new java.util.ArrayList<E>();

  // Default heap
  public Heap() {
  }

  // Heap of objects
  public Heap(E[] objects) {
   for (int i = 0; i < objects.length; i++)
    add(objects[i]);
  }

  // Add object to heap
  public void add(E newObject) {
   list.add(newObject); 
   int currentIndex = list.size() - 1; // Index of last node

   while (currentIndex > 0) {
    int parentIndex = (currentIndex - 1) / 2;
    // Swap
    if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
     E temp = list.get(currentIndex);
     list.set(currentIndex, list.get(parentIndex));
     list.set(parentIndex, temp);
    } else
     break; // Tree is now heap

    currentIndex = parentIndex;
   }
  }

  public E remove() {
   if (list.size() == 0)
    return null;

   E removedObject = list.get(0);
   list.set(0, list.get(list.size() - 1));
   list.remove(list.size() - 1);

   int currentIndex = 0;
   while (currentIndex < list.size()) {
    int leftChildIndex = 2 * currentIndex + 1;
    int rightChildIndex = 2 * currentIndex + 2;

    // Find the maximum between two children
    if (leftChildIndex >= list.size())
     break; // The tree is a heap
    int maxIndex = leftChildIndex;
    if (rightChildIndex < list.size()) {
     if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
      maxIndex = rightChildIndex;
     }
    }

    // Swap if the current node is less than the maximum
    if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
     E temp = list.get(maxIndex);
     list.set(maxIndex, list.get(currentIndex));
     list.set(currentIndex, temp);
     currentIndex = maxIndex;
    } else
     break; // The tree is a heap
   }

   return removedObject;
  }

  // Get number of nodes
  public int getSize() {
   return list.size();
  }
 }
 
 
 static void radixSort(int[] list, int maxOrder) {
  for (int order = 1; order < maxOrder; order *= 10) {
   @SuppressWarnings("un-checked")
   ArrayList<Integer>[] bucket = new ArrayList[10];
   
   for (int i = 0; i < bucket.length; i++) {
    bucket[i] = new java.util.ArrayList<>();
   }
   
   for (int i = 0; i < list.length; i++) {
    bucket[(list[i] / order) % 10].add(list[i]);
   }
   
   int k = 0;
   for (int i = 0; i < bucket.length; i++) {
    if (bucket[i] != null) {
     for (int j = 0; j < bucket[i].size(); j++)
      list[k++] = bucket[i].get(j);
    }
   }
  }
 }
 

}





