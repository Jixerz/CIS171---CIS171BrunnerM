package exercise23_12;
import java.util.ArrayList;
/**
 *
 * @author Jixer
 */
public class Exercise23_12 {

 public static void main(String[] args) {
  int maximumOrder = 1000000;
  int[] list = new int[1000000]; 
  for (int i = 0; i < list.length; i++) {
   list[i] = (int) (Math.random() * maximumOrder);
  }
  long time = System.currentTimeMillis();
  radixSort(list, maximumOrder);
  System.out.println("Time in milliseconds: " + (System.currentTimeMillis() - time));
 }

 static void radixSort(int[] list, int maximumOrder) {
  for (int order = 1; order < maximumOrder; order *= 10) {
   @SuppressWarnings("unchecked")
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
