package algorithms;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class ArraySorterTest {

  @Test
  void canSortArray() {

    int[] testData = {7, 1, 3, 2, 6, 9, 4, 8, 5, 10};
    int[] results = ArraySorter.sortArray(testData);
    checkArrayIsSorted(results);
  }

  //Check that the supplied array is correctly sorted
  private void checkArrayIsSorted(int[] data) {
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


