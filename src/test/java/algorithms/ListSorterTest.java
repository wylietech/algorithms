package algorithms;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ListSorterTest {

  @Test
  void canSortList() {
    Integer[] testData = new Integer[]{7, 2, 1, 3, 4, 9, 8, 6, 0, 5};
    List<Integer> results = ListSorter.sort(Arrays.asList(testData));
    checkListIsSorted(results);
  }

  //TODO Work out how to not get a warning on this array
  /*
  @Test
  void emptyListIsReturnedUnchanged() {
    Integer[] testData = new Integer[]{};
    List<Integer> results = ListSorter.sort(Arrays.asList(testData));
    assertEquals(0, results.size());
  }
  */

  @Test
  void alreadySortedListIsReturnedUnchanged() {
    Integer[] testData = new Integer[]{7, 8, 9, 10, 11};
    List<Integer> results = ListSorter.sort(Arrays.asList(testData));
    checkListIsSorted(results);

  }


  private void checkListIsSorted(List<Integer> data) {
    //An array with less that two elements must by definition be sorted
    if (data.size() < 2) {
      return;
    }

    for (int i = 1; i < data.size(); i++) {
      if (data.get(i - 1) > data.get(i)) {
        fail("Array is not sorted - item" + i + 1 + " is not greater or equal to item " + i);
      }
    }
  }

}
