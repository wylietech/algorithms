package algorithms.mit;

//An insertion sort works its way along the array, taking an item and looking for its
//correct position in the sorted portion on the left. it shuffles items along in the array
//on the left until it finds the correct location, at which point it inserts it
//
//the array is sorted 'in-place' - so that the supplied array is sorted when we are done
public class InsertionSort {


  public static void insertionSort(int[] A) {
    insertionSortImpl(A, true);
  }

  public static void insertionSortInReverseOrder(int[] A) {
    insertionSortImpl(A, false);
  }

  private static void insertionSortImpl(int[] A, boolean ascending) {

    //If there is just one (or no) elements it is always correctly sorted
    int length = A.length;

    if (length < 2) {
      return;
    }

    //Work our way along the array, starting with the second item
    for (int j = 1; j < length; j++) {

      int currentItem = A[j];

      //Now slide this item to the left (shuffling everything along to make space for it
      //until it is in the correct position
      int i = j - 1;

      while (i >= 0 && (ascending ? A[i] > currentItem : A[i] < currentItem)) {

        //Shuffle the item along to make space
        A[i + 1] = A[i];
        i--;
      }

      //When we exit the loop we are in the correct place to insert the item
      //but because of the extra i-- we need to add one again
      A[i + 1] = currentItem;

    }

    //End of the for loop = we are all done
  }
}
