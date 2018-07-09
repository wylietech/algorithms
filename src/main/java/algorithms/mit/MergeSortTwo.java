package algorithms.mit;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// A merge sort is a divide and conquer algorithm. It splits an array in two and recursively
// calls itself to sort the two halves. Once the two halves are sorted the subsections are
// merged back together (which gives it the name)
// In a classic merge sort we just keep splitting until the sub-elements have a size of 1,
// which is intrinsically sorted
// This version uses a class to manage a subarray that we can take from
public class MergeSortTwo {

  private static final Logger log = LoggerFactory.getLogger(MergeSortTwo.class);

  //Entry point - merge sorts the whole array
  public static void mergeSort(int[] A) {
    log.debug(Arrays.toString(A));
    mergeSort(A, 0, A.length - 1);
  }

  //Merge sort the supplied array between elements p and r
  //This method recursively calls itself until everything is sorted
  private static void mergeSort(int[] A, int p, int r) {

    if (p < r) {

      //Split the array in 2
      int q = (p + r) / 2;

      //Merge sort each half
      mergeSort(A, p, q);
      mergeSort(A, q + 1, r);

      //Merge the two sorted sub-arrays back together
      merge(A, p, q, r);
    }

  }

  //We have two sub-arrays (p-q and q-r), both of which are themselves sorted. We need to interleave the
  //two and produce a single sorted array from the pair
  //Basic approach is to look at the smallest from each half and choose it until we have none left
  private static void merge(int[] A, int p, int q, int r) {

    log.debug("Merging Two sorted sub-arrays with P {} Q {} and R {} ...", p, q, r);
    log.debug(Arrays.toString(A));

    SubArray leftHalf = SubArray.create(A, p, q);
    SubArray rightHalf = SubArray.create(A, q + 1, r);

    int counter = 0;
    int chosenItem;

    while (leftHalf.hasMoreData() || rightHalf.hasMoreData()) {

      //If the left pile is empty then take from the right
      if (!leftHalf.hasMoreData()) {
        chosenItem = rightHalf.takeNext();
      }
      //If the right pile is empty then take from the left
      else if (!rightHalf.hasMoreData()) {
        chosenItem = leftHalf.takeNext();
      }
      //Take the smallest
      else {
        if (leftHalf.peekNext() < rightHalf.peekNext()) {
          chosenItem = leftHalf.takeNext();
        } else {
          chosenItem = rightHalf.takeNext();
        }
      }

      //Set the item
      A[p + counter] = chosenItem;
      counter++;
    }

    log.debug("Sub-array merge completed");
    log.debug(Arrays.toString(A));


  }

  static class SubArray {

    private final int data[];
    private final int length;
    private int counter;

    SubArray(int[] data) {
      this.data = data;
      this.length = data.length;
      this.counter = 0;
    }

    static SubArray create(int[] A, int from, int to) {
      return new SubArray(Arrays.copyOfRange(A, from, to + 1));
    }

    boolean hasMoreData() {
      return counter < length;
    }

    int peekNext() {
      return data[counter];
    }

    int takeNext() {
      return data[counter++];
    }
  }
}
