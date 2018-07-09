package algorithms.mit;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// A merge sort is a divide and conquer algorithm. It splits an array in two and recursively
// calls itself to sort the two halves. Once the two halves are sorted the subsections are
// merged back together (which gives it the name)
// In a classic merge sort we just keep splitting until the sub-elements have a size of 1,
// which is intrinsically sorted
public class MergeSort {

  private static final Logger log = LoggerFactory.getLogger(MergeSort.class);

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

    int length = r - p;

    //Naive approach, copy the two arrays
    int[] leftHalf = Arrays.copyOfRange(A, p, q + 1);
    int[] rightHalf = Arrays.copyOfRange(A, q + 1, r + 1);

    int lCounter = 0;
    int rCounter = 0;
    int chosenItem;

    for (int i = 0; i <= length; i++) {

      //If the left pile is empty then take from the right
      if (lCounter == leftHalf.length) {
        chosenItem = rightHalf[rCounter];
        rCounter++;
      }
      //And vice versa
      else if (rCounter == rightHalf.length) {
        chosenItem = leftHalf[lCounter];
        lCounter++;
      }
      //otherwise find the smallest of the two
      else {
        if (leftHalf[lCounter] < rightHalf[rCounter]) {
          chosenItem = leftHalf[lCounter];
          lCounter++;
        } else {
          chosenItem = rightHalf[rCounter];
          rCounter++;
        }
      }

      A[p + i] = chosenItem;
    }

    log.debug("Sub-array merge completed");
    log.debug(Arrays.toString(A));


  }
}
