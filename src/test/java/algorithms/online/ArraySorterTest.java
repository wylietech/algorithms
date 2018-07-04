package algorithms.online;

import static org.assertj.core.api.Fail.fail;

import org.junit.Test;

class ArraySorterTest {

  private static final int[] SIMPLE_RANDOM_LIST = {7, 1, 3, 2, 6, 9, 4, 8, 5, 10};
  private static final int[] REVERSE_SORTED_LIST = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

  @Test
  void canSortUsingSearchAlgorithm() {
    checkResultIsSorted(ArraySorter.searchSortArray(SIMPLE_RANDOM_LIST));
  }

  @Test
  void canSortUsingBubbleAlgorithm() {
    checkResultIsSorted(ArraySorter.bubbleSortArray(SIMPLE_RANDOM_LIST));
  }

  @Test
  void canISortUsingInsertAlgorithm() {
    checkResultIsSorted(ArraySorter.insertSortArray(SIMPLE_RANDOM_LIST));
  }

  @Test
  void canSortReversedArrayUsingInsertAlgorithm() {
    checkResultIsSorted(ArraySorter.insertSortArray(REVERSE_SORTED_LIST));
  }

  //Check that the supplied array is correctly sorted
  private void checkResultIsSorted(int[] data) {
    //An array with less that two elements must by definition be sorted
    if (data.length < 2) {
      return;
    }

    for (int i = 0; i < data.length - 1; i++) {
      if (data[i + 1] < data[i]) {
        fail("Array is not sorted - item" + i + 1 + " is not greater or equal to item " + i);
      }
    }
  }
}


