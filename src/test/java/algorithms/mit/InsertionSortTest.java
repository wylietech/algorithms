package algorithms.mit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import org.junit.Test;

public class InsertionSortTest {

  @Test
  public void canSortSimpleArray() {

    int[] data = {3, 9, 1, 7, 4, 5};
    InsertionSort.insertionSort(data);
    assertThat(data).isSorted();

  }

  @Test
  public void canSortNegatives() {
    int[] data = new int[]{-4, 99, 0, -12};
    InsertionSort.insertionSort(data);
    assertThat(data).isSorted();

  }

  @Test
  public void canSortZeros() {
    int[] data = new int[]{0, 0, 0, 0, 0};
    InsertionSort.insertionSort(data);
    assertThat(data).isSorted();

  }

  @Test
  public void canSortReverse() {
    int[] data = {3, 9, 1, 7, 4, 5};
    InsertionSort.insertionSortInReverseOrder(data);
    assertThat(data).isSortedAccordingTo(Comparator.reverseOrder());
  }
}
