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

  private void checkListIsSorted(List<Integer> data) {
    //An array with less that two elements must by definition be sorted
    if (data.size() < 2) {
      return;
    }

    for (int i = 0; i < data.size() - 1; i++) {
      if (data.get(i + 1) < data.get(i)) {
        fail("Array is not sorted - item" + i + 1 + " is not greater or equal to item " + i);
      }
    }
  }

}
